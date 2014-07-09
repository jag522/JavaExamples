package com.jag.other;

import java.util.Random;

public class DrawLottery {
	public static void main(String[] args) {
		Random r = new Random();
		// red balls
		int[] red = new int[6];
		int tmp = 0;
		boolean find = false;
		for (int i = 0; i < 6; i++) {
			while (true) {//如果找到重复的球，继续找
				tmp = r.nextInt(33) + 1;
				for (int j = 0; j < i; j++) {
					if (tmp == red[j]) {
						find = true;
						break;
					}
				}
				if (!find)
					break;
				find = false;
			}
			red[i] = tmp;
		}
		sort(red);
		System.out.print("the red balls are: ");
		for (int k = 0; k < red.length; k++)
			System.out.print(red[k] + ",");
		System.out.println("");
		System.out.println("the blue ball is:  " + (r.nextInt(16) + 1));
	}

	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int min = i; // holds the index of the smallest element
			// find the smallest one between i and the end of the array
			for (int j = i; j < nums.length; j++) {
				if (nums[j] < nums[min])
					min = j;
			}
			int tmp;
			tmp = nums[i];
			nums[i] = nums[min];
			nums[min] = tmp;
		}
	}
}
