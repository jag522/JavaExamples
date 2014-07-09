package com.jag.util.date;

import java.util.Date;
import java.util.StringTokenizer;

public class DateConstuctor {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("1983-05-22", "-");

		Date d = new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st
				.nextToken()), Integer.parseInt(st.nextToken()));
		System.out.println(d);
	}
}
