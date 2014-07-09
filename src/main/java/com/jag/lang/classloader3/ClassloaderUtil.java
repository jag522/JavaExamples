package com.jag.lang.classloader3;

import java.util.Stack;

public class ClassloaderUtil {

    public static String getCurrentClassloaderDetail() {
        StringBuffer classLoaderDetailSb = new StringBuffer();
        Stack<ClassLoader> classLoaderStack = new Stack<ClassLoader>();
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        // classLoaderDetailSb.append("\n-----------------------------------------------------------------\n");

        // Build a Stack of the current ClassLoader chain
        while (currentClassLoader != null) {
            classLoaderStack.push(currentClassLoader);
            currentClassLoader = currentClassLoader.getParent();
        }

        // Print ClassLoader parent chain
        while (classLoaderStack.size() > 0) {
            ClassLoader classLoader = classLoaderStack.pop();
            // Print current
            classLoaderDetailSb.append(classLoader);
            if (classLoaderStack.size() > 0) {
                classLoaderDetailSb.append("\n--- delegation ---\n");
            } else {
                classLoaderDetailSb.append("\n--- Current ClassLoader ---");
            }
        }

        classLoaderDetailSb.append("\n-----------------------------------------------------------------\n");
        return classLoaderDetailSb.toString();
    }

}
