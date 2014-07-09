package com.jag.net.socket;

import java.net.*;
import java.io.*;

public class EchoClient extends ClientAndServer {

	protected Socket socket;

	public EchoClient(String url, int port) {
		try {
			socket = new Socket(url, port);
			System.out.println("CLIENT: connected to " + url + ":" + port);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		start();
	}

	public void run() {
		try {
			requestService(socket);
			socket.close();
			System.out.println("CLIENT: connection closed");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	protected void requestService(Socket socket) throws IOException {
		String servStr = readFromSocket(socket); // Check for "Hello"
		System.out.println("SERVER: " + servStr); // Report the server's response
		System.out.println("CLIENT: type a line or 'goodbye' to quit");// Prompt user
		if (servStr.substring(0, 5).equals("Hello")) {
			String userStr = "";
			do {
				userStr = readFromKeyboard(); // Get input from user
				writeToSocket(socket, userStr + "\n"); // Send it to server
				servStr = readFromSocket(socket); // Read server's response
				System.out.println("SERVER: " + servStr);// Report server's response
			} while (!userStr.toLowerCase().equals("goodbye"));// Until 'goodbye'
		}
	}

	protected String readFromKeyboard() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("INPUT: ");
		String line = input.readLine();
		return line;
	}

	public static void main(String args[]) {
		EchoClient client = new EchoClient("localhost", 10001);
	}
}
