package com.jag.lang.classloader3;

import com.google.common.collect.Maps;

public class ReferencingClassA {

    static {
        System.out.println(ClassloaderUtil.getCurrentClassloaderDetail());
    }

    public ReferencingClassA() {
        System.out.println("Creating a new instance of " + ReferencingClassA.class.getName() + "...");
        Maps.newHashMap();
    }

    public void doSomething() {
        // nothing to do...
    }

}
