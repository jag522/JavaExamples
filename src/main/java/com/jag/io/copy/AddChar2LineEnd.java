package com.jag.io.copy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AddChar2LineEnd {

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"D:/TDDOWNLOAD/ToDelete.txt")));
			String str;
			StringBuffer sb = new StringBuffer();
			do {
				str = br.readLine();
				if (str != null) {
					sb.append(str).append(",");
//					System.out.println(str);
				}
			} while (str != null);
			System.out.println(sb.toString());
		} finally {
			if (br != null)
				br.close();
		}
	}

}
