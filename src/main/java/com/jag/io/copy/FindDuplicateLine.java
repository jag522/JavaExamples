package com.jag.io.copy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDuplicateLine {

	public static void main(String[] args) {
		String realPath = System.getProperty("user.dir")
				+ "/src/je3/io/duplicateLine.txt";
		try {
			long start = System.currentTimeMillis();
			FileReader fileReader = new FileReader(realPath);
			BufferedReader buf = new BufferedReader(fileReader);
			String line;
			StringBuffer sb = new StringBuffer();
			ArrayList al = new ArrayList();
			while ((line = buf.readLine()) != null) {
				// System.out.println(line);
				sb.append(line).append("@@@");
				al.add(line);
			}
			String context = sb.toString();
			String result = "";
//			 System.out.println(context);
			for (int i = 0; i < al.size(); i++) {
				String s = (String) al.get(i);
				Pattern p = Pattern.compile("(@@@)?" + s + "@@@");
				Matcher m = p.matcher(context);
				if (m.find()) {
					if (m.find()) {
						result += "第" + (i + 1) + "行：" + s + "\n";
						;
					}
				}
			}
			if (result.equals("")) {
				System.out.println("无重复行！");
			} else {
				System.out.println("重复行：");
				System.out.println(result);
			}
			buf.close();
			fileReader.close();
			long over = System.currentTimeMillis();
			System.out.println("共花费时间：" + (over - start) + "毫秒");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
	}
}
