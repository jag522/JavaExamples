package com.jag.rmi.java4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements I_Hello { // 必须从UnicastRemoteObject继承
	
	public Hello() throws RemoteException { // 需要一个抛出Remote异常的默认初始化方法
	}

	public String SayHello() { // 这个是实现I_Hello接口的方法
		return "Hello world !!";
	}
}
