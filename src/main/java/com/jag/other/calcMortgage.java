package com.jag.other;

import java.math.BigDecimal;

/**
 * 贷款利率计算器（目前只实现了等额本息算法）
 * @author jag522
 *
 */
public class calcMortgage {

	public static void main(String[] args) {
		// TODO 写一个unittest
		// 下面注释掉的代码是一步步的算法，为了推导等额本息还款法的公式是怎么得出来的,目前还没有得出结果，有时间再搞。
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
		
		System.out.println(simpleMathMethod(29, 15, 4.158)); // 贷款29万,贷款15年,年利率为4.158%
		System.out.println(mathMethod(290000, 180, 0.003465));
		
//		System.out.println(simpleMathMethod(100, 20, 6.6555)); // 贷款100万，还款年限为20年，年利率为6.6555%
//		System.out.println(mathMethod(1000000,240,0.00554625));
	}
	
	/**
	 * 
	 * @param amountByWan		贷款数,单位万
	 * @param duarationByYear	贷款期限,单位年
	 * @param ratePerYear		贷款年利率,单位百分
	 * @return
	 * 例如, 贷款29万,贷款15年,年利率为4.158%,则simpleMathMethod(29, 15, 4.158)
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
	 * 例如,贷款290000,贷款180期(15年*12个月),月利率为0.003465(4.158%/12),则mathMethod(290000, 180, 0.003465)
	 */
	public static double mathMethod(int amount, int duarationByMonth, double fractionRatePerMonth) {
		double rtn = 0;
		double dRate = 1 + fractionRatePerMonth;
		BigDecimal tmp = new BigDecimal(dRate);
		BigDecimal bdRate = new BigDecimal(fractionRatePerMonth);
		BigDecimal bdTotalLoad = new BigDecimal(amount);
		BigDecimal bgRtn = new BigDecimal(1);
		// 具体的算法如下
		tmp = tmp.pow(duarationByMonth);
		bgRtn = bgRtn.multiply(bdTotalLoad);
		bgRtn = bgRtn.multiply(bdRate);
		bgRtn = bgRtn.multiply(tmp);
		tmp = tmp.subtract(new BigDecimal(1));
		bgRtn = bgRtn.divide(tmp, 2, BigDecimal.ROUND_HALF_UP); // 小数点保留2位，四舍五入法
		
		rtn = bgRtn.doubleValue();
		return rtn;
	}

}
