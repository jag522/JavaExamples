package com.jag.math;

import java.math.BigDecimal;

public class BigDecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long integralSum = 512;
		System.out.println((new BigDecimal(integralSum).divide(new BigDecimal(10))
				.multiply(new BigDecimal(8))).intValue());
		
	}

}
