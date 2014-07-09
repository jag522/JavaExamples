package com.jag.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPTest {
	public static boolean isReachable(String ip) {
		// URL url = null;
		// try {
		// url = new URL("http://google.com/");
		// InputStream in = url.openStream();
		// System.out.println("��������");
		// in.close();
		// } catch (IOException e) {
		// System.out.println("�޷����ӵ���" + url.toString());
		// }

		// Java1.5�汾��֧��isReachable����
		// try {
		// InetAddress ad = InetAddress.getByName("172.16.45.1");
		// boolean state = ad.isReachable(5000);// �����Ƿ���Դﵽ�õ�ַ
		// if (state)
		// System.out.println("���ӳɹ�" + ad.getHostAddress());
		// else
		// System.err.println("����ʧ��");
		// } catch (UnknownHostException e) {
		// System.err.println("����ʧ��");
		// } catch(IOException e) {
		// e.printStackTrace();
		// }

		//ʵ�־����Ŭ����ͼ����������������ǽ�ͷ��������ÿ�����������ʹ����ĳЩ�ض��Ķ˿ڿ��Է���ʱ���ڲ��ɵ���״̬��
		try {
			//cmd /c          ִ���ַ���ָ��������Ȼ���ն�
			//ping -n count   Number of echo requests to send.
			Process p = Runtime.getRuntime().exec("cmd /c ping -n 1 " + ip); // �˴�1���������Ӿ�ȷ�ȣ���Ӱ������ٶ�
			BufferedReader in = new BufferedReader(new InputStreamReader(p
					.getInputStream()));
			String temp = null;
			StringBuffer strBuffer = new StringBuffer();
			while ((temp = (in.readLine())) != null)
				strBuffer.append(temp);
//			 System.out.println(strBuffer);
			if (strBuffer.toString().matches(".*\\(\\d?\\d% loss\\).*")) { // �㷨��100% loss����ʧ��
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		String ip = "172.126.25.1";
		//ip = "google.com";
		if (isReachable(ip)) {
			System.out.println("����");
		} else {
			System.out.println("������");
		}
	}
}
