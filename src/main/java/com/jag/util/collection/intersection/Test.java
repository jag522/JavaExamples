package com.jag.util.collection.intersection;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;

public class Test {

    @SuppressWarnings( { "unchecked" })
    public static void main(String[] args) {
        List pageTotalList = Arrays.asList(new String[] { "A", "B", "C", "D", "E" }); //页面上目前未受权限控制要显示的所有项
        List pageNotUmList; //页面上不受UM权限控制的项
        List pageUmList; //页面上受UML权限控制的项

        List umTotalList = Arrays.asList(new String[] { "C", "D", "E", "F", "G", "H" }); //UM系统中的权限总集
        List userSessionUmList = Arrays.asList(new String[] { "C", "D", "F", "I" }); //用户所拥有的UM系统权限

        pageUmList = ListUtils.intersection(pageTotalList, umTotalList);
        System.out.println(pageUmList);
        pageNotUmList = ListUtils.subtract(pageTotalList, pageUmList);
        System.out.println(pageNotUmList);
        
        //最终要显示的项
        List toDisplayPageList = ListUtils.sum(pageNotUmList, ListUtils.intersection(userSessionUmList, pageUmList));
        System.out.println(toDisplayPageList);
    }
}
