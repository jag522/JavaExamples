package com.jag.util.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseOrEnglishNameRepExp {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[a-zA-z\u4e00-\u9fa5]{2,32}$"); // 中台姓名校验规则：2-32个中英文
		Matcher isNum = pattern.matcher("mbjbdtznam");
		if (isNum.matches()) { // 符合姓名规则的才给中台
			System.out.println(isNum.group());
		}
		
		Pattern patternPost = Pattern.compile("^\\d{6}$"); //6位数字
        Matcher isPost = patternPost.matcher("100022");
        if(isPost.matches()) { //符合姓名规则的才给中台
        	System.out.println(isPost.group()); // 邮编
        }
	}
}
