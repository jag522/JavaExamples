package com.jag.other;

import java.math.BigInteger;

//Ë«É«Çò¸ÅÂÊ·ÖÎö
public class Lottery {

	public static void main(String[] args) {
		BigInteger red = Combination.eval(33, 6); // C33 6
		BigInteger blue = BigInteger.valueOf(16); // C16 1
		BigInteger ret = red.multiply(blue);
		System.out.println("The odds are: " + ret);
	}

}
