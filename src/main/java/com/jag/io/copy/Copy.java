package com.jag.io.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class Copy {
	public static void main(String[] args){
		
    	String from_name = "I:/test/";
    	String to_name = "G:/test/";
    	
    	String suffix[] = new String[2];
    	suffix[0] = "xls";
    	suffix[1] = "txt";
    	suffix = null;
        try { copy(from_name, to_name, suffix); }
        catch (IOException e) { System.err.println(e.getMessage()); }
	}
	
	public static void copy(String from_name, String to_name, String suffix[]) throws IOException {
		
        File from_file = new File(from_name);
        if (!from_file.isDirectory())
        	abort("源目录不存在");
		
		FilenameFilter filter = null;
		//配置文件中有后缀名，才过滤需要的文件
		if(suffix != null) {
			//得到根据后缀名过滤的文件
	    	for(int i = 0; i < suffix.length; i++) {
	    		final String strSuffix = suffix[i];//内部类必须要final类型
		        filter = new FilenameFilter() {
		            public boolean accept(File dir, String name) {
		                if (name.endsWith(strSuffix)) return true;
		                else return false;
		            }
		        };
			    String[] files;
		        files = from_file.list(filter);//得到过滤后的文件列表
		        java.util.Arrays.sort(files);//文件排序
		
		        for(int j = 0; j < files.length; j++) {
		        	File f = new File(from_name + files[j]);
		        	File to_file = new File(to_name + files[j]);
		        	//如果是文件，而且目标文件夹中不存在，则开始拷贝
		        	if(f.isFile()) {
		        		if(!to_file.exists()) {
							File dirs = new File(to_name);
							if(!dirs.exists()) {
								System.out.println("Making dirs: " + to_name);
								dirs.mkdirs();//建立目标文件夹
							}
			        		System.out.println("Copying to: " + to_name + files[j]);
			        		copyFile(from_name, to_name, files[j]);
		        		}
		        	}
		        }
	    	}
	    	//得到目录
	        filter = new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	                return (new File(dir, name)).isDirectory();
	            }
	        };
	        String[] dirs;
	        dirs = from_file.list(filter);
	        java.util.Arrays.sort(dirs);
	
	        for(int j = 0; j < dirs.length; j++) {
	        	copy(from_name + dirs[j] + "/", to_name + dirs[j] + "/", suffix);//递归
	        }
		}
		
		else {//没有后缀名，则全拷
			String files[];
			files = from_file.list();
			for(int i = 0; i < files.length; i++) {
	        	File f = new File(from_name + files[i]);
	        	File to_file = new File(to_name + files[i]);
	        	if(f.isFile()) {
	        		if(!to_file.exists()) {
						File dirs = new File(to_name);
						if(!dirs.exists()) {
				    		System.out.println("Making dirs: " + to_name);
				    		dirs.mkdirs();
						}
		        		System.out.println("Copying to: " + to_name + files[i]);
		        		copyFile(from_name, to_name, files[i]);
	        		}
	        	}
	        	else {
		    		copy(from_name + files[i] + "/", to_name + files[i] + "/", suffix);
	        	}
			}
		}
	}
	
	public static void copyFile(String from_name, String to_name, String filename) throws IOException {
		try {
	        FileInputStream from = null;
	        FileOutputStream to = null;
	        try {
	            from = new FileInputStream(from_name + filename);
	            to = new FileOutputStream(to_name + filename);
	            byte[] buffer = new byte[4096];
	            int bytes_read;

	            while((bytes_read = from.read(buffer)) != -1)
	                to.write(buffer, 0, bytes_read);
	        }
	        finally {
	            if (from != null)
	            	try { from.close(); }
	            	catch (IOException e) {	System.err.println(e.getMessage()); }
	            if (to != null)
	            	try { to.close(); }
	            	catch (IOException e) { System.err.println(e.getMessage()); }
	        }
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

    private static void abort(String msg) throws IOException { 
        throw new IOException(msg); 
    }
}
