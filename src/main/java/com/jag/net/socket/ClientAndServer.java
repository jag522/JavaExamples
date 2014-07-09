package com.jag.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientAndServer extends Thread {

	protected InputStream iStream;
	protected OutputStream oStream;

	protected String readFromSocket(Socket sock) throws IOException {
		iStream = sock.getInputStream();
		String str = "";
		char c;
		while ((c = (char) iStream.read()) != '\n')
			str = str + c + "";
		return str;
	}

	protected void writeToSocket(Socket sock, String str) throws IOException {
		oStream = sock.getOutputStream();
		if (str.charAt(str.length() - 1) != '\n')
			str = str + '\n';
		for (int k = 0; k < str.length(); k++)
			oStream.write(str.charAt(k));
	}
}
