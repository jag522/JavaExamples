package com.jag.lang.extend;

public class TestSubClassMethodName {
	
	public static void main(String[] args) {
		Child child = new Child();
		child.operationOfChild(); //�õ���������������������Ǹ��׵�����
	}

}

class Parent {
	public void operationOfParent() {
		String className = this.getClass().getName();
		String methodName = "";
		
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace(); 
		for(StackTraceElement stack : stacks) {
			if(stack.getClassName().equals(className)) {
				methodName = stack.getMethodName();
				break;
			}
		}
		System.out.println(className);
		System.out.println(methodName);

//		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}

class Child extends Parent {
	public void operationOfChild() {
		super.operationOfParent();
	}
	
}
