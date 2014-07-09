package com.jag.lang.reflect;

import java.lang.reflect.*;

/**
 * List the Constructors and methods
 */

public class ListMethods {

	public static void main(String[] argv) throws ClassNotFoundException {
		Class c = Class.forName("je3.lang.reflect.ListMethods"); // ��̬ȡ����
		Constructor[] cons = c.getConstructors();
		printList("Constructors", cons);
		Method[] meths = c.getMethods();
		printList("Methods", meths);
		Method[] meths2 = c.getDeclaredMethods(); // �౾�������ķ���(���̳����ķ�������)
		printList("DeclaredMethods", meths2);
	}

	static void printList(String s, Object[] o) {
		System.out.println("*** " + s + " ***");
		for (int i = 0; i < o.length; i++)
			System.out.println(o[i].toString());
	}
}
