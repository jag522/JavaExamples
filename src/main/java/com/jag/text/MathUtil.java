package com.jag.text;

import java.text.DecimalFormat;

/**
 * 
 * 功能描述：数学运算工具类
 * 
 * @author 张杰
 * @created 2013-7-3 下午3:03:20
 * @version 1.0.0
 * @date 2013-7-3 下午3:03:20
 */
public class MathUtil {

	/**
	 * 
	 * 功能描述�?
	 * 
	 * @param value
	 *            要转换的�?
	 * @param format
	 *            格式，例�?.00
	 * @return
	 */
	public static double round(double value, String format) {
		return Double.parseDouble(new DecimalFormat(format).format(value));
	}

	public static void main(String[] args) {
		double d = 1.2545;
		System.out.println(round(d, "0.0"));
	}
}
