package com.jag.rmi.java4;

import java.rmi.*;

public class RMI_Client {
	public static void main(String[] args) {
		try {
			I_Hello hello = (I_Hello) Naming.lookup("rmi://192.168.0.100:1099/RMI_Hello"); // 通过RMI名称查找远程对象
			System.out.println(hello.SayHello()); // 调用远程对象的方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}