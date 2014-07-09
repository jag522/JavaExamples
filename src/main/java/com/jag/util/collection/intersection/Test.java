package com.jag.util.collection.intersection;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;

public class Test {

    @SuppressWarnings( { "unchecked" })
    public static void main(String[] args) {
        List pageTotalList = Arrays.asList(new String[] { "A", "B", "C", "D", "E" }); //ҳ����Ŀǰδ��Ȩ�޿���Ҫ��ʾ��������
        List pageNotUmList; //ҳ���ϲ���UMȨ�޿��Ƶ���
        List pageUmList; //ҳ������UMLȨ�޿��Ƶ���

        List umTotalList = Arrays.asList(new String[] { "C", "D", "E", "F", "G", "H" }); //UMϵͳ�е�Ȩ���ܼ�
        List userSessionUmList = Arrays.asList(new String[] { "C", "D", "F", "I" }); //�û���ӵ�е�UMϵͳȨ��

        pageUmList = ListUtils.intersection(pageTotalList, umTotalList);
        System.out.println(pageUmList);
        pageNotUmList = ListUtils.subtract(pageTotalList, pageUmList);
        System.out.println(pageNotUmList);
        
        //����Ҫ��ʾ����
        List toDisplayPageList = ListUtils.sum(pageNotUmList, ListUtils.intersection(userSessionUmList, pageUmList));
        System.out.println(toDisplayPageList);
    }
}
