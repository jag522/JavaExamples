package com.jag.other;

/*
 * ����windows��exe�ļ�
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
				System.out.println("���г���");
				e.printStackTrace();
			}
		} catch (Exception e) {

		}
	}

}