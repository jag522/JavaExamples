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
		// System.out.println("连接正常");
		// in.close();
		// } catch (IOException e) {
		// System.out.println("无法连接到：" + url.toString());
		// }

		// Java1.5版本才支持isReachable方法
		// try {
		// InetAddress ad = InetAddress.getByName("172.16.45.1");
		// boolean state = ad.isReachable(5000);// 测试是否可以达到该地址
		// if (state)
		// System.out.println("连接成功" + ad.getHostAddress());
		// else
		// System.err.println("连接失败");
		// } catch (UnknownHostException e) {
		// System.err.println("连接失败");
		// } catch(IOException e) {
		// e.printStackTrace();
		// }

		//实现尽最大努力试图到达主机，但防火墙和服务器配置可能阻塞请求，使其在某些特定的端口可以访问时处于不可到达状态。
		try {
			//cmd /c          执行字符串指定的命令然后终断
			//ping -n count   Number of echo requests to send.
			Process p = Runtime.getRuntime().exec("cmd /c ping -n 1 " + ip); // 此处1变大可以增加精确度，但影响测试速度
			BufferedReader in = new BufferedReader(new InputStreamReader(p
					.getInputStream()));
			String temp = null;
			StringBuffer strBuffer = new StringBuffer();
			while ((temp = (in.readLine())) != null)
				strBuffer.append(temp);
//			 System.out.println(strBuffer);
			if (strBuffer.toString().matches(".*\\(\\d?\\d% loss\\).*")) { // 算法，100% loss才算失败
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
			System.out.println("正常");
		} else {
			System.out.println("不正常");
		}
	}
}
