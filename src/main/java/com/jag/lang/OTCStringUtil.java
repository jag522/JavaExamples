package com.jag.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class OTCStringUtil {
	public static final String PADDING_ZERO = "0";
	public static final String PADDING_SPACE = " ";
	public static enum PADDING_ALIGN{LEFT,RIGHT}

	/**
	 * GenerateTargetFileName format as {main} + current date as {datePattern} +
	 * {suffix}.
	 * 
	 * @param fileName
	 * @param datePattern
	 * @param suffix
	 * @return
	 */
	public static String generateTargetFileName(String fileName, String datePattern, String suffix) {
		String currentDateStr = new SimpleDateFormat(datePattern).format(new Date());
		return new StringBuffer(fileName).append(currentDateStr).append(suffix).toString();
	}
	
	/**
	 * GenerateTargetFileNameUUID.
	 * 
	 * @param fileName
	 * @param suffix
	 * @return
	 */
	public static String generateTargetFileNameUUID(String fileName, String suffix) {
		UUID uuid = UUID.randomUUID();
		return new StringBuffer(fileName).append(uuid.toString()).append(suffix).toString();
	}

	/**
	 * Extract original file name from archive ones.
	 * 
	 * @param archiveFileName
	 * @return
	 */
	public static String extractFileNameFromArchive(String archiveFileName) {
		return archiveFileName.substring(0, archiveFileName.lastIndexOf(".") - 1);
	}

	/**
	 * check string null or blank
	 * 
	 * @param str
	 *            string
	 * @return null or blank
	 */
	public static boolean isInvalid(String str) {
		return str == null || "".equals(str);
	}

	/**
	 * checking string not null or blank
	 * 
	 * @param str
	 *            string
	 * @return not null or blank
	 */
	public static boolean isValid(String str) {
		return !isInvalid(str);
	}
	
	/**
	 * compare time1 and time2
	 * 
	 * @param time1 string
	 * @param time2 string
	 * @return day
	 * @throws Exception 
	 */
	public static long compareDate(String time1, String time2) throws Exception {
		long day = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			day = (date1.getTime() - date2.getTime())/ 1000 / 60 / 60 / 24;

		} catch (ParseException e) {
			throw new Exception(e);
		}
		return day;
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
		
		int srcLen  = OTCStringUtil.isValid(srcValue) ? srcValue.length() : 0;
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
	
	/**
	 * pad zero as prefix  
	 * @param srcValue source value 
	 * @param tgtLen length of target value
	 * @param doTrimSrcValue whether or not to trim whitespace from srcValue
	 * @param alignment left padding or right padding
	 * @return padded target value
	 */
	public static String paddingZero(String srcValue, int tgtLen, boolean doTrimSrcValue, PADDING_ALIGN alignment) {
		return paddingString(srcValue, tgtLen, PADDING_ZERO, doTrimSrcValue, alignment);
	}
	
	/**
	 * @param srcValue
	 * @param tgtLen
	 * @return padded target value
	 */
	public static String paddingZero(String srcValue, int tgtLen) {
		return paddingString(srcValue, tgtLen, PADDING_ZERO, true, PADDING_ALIGN.LEFT);
	}
	
	/**
	 * pad space as prefix  
	 * @param srcValue source value 
	 * @param tgtLen length of target value
	 * @return padded target value
	 */
	public static String paddingSpace(String srcValue, int tgtLen) {
		return paddingString(srcValue, tgtLen, PADDING_SPACE, true, PADDING_ALIGN.LEFT);
	}
	
	/**
	 * pad space as prefix  
	 * @param srcValue source value 
	 * @param tgtLen length of target value
	 * @param doTrimSrcValue whether or not to trim whitespace from srcValue
	 * @param alignmnet left padding or right padding
	 * @return padded target value
	 */
	public static String paddingSpace(String srcValue, int tgtLen, boolean doTrimSrcValue, PADDING_ALIGN alignment) {
		return paddingString(srcValue, tgtLen, PADDING_SPACE, doTrimSrcValue, alignment);
	}
}
