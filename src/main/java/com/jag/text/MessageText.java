package com.jag.text;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;

public class MessageText {

	public static void main(String[] args) {
		Object[] arguments = { new Integer(7),
				new Date(System.currentTimeMillis()),
				"a disturbance in the Force" };
		String result = MessageFormat
				.format(
						"At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
						arguments);
		System.out.println(result);

		Object[] testArgs = { new Long(3), "MyDisk" };
		MessageFormat form = new MessageFormat(
				"The disk \"{1}\" contains {0} file(s).");
		System.out.println(form.format(testArgs));

		form = new MessageFormat("The disk \"{1}\" contains {0}.");
		double[] filelimits = { 0, 1, 2 };
		String[] filepart = { "no files", "one file", "{0,number} files" };
		ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
		form.setFormatByArgumentIndex(0, fileform);
		Object[] testArgs2 = { new Long(12373), "MyDisk" };
		System.out.println(form.format(testArgs2));

	}

}
