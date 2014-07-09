package com.jag.lang;

public class RegExpTest1 {
	public static void main(String[] args) {
		String s = "   sda ";
		// trim the trailing spaces
		s = s.replaceFirst("\\s+$", "");
		System.out.println(s);
	}
}
