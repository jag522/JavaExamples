package com.jag.other;

public class ForDebugTest {

    public static void main(String[] args) {
        long value = 0;
        for (int i = 0; i < 1000; i++) {
            value = value + i;
        }
        methodIWantToDebug(value);
    }

    private static void methodIWantToDebug(long value) {
        System.out.println(value);
    }

}
