package com.jag.util.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list = null;
        for (String s : list) {
            System.out.println(s);
        }
    }

}
