package com.jag.other;

import java.math.BigDecimal;

/**
 * �������ʼ�������Ŀǰֻʵ���˵ȶϢ�㷨��
 * @author jag522
 *
 */
public class calcMortgage {

	public static void main(String[] args) {
		// TODO дһ��unittest
		// ����ע�͵��Ĵ�����һ�������㷨��Ϊ���Ƶ��ȶϢ����Ĺ�ʽ����ô�ó�����,Ŀǰ��û�еó��������ʱ���ٸ㡣
//		int amount = 290000;
//		int duarationByYear = 15;
//		int duarationByMonth = duarationByYear * 12;
//		double ratePerMonth = 0.003465;
//		double totalInterest = 0;
//		double lastMonthInterest = 0;
//		for (int i = 0; i < 180; i++) {
//			double interest = (amount - amount / 180 * i + lastMonthInterest) * ratePerMonth;
//			lastMonthInterest = interest;
//			totalInterest += interest;
//		}
//		System.out.println(totalInterest);
		
		System.out.println(simpleMathMethod(29, 15, 4.158)); // ����29��,����15��,������Ϊ4.158%
		System.out.println(mathMethod(290000, 180, 0.003465));
		
//		System.out.println(simpleMathMethod(100, 20, 6.6555)); // ����100�򣬻�������Ϊ20�꣬������Ϊ6.6555%
//		System.out.println(mathMethod(1000000,240,0.00554625));
	}
	
	/**
	 * 
	 * @param amountByWan		������,��λ��
	 * @param duarationByYear	��������,��λ��
	 * @param ratePerYear		����������,��λ�ٷ�
	 * @return
	 * ����, ����29��,����15��,������Ϊ4.158%,��simpleMathMethod(29, 15, 4.158)
	 */
	public static double simpleMathMethod(int amountByWan, int duarationByYear, double ratePerYear) {
		return mathMethod(amountByWan * 10000, duarationByYear * 12, ratePerYear/12/100);
	}

	/**
	 * 
	 * @param amount
	 * @param duarationByMonth
	 * @param fractionRatePerMonth
	 * @return
	 * ����,����290000,����180��(15��*12����),������Ϊ0.003465(4.158%/12),��mathMethod(290000, 180, 0.003465)
	 */
	public static double mathMethod(int amount, int duarationByMonth, double fractionRatePerMonth) {
		double rtn = 0;
		double dRate = 1 + fractionRatePerMonth;
		BigDecimal tmp = new BigDecimal(dRate);
		BigDecimal bdRate = new BigDecimal(fractionRatePerMonth);
		BigDecimal bdTotalLoad = new BigDecimal(amount);
		BigDecimal bgRtn = new BigDecimal(1);
		// ������㷨����
		tmp = tmp.pow(duarationByMonth);
		bgRtn = bgRtn.multiply(bdTotalLoad);
		bgRtn = bgRtn.multiply(bdRate);
		bgRtn = bgRtn.multiply(tmp);
		tmp = tmp.subtract(new BigDecimal(1));
		bgRtn = bgRtn.divide(tmp, 2, BigDecimal.ROUND_HALF_UP); // С���㱣��2λ���������뷨
		
		rtn = bgRtn.doubleValue();
		return rtn;
	}

}
