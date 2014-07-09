package com.jag.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String args[]) {
		//System.out.println(System.getProperty("user.dir"));
		String s = "(123456)";
		String context = "22@@123456@@123456@@123456";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(context);
		while(m.find()) {
			System.out.println(m.group(0));
		}
//		boolean b = Pattern.matches(s, context);
		
//	    Matcher m2 = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+")
//	    			.matcher("jdbc:oracle:thin:@172.16.0.17:1555:ora8");
//	    if(m2.find())
//	      System.out.println(m2.group());
		}
}
