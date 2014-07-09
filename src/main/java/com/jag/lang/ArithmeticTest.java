package com.jag.lang;

public class ArithmeticTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 4143;
		int left = i % 10; //取余数
		int value = i / 10; //取值，舍掉了余数
		System.out.println(left);
		System.out.println(value);
	}

}
