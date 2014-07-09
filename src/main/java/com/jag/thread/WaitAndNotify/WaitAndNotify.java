package com.jag.thread.WaitAndNotify;

/**
 * ���߳�֮����ҪЭ��������
 * ���磬�������һ����ʾͼƬ���߳�DisplayThread��Ҫִ����ʾͼƬ������
 * ����ȴ������߳�DownloadThread����ͼƬ�������
 * @author jag522
 *
 */
class PictureService {
	boolean isDownloadFinished = false;
	
	public void download() {
		System.out.println("downloading...");
	}
	
	public void display() {
		System.out.println("the picture is displayed");
	}
}

class DisplayThread extends Thread {
	PictureService p;

	public DisplayThread(PictureService p) {
		this.p = p;
		start();
	}

	public void run() {
		synchronized (p) {
			while (!p.isDownloadFinished) {
				try {
					p.wait(); // ���±��߳���ͣ
				} catch (Exception e) {
				}
			}
			p.display();
		}
	}
}

class DownloadThread extends Thread {
	PictureService p;

	public DownloadThread(PictureService p) {
		this.p = p;
		start();
	}

	public void run() {
		synchronized (p) {
			try {
				p.download();
				sleep(2000);
			} catch (Exception e) {
			}
			p.isDownloadFinished = true;
			p.notify();
			System.out.println("download finished");
		}
	}
}

public class WaitAndNotify {
	public static void main(String[] args) {
		PictureService p = new PictureService();
		new DisplayThread(p);
		new DownloadThread(p);
	}
}
