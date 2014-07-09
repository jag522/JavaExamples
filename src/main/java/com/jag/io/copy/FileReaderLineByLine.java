package com.jag.io.copy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReaderLineByLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"c:/OTC_WMS_INT_0001__OTC_MM_INT_0022.csv")));
			String str;
			do {
				str = br.readLine();
			} while (str != null);
		} finally {
			if (br != null)
				br.close();
		}
	}

}
