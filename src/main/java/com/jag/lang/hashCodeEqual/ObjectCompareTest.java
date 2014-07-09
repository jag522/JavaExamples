package com.jag.lang.hashCodeEqual;

public class ObjectCompareTest {

	//比较两个Long型的对象是否相等
	public static void main(String[] args) {
		Long long1 = new Long(1);
		Long long2 = new Long(1);
		//hashCode相等并不表示两个对象相等，
		//因为Long的equals方法判断出两个Long对象的物理地址不一致
		System.out.println(long1.hashCode());
		System.out.println(long2.hashCode());
		System.out.println(long1==long2);
	}
	
}
