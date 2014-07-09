/**
 * 
 */
package com.jag.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public final class DateUtil {

	/**
	 * 
	 */
	private DateUtil() {
		super();
	}
	
	/**
	 * �μ�@see getFixedDate(Date start, int monthOffset, int day);
	 * @param start
	 * @param day
	 * @return
	 */
	public static Date getFixedDate(Date start, int day) {
		return getFixedDate(start, 0, day);
	}
	
	/**
	 * ��ȡָ��offset�º�ĵ�day�죬�������û����һ�죬��ָ�����һ�졣
	 * 
	 * @param start			��ʼʱ���
	 * @param monthOffset   ��������
	 * @param day			ָ������һ��
	 * @return ���ؼ��������ڣ���ȷ����
	 */
	public static Date getFixedDate(Date start, int monthOffset, int day) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(start);
		
		// ָ���һ�죬��֤�·ݼ��㰲ȫ
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, monthOffset);
		int lastDay= c.getActualMaximum(Calendar.DAY_OF_MONTH);
		// ȡ���һ����ָ��day֮���С��һ��
		c.set(Calendar.DAY_OF_MONTH, Math.min(day, lastDay));
		
		return trunc(c.getTime(), "D");
	}
	
	
	public static Date add(Date date, int days) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(java.util.Calendar.DAY_OF_YEAR, c.get(java.util.Calendar.DAY_OF_YEAR)+days);
		return c.getTime();
	}
	
	public static Date lastDayOfMonth(Date date) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(java.util.Calendar.DAY_OF_MONTH, c.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	public static Date firstDayOfMonth(Date date) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(java.util.Calendar.DAY_OF_MONTH, c.getActualMinimum(java.util.Calendar.DAY_OF_MONTH));
		return c.getTime();
	}
	public static Date firstDayOfYear(Date date) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(java.util.Calendar.DAY_OF_YEAR, c.getActualMinimum(java.util.Calendar.DAY_OF_YEAR));
		return c.getTime();
	}
	public static Date lastDayOfYear(Date date) {
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(java.util.Calendar.DAY_OF_YEAR, c.getActualMaximum(java.util.Calendar.DAY_OF_YEAR));
		return c.getTime();
	}
	
	/**
	 * ��ʱ�侫ȷ����trunc��ʹ��String����Ϊpattern��֧���������
	 * <ul>
	 * <li>S ��</li>
	 * <li>M ����</li>
	 * <li>H Сʱ</li>
	 * <li>D ��</li>
	 * <li><i>W ��</i></li>
	 * </ul>
	 * 
	 * @param date
	 * @param pattern:
	 *            s, m, h, d, w
	 * @return
	 */
	public static Date trunc(Date date, String pattern) {
		// timezone offset
		// long value= date.getTime();
		// long factor = getFactor(pattern);
		// //long mod= (value + offset) % factor;
		// long mod= (value) % factor;
		// //mod= 0;
		// return new Date(value - mod);
		SimpleDateFormat format = new SimpleDateFormat(getPattern(pattern.toUpperCase()));
		try {
			return format.parse(format.format(date));
		} catch (ParseException e) {
			throw new RuntimeException("���ܴ����trunc��ʽ" + pattern, e);
		}
	}

	private static Map patterns = new HashMap();
	static {
		patterns.put("S", "yyyyMMdd HH:mm:ss");
		patterns.put("M", "yyyyMMdd HH:mm");
		patterns.put("H", "yyyyMMdd HH");
		patterns.put("D", "yyyyMMdd");
	}

	private static String getPattern(String pattern) {
		String p = (String) patterns.get(pattern);
		if (null == p) {
			throw new java.lang.IllegalArgumentException("���ܴ����trunc��ʽ" + pattern);
		}
		return p;
	}

	private final static int offset = SimpleTimeZone.getDefault().getRawOffset();

	private static long getFactor(String s) {
		if (null == s) {
			throw new IllegalArgumentException("Pattern should not null");
		}
		if (s.equalsIgnoreCase("S")) {
			return S;
		}
		if (s.equalsIgnoreCase("M")) {
			return M;
		}
		if (s.equalsIgnoreCase("H")) {
			return H;
		}
		if (s.equalsIgnoreCase("D")) {
			return D;
		}
		// if (s.equalsIgnoreCase("W")) {
		// return W;
		// }
		throw new IllegalArgumentException("Pattern should be one of s, m, h, d, w");
	}

	public static final long S = 1000;

	public static final long M = S * 60;

	public static final long H = M * 60;

	public static final long D = H * 24;

	public static final long W = D * 7;
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
//		cal.set(Calendar.HOUR, 11);
//		cal.set(Calendar.MINUTE, 59);
//		cal.set(Calendar.SECOND, 59);
		System.out.println(new Timestamp(cal.getTimeInMillis()));
	}
}
