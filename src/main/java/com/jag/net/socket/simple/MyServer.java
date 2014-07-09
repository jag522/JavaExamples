package com.jag.net.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5678);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		while (true) {
			String str = in.readLine();
			System.out.println(str);
			out.println("Roger that");
			out.flush();
			if (str.equals("end"))
				break;
		}
		socket.close();
	}
}
