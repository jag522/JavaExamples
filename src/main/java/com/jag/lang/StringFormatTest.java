package com.jag.lang;

public class StringFormatTest {

	public static void main(String[] args) {
		System.out.println(String.format("%1$,09d", -3123));
		System.out.println(String.format("%1$9d", -31));
		System.out.println(String.format("%1$-9d", -31));
		System.out.println(String.format("%1$(9d", -31));
		System.out.println(String.format("%1$#9x", 5689));
		System.out.println(String.format("{'keyword':'refreshSalesOrg','costTime': '%1$d','userId':'%2$s'}", 33, 11));
	}

}
