package com.jag.util.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodayOfNextYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		System.out.println(f.format(date.getTime()));
		date.add(Calendar.YEAR, 1);
		System.out.println(f.format(date.getTime()));
	}

}
