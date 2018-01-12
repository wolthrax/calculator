package com.wt.calc.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.scene.control.Label;

public class LogicImpl implements ILogic{

	private Numbers numbers = Numbers.getInstance();
	
	@Override
	public void command(){
		switch (numbers.getOperation()) {
		case '+':
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(new BigDecimal("0"));
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			sum();
			break;
			
		case '-':
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(new BigDecimal("0"));
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			diff();
			break;
			
		case '*':
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(new BigDecimal("1"));
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			mul();
			break;
			
		case '/':
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(new BigDecimal("1"));
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			div();
			break;
		case '^':
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(new BigDecimal("1"));
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			pow();
			break;
		}
	}

	@Override
	public void sum() {
		numbers.setFirstNumber(numbers.getFirstNumber().add(numbers.getSecondNumber()));
		numbers.setSecondNumber(numbers.getDefaultNumber());
	}

	@Override
	public void diff() {
		numbers.setFirstNumber(numbers.getFirstNumber().subtract(numbers.getSecondNumber()));
		numbers.setSecondNumber(numbers.getDefaultNumber());
	}
	
	@Override
	public void mul() {
		numbers.setFirstNumber(numbers.getFirstNumber().multiply(numbers.getSecondNumber()));
		numbers.setSecondNumber(numbers.getDefaultNumber());
	}
	
	@Override
	public void div() {
		if(numbers.getSecondNumber().compareTo(new BigDecimal("0")) == 0){
			numbers.setCurrentValue("");
			numbers.setFullString("");
			numbers.setFullString("Division by zero is impossible");
			numbers.setFirstNumber(BigDecimal.ZERO);
		} else{
			numbers.setFirstNumber(numbers.getFirstNumber().divide(numbers.getSecondNumber(), 9, RoundingMode.HALF_UP).stripTrailingZeros());
			numbers.setSecondNumber(numbers.getDefaultNumber());
		}
	}
	
	@Override
	public void pow() {
		numbers.setFirstNumber(numbers.getFirstNumber().pow(numbers.getSecondNumber().intValue()));
		numbers.setSecondNumber(numbers.getDefaultNumber());
	}
	
	@Override
	public void percent() {
		numbers.setSecondNumber(numbers.getFirstNumber().divide(new BigDecimal("100")).multiply(new BigDecimal(numbers.getCurrentValue())));
	}

	@Override
	public void c() {

		numbers.setCurrentValue("");
		numbers.setFullString("");
		numbers.setFirstNumber(numbers.getDefaultNumber());
		numbers.setSecondNumber(numbers.getDefaultNumber());
	}
	
	@Override
	public void showText(Label textCurrent, Label textFull) {
		textCurrent.setText(numbers.getCurrentValue());
		textFull.setText(numbers.getFullString());
	}

	@Override
	public void showText(Label textCurrent, Label textFull, String firstNumber) {
		textCurrent.setText(firstNumber);
		textFull.setText(numbers.getFullString());
	}

}
