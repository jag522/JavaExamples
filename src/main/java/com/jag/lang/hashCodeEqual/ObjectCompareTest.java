package com.jag.lang.hashCodeEqual;

public class ObjectCompareTest {

	//�Ƚ�����Long�͵Ķ����Ƿ����
	public static void main(String[] args) {
		Long long1 = new Long(1);
		Long long2 = new Long(1);
		//hashCode��Ȳ�����ʾ����������ȣ�
		//��ΪLong��equals�����жϳ�����Long����������ַ��һ��
		System.out.println(long1.hashCode());
		System.out.println(long2.hashCode());
		System.out.println(long1==long2);
	}
	
}
