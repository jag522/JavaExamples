package com.jag.other;

import java.io.*;

/*
 * 第一年买进一只小绵羊，经过三年的发育，第四年变为成熟的老绵羊，生产并且往后每年都生产一只小绵羊。
 * 以此类推，试问n年后总共有多少头绵羊？
 */
public class Sheep {
	public static void main(String[] args) {
		Sheep s = new Sheep();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			System.out.print("Please input the year: ");
			try {
				String line = in.readLine();
				if ((line == null) || line.equals("quit"))
					break;
				int x = Integer.parseInt(line);
				System.out.println("After " + x
						+ " years,the total sheep number is " + s.sum(x));
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}

	public int sum(int year) {
		if (year <= 3)
			return 1;
		else
			//sum(year-3)本身，sum(year-1)每年新生的
			return (sum(year - 3) + sum(year - 1));
	}

}
