package com.jag.text;

import java.text.DecimalFormat;

public class DemicalFormatTest {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat(".##");
		System.out.println(df.format(222.5222));
	}
}
