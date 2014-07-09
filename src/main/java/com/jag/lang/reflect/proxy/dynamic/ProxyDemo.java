package com.jag.lang.reflect.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.jag.lang.reflect.proxy.HelloImpl;
import com.jag.lang.reflect.proxy.IHello;

public class ProxyDemo {

	public static void main(String[] args) {
		IHello target = new HelloImpl();
		IHello proxy = (IHello) Proxy.newProxyInstance(target.getClass().getClassLoader(),
						target.getClass().getInterfaces(),
						new LogHandler(target));
		
		//��װ���ڲ������뿴��ȥ���Щ�����ǲ��ʺϿ������ԭ��
//		LogHandler lh = new LogHandler();
//		IHello proxy = (IHello) lh.proxy(new HelloImpl());
		
		proxy.sayHello("jag");
	}

}
