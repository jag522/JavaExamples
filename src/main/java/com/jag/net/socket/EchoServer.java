package com.jag.net.socket;

import java.net.*;
import java.io.*;

public class EchoServer extends ClientAndServer {
	private ServerSocket serverListenSocket;
	private Socket socket;

	public EchoServer(int portNum, int nBacklog) {
		try {
			serverListenSocket = new ServerSocket(portNum, nBacklog);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
	}

	public void run() {
		try {
			System.out.println("Echo server at " + InetAddress.getLocalHost()
					+ " waiting for connections ");
			while (true) {
				socket = serverListenSocket.accept();
				System.out.println("Accepted a connection from "
						+ socket.getInetAddress());
				provideService(socket);
				socket.close();
				System.out.println("Closed the connection\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void provideService(Socket socket) {
		String str = "";
		try {
			writeToSocket(socket, "Hello, how may I help you?\n");
			do {
				str = readFromSocket(socket);
				if (str.toLowerCase().equals("goodbye"))
					writeToSocket(socket, "Goodbye\n");
				else
					writeToSocket(socket, "You said '" + str + "'\n");
			} while (!str.toLowerCase().equals("goodbye"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		EchoServer server = new EchoServer(10001, 3);
	}
}
