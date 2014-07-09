package com.jag.net;

import java.net.InetAddress;

public class NetTool {

	public static void main(String args[]) throws Exception {
		System.out.println("Your host IP is: " + InetAddress.getLocalHost());
		System.out.println("The Server IP is :"
				+ InetAddress.getByName("www.abc.com"));
		System.out.println(InetAddress.getLoopbackAddress());
	}

}