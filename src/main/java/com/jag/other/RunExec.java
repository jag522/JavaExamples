package com.jag.other;

/*
 * 运行windows的exe文件
 */
public class RunExec {

	public static void main(String[] args) {
		try {
			Runtime rn = Runtime.getRuntime();
			Process p = null;
			try {
				String path = System.getProperty("user.dir");
				p = rn.exec("E:\\resin-2.1.14\\webapps\\filecopy\\execAnt.cmd");
			} catch (Exception e) {
				System.out.println("运行出错");
				e.printStackTrace();
			}
		} catch (Exception e) {

		}
	}

}