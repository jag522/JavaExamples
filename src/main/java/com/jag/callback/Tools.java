package com.jag.callback;

public class Tools {

	/**
	 * ���Ժ���ʹ��ʱ�䣬ͨ������CallBack�ӿڵ�execute����
	 * 
	 * @param callBack
	 */
	public void testTime(CallBack callBack) {
		long begin = System.currentTimeMillis();// ������ʼʱ��
		callBack.execute();// /���лص�����
		long end = System.currentTimeMillis();// ���Խ���ʱ��
		System.out.println("[use time]:" + (end - begin));// ��ӡʹ��ʱ��
	}
}
