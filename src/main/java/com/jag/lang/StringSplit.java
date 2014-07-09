package com.jag.lang;

public class StringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "021-64232211-022";
		String[] sArray = s.split("-");
		for(String sss : sArray) {
			System.out.println(sss);
		}
		
		String s2 = ";2";
		s2.split(";");
		
		String s3 = "2";
		s3.split(";");
		
		
//		String telephone1 = "13910619923;133233216755";
//		String telephone2 = "13901240904,15801618801";
		
//      Pattern p = Pattern.compile("[,;]");
//      String[] items = p.split(telephone1);
//      for(String s : items) {
//          System.out.println(s);
//      }
	}

}
