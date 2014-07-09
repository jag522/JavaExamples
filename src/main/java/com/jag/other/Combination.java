package com.jag.other;

import java.math.BigInteger;

/**
 * ���
 * @author jag522
 *
 */
public class Combination {

	public static BigInteger eval(int n, int m) {
		// m <= n����n��ȡm����
		// Pnm = n! / (n-m)!
		// Cnm = Pnm/m! = n! / (n-m)!m!
		return Factorial.eval(n).divide(
				Factorial.eval(n - m).multiply(Factorial.eval(m)));
	}

}
