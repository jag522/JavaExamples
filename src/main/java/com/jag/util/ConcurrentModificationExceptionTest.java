package com.jag.util;

import java.util.ArrayList;

public class ConcurrentModificationExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    ArrayList<Integer> a = new ArrayList<Integer>();  
        for (int i = 0; i < 10; i++) {  
            a.add(i);  
        }
        System.out.println(a);
        //以下(迭代器方式)方式会报错
//        for (Integer o : a) {  
//            if (o == 1) {  
//                a.add(0);
//            }  
//        }
        //以下方式不会报错
        for (int i = 0; i < a.size(); i++) {  
            if (a.get(i) == 1) {  
                a.add(0);  
            }  
        } 
        System.out.println(a);
	}

}
