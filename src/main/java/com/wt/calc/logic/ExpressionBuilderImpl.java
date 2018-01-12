package com.wt.calc.logic;

import java.math.BigDecimal;

public class ExpressionBuilderImpl implements IExpressionBuilder{
	
	private ILogic logic = new LogicImpl();
	private Numbers numbers = Numbers.getInstance();

	public void buildExpression(char operation){
		if(numbers.getFirstNumber().compareTo(numbers.getDefaultNumber()) == 0){
			if(numbers.getCurrentValue().equals("")){
				numbers.setFirstNumber(new BigDecimal("0"));
				numbers.setFullString(numbers.getFullString()+"0");
			} else numbers.setFirstNumber(new BigDecimal(numbers.getCurrentValue()));
		} else {
			if(numbers.getCurrentValue().equals(""))
				numbers.setSecondNumber(numbers.getDefaultNumber());
			else numbers.setSecondNumber(new BigDecimal(numbers.getCurrentValue()));
			logic.command();
		}

		numbers.setFullString(numbers.getFullString()+numbers.getCurrentValue());
		numbers.setCurrentValue("");
		numbers.setOperation(operation);
	}
	
	@Override
	public void addToString(String symbol){
		numbers.setCurrentValue(numbers.getCurrentValue() + symbol);
	}
	
	@Override
	public void delFromString(){
		if(!numbers.getCurrentValue().equals("")){
			numbers.setCurrentValue(numbers.getCurrentValue().substring(0, numbers.getCurrentValue().length()-1));
			if(numbers.getCurrentValue().equals(""))
				numbers.setCurrentValue("0");
		}
	}

	@Override
	public void addOperationInFullString() {
		numbers.setFullString(numbers.getFullString() + " " + numbers.getOperation() + " ");
	}
	
	@Override 
	public void addNegative(){
		if(numbers.getCurrentValue().equals("")){
			numbers.setCurrentValue(numbers.getCurrentValue() + "-");
		}
		else if(numbers.getCurrentValue().charAt(0) == '-'){
			numbers.setCurrentValue(numbers.getCurrentValue().substring(1, numbers.getCurrentValue().length()));

		} else {
			numbers.setCurrentValue("-" + numbers.getCurrentValue().substring(0, numbers.getCurrentValue().length()));
		}
	}
}