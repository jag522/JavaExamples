package com.jag.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Date2Timestamp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		
		Timestamp ttt = new Timestamp(d.getTime());
		System.out.println(sdf.format(ttt.getDate()));
	}

}
