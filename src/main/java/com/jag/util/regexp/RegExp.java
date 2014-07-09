package com.jag.util.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String args[]) {
		//System.out.println(System.getProperty("user.dir"));
		String s = "123456";
		String context = "22@@123456@@123456@@123456";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(context);
		boolean b = m.find();
		boolean d = m.find();
		boolean e = m.find();
//		boolean b = Pattern.matches(s, context);
		System.out.println(b);
		System.out.println(d);
		System.out.println(e);
		
	    Matcher m2 = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+")
	      .matcher("jdbc:oracle:thin:@172.16.0.17:1555:ora8");
	    if(m2.find())
	      System.out.println(m2.group());
		}
	
}
