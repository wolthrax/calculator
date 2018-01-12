package com.wt.calc.logic;

import java.math.BigDecimal;
import java.util.Objects;

public class Numbers {

	private static Numbers instance = new Numbers();
	private final BigDecimal defaultNumber = new BigDecimal(Double.MAX_VALUE);

	private BigDecimal firstNumber = defaultNumber;
	private BigDecimal secondNumber = defaultNumber;

	private String currentValue = "";
	private String fullString = "";

	private char operation = ' ';

	private Numbers() {}

	public static Numbers getInstance() {
		if (instance == null)
			instance = new Numbers();
		return instance;
	}

	public BigDecimal getDefaultNumber() {
		return defaultNumber;
	}

	public BigDecimal getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(BigDecimal firstNumber) {
		this.firstNumber = firstNumber;
	}

	public BigDecimal getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(BigDecimal secondNumber) {
		this.secondNumber = secondNumber;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	public String getFullString() {
		return fullString;
	}

	public void setFullString(String fullString) {
		this.fullString = fullString;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Numbers numbers = (Numbers) o;
		return operation == numbers.operation &&
				Objects.equals(defaultNumber, numbers.defaultNumber) &&
				Objects.equals(firstNumber, numbers.firstNumber) &&
				Objects.equals(secondNumber, numbers.secondNumber) &&
				Objects.equals(currentValue, numbers.currentValue) &&
				Objects.equals(fullString, numbers.fullString);
	}

	@Override
	public int hashCode() {

		return Objects.hash(defaultNumber, firstNumber, secondNumber, currentValue, fullString, operation);
	}
}