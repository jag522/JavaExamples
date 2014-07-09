package com.jag.other;

import java.math.BigInteger;

/**
 * 组合
 * @author jag522
 *
 */
public class Combination {

	public static BigInteger eval(int n, int m) {
		// m <= n（从n中取m个）
		// Pnm = n! / (n-m)!
		// Cnm = Pnm/m! = n! / (n-m)!m!
		return Factorial.eval(n).divide(
				Factorial.eval(n - m).multiply(Factorial.eval(m)));
	}

}
