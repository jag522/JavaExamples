package com.jag.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditFileContent {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out
					.println("please set the argument to specify the destdir,program exits,try again!");
			System.exit(0);
		}
		File dir;
		File f[];
		dir = new File(args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("sorry,it's not a directory");
			System.exit(0);
		}

		try {
			System.out.println("please input the string you want to insert:");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			s = s + "\r\n\r\n";

			f = dir.listFiles();
			for (int i = 0; i < f.length; i++) {
				writeFile(f[i], s);
			}
			System.out.println("OK," + f.length
					+ " files is modified successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile(File f, String s) {
		FileReader fr = null;
		FileWriter fw = null;
		StringBuffer sb = new StringBuffer();
		// Read and display the file contents. Since we're reading text, we
		// use a FileReader instead of a FileInputStream.
		try {
			fr = new FileReader(f);// And a char stream to read it
			int len;// How many chars read each time
			char[] buffer = new char[4096];// Read 4K characters at a
			// time
			while ((len = fr.read(buffer)) != -1) {// Read a batch of
				// chars
				sb.append(buffer, 0, len);
			}
			fw = new FileWriter(f);
			sb.insert(0, s);
			fw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
