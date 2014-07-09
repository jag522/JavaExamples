package com.jag.lang;

public class SwitchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v = { 1, 2, 3, 4 };
		for (int value : v) {
			switch (value) {
			case 1:
			case 2:
				System.out.println("hi:" + value);
				break;
			default:
				System.out.println("hello");
				break;
			}
		}

	}

}
