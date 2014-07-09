package com.jag.lang.classloader2;

/**
 * A class called WhichClassLoader1 loads a class called WhichClassLoader2, in turn invoking a class called WhichClassLoader3.
If all WhichClassLoaderX classes are put on the application class path, the three classes are loaded by the application class loader, and this sample runs just fine.

Suppose that you package the WhichClassLoader2.class file in a JAR file that you store under Java_home/jre/lib/ext directory, 
the program fails with a NoClassDefFoundError exception, which might sound strange because WhichClassLoader3 is on the application class path. 
The problem is that it is now on the wrong class path.

What happened was that the WhichClassLoader2 class was loaded by the extensions class loader.
In fact, the application class loader delegated the load of the WhichClassLoader2 class to the extensions class loader,
which in turn delegated the request to the bootstrap class loader. Because the bootstrap class loader could not find the class, 
the class loading control was returned to the extensions class loader. The extensions class loader found the class on its class path and loaded it.

Now, when a class has been loaded by a class loader, 
any new classes that the class needs reuse the same class loader to load them (or goes up the hierarchy according to the parent-delegation model).
So when the WhichClassLoader2 class needed to access the WhichClassLoader3 class, it is the extensions class loader that first gets the request to load it.
The extensions class loader first delegates the request to the Bootstrap class path,
which cannot find the class,and then tries to load it itself but does not find it either because WhichClassLoader3 is not on the extensions class path but on the application classpath.
And because the extensions class loader cannot delegate the request to the application class loader (a delegate request can only go up the hierarchy, never down),
a NoClassDefFoundError exception is thrown.
 * @author jag
 *
 */
public class WhichClassLoader1 {

	public static void main(String[] args) throws javax.naming.NamingException {
		// Get classpath values
		String bootClassPath = System.getProperty("sun.boot.class.path");
		String extClassPath = System.getProperty("java.ext.dirs");
		String appClassPath = System.getProperty("java.class.path");
		// Print them out
		System.out.println("Bootstrap classpath =" + bootClassPath + "\n");
		System.out.println("Extensions classpath =" + extClassPath + "\n");
		System.out.println("Application classpath=" + appClassPath + "\n");

		// Load classes
		Object obj = new Object();
		WhichClassLoader1 wcl1 = new WhichClassLoader1();
		WhichClassLoader2 wcl2 = new WhichClassLoader2();
		// Who loaded what?
		System.out.println("Object was loaded by "
				+ obj.getClass().getClassLoader());
		System.out.println("WCL1 was loaded by "
				+ wcl1.getClass().getClassLoader());
		System.out.println("WCL2 was loaded by "
				+ wcl2.getClass().getClassLoader());
		wcl2.getTheClass();
	}
}
