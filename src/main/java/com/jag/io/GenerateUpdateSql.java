package com.jag.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GenerateUpdateSql {

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"D:/TDDOWNLOAD/ToDelete.txt")));
			String str;
			do {
				str = br.readLine();
				if (str != null) {
					String[] s = str.split(",");
					StringBuffer sb = new StringBuffer();
					sb.append("update REVIEW.PRODUCT_REVIEW set QUALITY_STAR=")
							.append(s[1]).append(" where PRODUCT_REVIEW_ID=")
							.append(s[0]).append(";");
					System.out.println(sb.toString());
				}
			} while (str != null);
		} finally {
			if (br != null)
				br.close();
		}
	}
}
