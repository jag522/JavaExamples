package com.jag.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileFIENH1 {
	
	public static enum PADDING_ALIGN{LEFT,RIGHT}

	public static void main(String[] args) {
		String from_name = "C://0090000003.PDF";
		String to_name = "C://";
		try {
			copy(from_name);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void copy(String from_name)
			throws IOException {
		File from_file = new File(from_name);
		FileInputStream from = null; // Stream to read from source
		FileOutputStream to = null; // Stream to write to destination
		String to_name = null;
		try {
			int digital = 6;
			String tempVal = null;
			for (int i = 0; i < 3; i++) {
				tempVal = paddingZero(String.valueOf(digital++), 7);
				to_name = "C://009" + tempVal + ".pdf";
				File to_file = new File(to_name);

				// If we've gotten this far, then everything is okay.
				// So we copy the file, a buffer of bytes at a time.
				from = new FileInputStream(from_file); // Create input stream
				to = new FileOutputStream(to_file); // Create output stream
				byte[] buffer = new byte[4096]; // To hold file contents
				int bytes_read; // How many bytes in buffer

				// Read a chunk of bytes into the buffer, then write them out,
				// looping until we reach the end of the file (when read( )
				// returns
				// -1). Note the combination of assignment and comparison in
				// this
				// while loop. This is a common I/O programming idiom.
				while ((bytes_read = from.read(buffer)) != -1) {
					// Read until EOF
					to.write(buffer, 0, bytes_read); // write
				}
				to.close();
			}
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}

	}

	/** A convenience method to throw an exception */
	private static void abort(String msg) throws IOException {
		throw new IOException("FileCopy: " + msg);
	}
	
	/**
	 * @param srcValue
	 * @param tgtLen
	 * @return padded target value
	 */
	public static String paddingZero(String srcValue, int tgtLen) {
		return paddingString(srcValue, tgtLen, "0", true, PADDING_ALIGN.LEFT);
	}
	
	/**
	 * concatenate paddingString as prefix to pad the transformation if source value is shorter than target value
	 * @param srcValue source value
	 * @param tgtLen target value length 
	 * @param paddingStr padding string
	 * @param doTrimSrcValue whether or not to trim whitespace from srcValue
	 * @param alignmnet left padding or right padding
	 * @return concatenated value
	 */
	public static String paddingString(String srcValue, int tgtLen, String paddingStr, boolean doTrimSrcValue, PADDING_ALIGN alignment) {
		
		if(doTrimSrcValue){
			srcValue = srcValue.trim();
		}
		
		int srcLen  = isValid(srcValue) ? srcValue.length() : 0;
		if (srcLen >= tgtLen) {
			return srcValue;
		}
		
		StringBuffer padding = new StringBuffer();
		for(int i = 0; i < (tgtLen - srcLen); i ++) {
			padding.append(paddingStr);
		}

		if(alignment == PADDING_ALIGN.RIGHT){
			return new StringBuffer(srcValue).append(padding).toString();
		}else{
			return padding.append(srcValue).toString();
		}
		
	}
	
	public static boolean isInvalid(String str) {
		return str == null || "".equals(str);
	}
	
	public static boolean isValid(String str) {
		return !isInvalid(str);
	}
}