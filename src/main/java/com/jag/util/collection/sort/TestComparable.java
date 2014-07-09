package com.jag.util.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestComparable {
    public static void main(String args[]) {
         test();
//        test2();
    }

    /**
     * List≈≈–Ú
     */
    public static void test() {
        List<Cat> listCat1 = new ArrayList<Cat>();
        Cat cat1 = new Cat(34, "hehe");
        Cat cat2 = new Cat(12, "haha");
        Cat cat3 = new Cat(23, "leizhimin");
        Cat cat4 = new Cat(13, "lavasoft");
        listCat1.add(cat1);
        listCat1.add(cat2);
        listCat1.add(cat3);
        listCat1.add(cat4);
        
        System.out.println("before sort:");
        System.out.println(listCat1);
        System.out.println();

        System.out.println("reverse the order:");
        Collections.reverse(listCat1); // ∑¥◊™À≥–Ú
        System.out.println(listCat1);
        System.out.println();

        System.out.println("sort ascend:");
        Collections.sort(listCat1); // …˝–Ú≈≈¡–
        System.out.println(listCat1);
        System.out.println();

        System.out.println("sort descend:");
        Collections.sort(listCat1, Collections.reverseOrder()); // Ωµ–Ú≈≈¡–
        System.out.println(listCat1);
        System.out.println();
    }

    /**
     *  ˝◊È≈≈–Ú
     */
    public static void test2() {
        String[] strArray = new String[] { "z", "a", "C", "b" };
        System.out.println("before sort:");
        print(strArray);
        
        Arrays.sort(strArray, Collections.reverseOrder());
        System.out.println("reverse the order:");
        print(strArray);

        Arrays.sort(strArray);
        System.out.println("sort ascend, case sensitive:");
        print(strArray);

        Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
        System.out.println("sort ascend, case insensitive:");
        print(strArray);
    }

    private static void print(String[] strArr) {
        for (int i = 0; i < strArr.length; i++)
            System.out.print(strArr[i]);
        System.out.println();
        System.out.println();
    }
}