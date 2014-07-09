package com.jag.other;

import java.io.*;

/*
 * ��һ�����һֻС���򣬾�������ķ������������Ϊ�����������������������ÿ�궼����һֻС����
 * �Դ����ƣ�����n����ܹ��ж���ͷ����
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
			//sum(year-3)����sum(year-1)ÿ��������
			return (sum(year - 3) + sum(year - 1));
	}

}
