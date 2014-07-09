package com.jag.lang.classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileClassLoader extends ClassLoader {
	
	@Override
	public Class findClass(String fullClassName) {
		String className = fullClassName.replace('.', '/');
		byte[] data = loadClassData(className);
		return defineClass(fullClassName, data, 0, data.length);
	}

	private byte[] loadClassData(String className) {
		FileInputStream fis = null;
		byte[] data = null;
		try {
			fis = new FileInputStream(new File("src/" + className + ".class"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
