package com.jag.rmi.java4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements I_Hello { // �����UnicastRemoteObject�̳�
	
	public Hello() throws RemoteException { // ��Ҫһ���׳�Remote�쳣��Ĭ�ϳ�ʼ������
	}

	public String SayHello() { // �����ʵ��I_Hello�ӿڵķ���
		return "Hello world !!";
	}
}
