package com.jag.thread.WaitAndNotify;

/**
 * 多线程之间需要协调工作，
 * 例如，浏览器的一个显示图片的线程DisplayThread想要执行显示图片的任务，
 * 必须等待下载线程DownloadThread将该图片下载完毕
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
					p.wait(); // 导致本线程暂停
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
