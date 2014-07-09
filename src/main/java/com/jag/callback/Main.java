package com.jag.callback;

public class Main {
	public static void main(String[] args) {
		Tools tool = new Tools();
		tool.testTime(new CallBackImpl());
	}
}
