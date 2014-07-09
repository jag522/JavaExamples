package com.jag.lang.classloader3;

/**
 * 使用ClassloaderUtil打印当前线程的状况
 *
 * @author jag
 */
public class Main {

    public static void main(String[] args) {
        // Print current Classloader context
        System.out.println(ClassloaderUtil.getCurrentClassloaderDetail());

        // 1. Create a new instance of CallerClassA
        CallerClassA caller = new CallerClassA();

        // 2. Execute method of the caller
        caller.doSomething();

        System.out.println("done!");
    }

}
