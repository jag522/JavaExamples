package com.jag.other;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Server {
	public static void main(String[] arguemtns) throws Exception {
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress("192.160.10.220", 1234));

		while (true) {
			Socket s = ss.accept();
			if (s != null) {
				InputStream in = s.getInputStream();
				byte[] buffer = new byte[1023];
				int readed = 0;
				while ((readed = in.read(buffer)) != -1) {
					System.out.println(new String(buffer));
				}
			}
		}
	}
}
