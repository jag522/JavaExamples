package com.jag.util.regexp;

public class ReplaceLeadingZero {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String testStr = "00023450";
        System.out.println(testStr.replaceAll("^0+", ""));
    }

}
