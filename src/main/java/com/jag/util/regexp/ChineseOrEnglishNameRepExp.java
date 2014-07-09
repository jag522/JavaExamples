package com.jag.util.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseOrEnglishNameRepExp {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[a-zA-z\u4e00-\u9fa5]{2,32}$"); // ��̨����У�����2-32����Ӣ��
		Matcher isNum = pattern.matcher("mbjbdtznam");
		if (isNum.matches()) { // ������������ĲŸ���̨
			System.out.println(isNum.group());
		}
		
		Pattern patternPost = Pattern.compile("^\\d{6}$"); //6λ����
        Matcher isPost = patternPost.matcher("100022");
        if(isPost.matches()) { //������������ĲŸ���̨
        	System.out.println(isPost.group()); // �ʱ�
        }
	}
}
