package com.wt.calc.logic;

import java.math.BigDecimal;

public class Numbers {
	
	public static final BigDecimal defaultNumber = new BigDecimal(Double.MAX_VALUE);
	
	public static BigDecimal firstNumber = defaultNumber;
	public static BigDecimal secondNumber = defaultNumber;
	
	public static String currentValue = "";
	public static String fullString = "";
	
	public static char operation = ' ';
}