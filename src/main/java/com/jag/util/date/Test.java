package com.jag.util.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		// Calendar calendar = new GregorianCalendar();
		// Date trialTime = new Date();
		// calendar.setTime(trialTime);
		//
		// System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		// System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		// System.out.println("WEEK_OF_YEAR: " +
		// calendar.get(Calendar.WEEK_OF_YEAR));
		// System.out.println("WEEK_OF_MONTH: " +
		// calendar.get(Calendar.WEEK_OF_MONTH));
		// System.out.println("DATE: " + calendar.get(Calendar.DATE));
		// System.out.println("DAY_OF_MONTH: " +
		// calendar.get(Calendar.DAY_OF_MONTH));
		// System.out.println("DAY_OF_YEAR: " +
		// calendar.get(Calendar.DAY_OF_YEAR));
		// System.out.println("DAY_OF_WEEK: " +
		// calendar.get(Calendar.DAY_OF_WEEK));
		// System.out.println("DAY_OF_WEEK_IN_MONTH: "
		// + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		// System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		// System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		// System.out.println("HOUR_OF_DAY: " +
		// calendar.get(Calendar.HOUR_OF_DAY));
		// System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		// System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		// System.out.println("MILLISECOND: " +
		// calendar.get(Calendar.MILLISECOND));
		// System.out.println("ZONE_OFFSET: "
		// + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		// System.out.println("DST_OFFSET: "
		// + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));
		//
		// System.out.println("Current Time, with hour reset to 3");
		// calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
		// calendar.set(Calendar.HOUR, 3);
		// System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		// System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		// System.out.println("WEEK_OF_YEAR: " +
		// calendar.get(Calendar.WEEK_OF_YEAR));
		// System.out.println("WEEK_OF_MONTH: " +
		// calendar.get(Calendar.WEEK_OF_MONTH));
		// System.out.println("DATE: " + calendar.get(Calendar.DATE));
		// System.out.println("DAY_OF_MONTH: " +
		// calendar.get(Calendar.DAY_OF_MONTH));
		// System.out.println("DAY_OF_YEAR: " +
		// calendar.get(Calendar.DAY_OF_YEAR));
		// System.out.println("DAY_OF_WEEK: " +
		// calendar.get(Calendar.DAY_OF_WEEK));
		// System.out.println("DAY_OF_WEEK_IN_MONTH: "
		// + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		// System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		// System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		// System.out.println("HOUR_OF_DAY: " +
		// calendar.get(Calendar.HOUR_OF_DAY));
		// System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		// System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		// System.out.println("MILLISECOND: " +
		// calendar.get(Calendar.MILLISECOND));

		// 得到今天的日期
		// System.out.println(new java.util.Date());
		// System.out.println(Calendar.getInstance( ).getTime( ));
		
		Date today = new Date();
		DateFormat df = DateFormat.getInstance();
		System.out.println(df.format(today));
		DateFormat df_fr = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		System.out.println(df_fr.format(today));
		
//		Calendar c = Calendar.getInstance( );    // today
//		System.out.println("Year: " + c.get(Calendar.YEAR));
//		System.out.println("Month: " + c.get(Calendar.MONTH));
//		System.out.println("Day: " + c.get(Calendar.DAY_OF_MONTH));
//		System.out.println("Day of week = " + c.get(Calendar.DAY_OF_WEEK));
//		System.out.println("Day of year = " + c.get(Calendar.DAY_OF_YEAR));
//		System.out.println("Week in Year: " + c.get(Calendar.WEEK_OF_YEAR));
//		System.out.println("Week in Month: " + c.get(Calendar.WEEK_OF_MONTH));
//		System.out.println("Day of Week in Month: " + 
//        c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		System.out.println("Hour: " + c.get(Calendar.HOUR));
//		System.out.println("AM or PM: " + c.get(Calendar.AM_PM));
//		System.out.println("Hour (24-hour clock): " + 
//        c.get(Calendar.HOUR_OF_DAY));
//		System.out.println("Minute: " + c.get(Calendar.MINUTE));
//		System.out.println("Second: " + c.get(Calendar.SECOND));
	}
}
