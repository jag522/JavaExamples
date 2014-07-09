package com.jag.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyOfStringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String hometelephone1 = "13811901243;65429458";
		String hometelephone2 = ";82372186;67655078";
		String hometelephone3 = ";64434326";
		String hometelephone4 = "64334411,";
		String hometelephone5 = "010-68190215";
		String hometelephone6 = "0451-57150593";
		String hometelephone7 = "68017788-1011";
		String hometelephone8 = ";61520520£»87378285";
		String hometelephone9 = "87663120;;";
		String hometelephone10 = "51818888-Ç°Ì¨";
		String hometelephone11 = ";010-59085559-5559";
		String hometelephone12 = "64185353-5601;13581600789";
		String hometelephone13 = "61669176;010-61669171-110";

		// telephone
		// Pattern pattern = Pattern.compile("\\d{11}");
		// Matcher matcher = pattern.matcher(telephone2);
		// while(matcher.find()) {
		// System.out.println(matcher.group());
		// }
		
//		Pattern p = Pattern.compile("[,;]");
//		String[] homeTelePhoneArray = p.split(hometelephone1);
//		for(String homeTelePhone : homeTelePhoneArray) {
//
//		}
		Pattern pattern2 = Pattern.compile("(\\d{3,4}\\-)?\\b(\\d{7,8})\\b(\\-\\d{3,4})?");
		Matcher matcher2 = pattern2.matcher(hometelephone13);
		while (matcher2.find()) {
			System.out.println(matcher2.group());
		}


	}

}
