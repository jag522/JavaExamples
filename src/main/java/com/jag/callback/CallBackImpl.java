package com.jag.callback;

public class CallBackImpl implements CallBack {

	public void execute() {
		// 这里可以加放一个或多个要测试运行时间的方法
		TestObject.testMethod();
	}

}
