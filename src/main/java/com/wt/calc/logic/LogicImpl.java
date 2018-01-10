package com.wt.calc.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.scene.control.Label;

public class LogicImpl implements ILogic{
	
	@Override
	public void command(){
		switch (Numbers.operation) {
		case '+':
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = new BigDecimal("0");
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			sum();
			break;
			
		case '-':
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = new BigDecimal("0");
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			diff();
			break;
			
		case '*':
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = new BigDecimal("1");
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			mul();
			break;
			
		case '/':
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = new BigDecimal("1");
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			div();
			break;
		case '^':
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = new BigDecimal("1");
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			pow();
			break;
		}
	}

	@Override
	public void sum() {
		Numbers.firstNumber = Numbers.firstNumber.add(Numbers.secondNumber);
		Numbers.secondNumber = Numbers.defaultNumber;
	}

	@Override
	public void diff() {
		Numbers.firstNumber = Numbers.firstNumber.subtract(Numbers.secondNumber);
		Numbers.secondNumber = Numbers.defaultNumber;
	}
	
	@Override
	public void mul() {
		Numbers.firstNumber = Numbers.firstNumber.multiply(Numbers.secondNumber);
		Numbers.secondNumber = Numbers.defaultNumber;
	}
	
	@Override
	public void div() {
		if(Numbers.secondNumber.compareTo(new BigDecimal("0")) == 0){
			Numbers.currentValue = "";
			Numbers.fullString = "";
			Numbers.fullString = "Division by zero is impossible";
			Numbers.firstNumber = BigDecimal.ZERO;
		} else{
			Numbers.firstNumber = Numbers.firstNumber.
					divide(Numbers.secondNumber, 32, RoundingMode.HALF_UP);
			Numbers.secondNumber = Numbers.defaultNumber;
		}
	}
	
	@Override
	public void pow() {
		Numbers.firstNumber = Numbers.firstNumber.pow(Numbers.secondNumber.intValue());
		Numbers.secondNumber = Numbers.defaultNumber;
	}
	
	@Override
	public void percent() {
		Numbers.secondNumber = Numbers.firstNumber.divide(new BigDecimal("100")).
				multiply(new BigDecimal(Numbers.currentValue));
	}

	@Override
	public void c() {
		Numbers.currentValue = "";
		Numbers.fullString = "";
		Numbers.firstNumber = Numbers.defaultNumber;
		Numbers.secondNumber = Numbers.defaultNumber;
	}
	
	@Override
	public void showText(Label textCurrent, Label textFull) {
		textCurrent.setText(Numbers.currentValue);
		textFull.setText(Numbers.fullString);
	}

	@Override
	public void showText(Label textCurrent, Label textFull, String firstNumber) {
		textCurrent.setText(firstNumber);
		textFull.setText(Numbers.fullString);
	}

}
