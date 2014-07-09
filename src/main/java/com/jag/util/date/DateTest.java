package com.jag.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		DateFormat dateFormatter = DateFormat.getDateInstance();
		System.out.println(dateFormatter.format(d));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d));

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(String.valueOf(year) + String.valueOf(month) + String.valueOf(day));
		
		//反向,根据字符串来构造Date对象
		try {
			Date ddd = dateFormatter.parse("1983-05-22");
			System.out.println(ddd);
		} catch (Exception e) {
		}

	}

}
