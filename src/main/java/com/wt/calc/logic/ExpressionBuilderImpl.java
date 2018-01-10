package com.wt.calc.logic;

import java.math.BigDecimal;

public class ExpressionBuilderImpl implements IExpressionBuilder{
	
	private ILogic logic = new LogicImpl();

	public void buildExpression(char operation){
		if(Numbers.firstNumber.compareTo(Numbers.defaultNumber) == 0){
			if(Numbers.currentValue.equals("")){
				Numbers.firstNumber = new BigDecimal("0");
				Numbers.fullString += "0";
			} else Numbers.firstNumber = new BigDecimal(Numbers.currentValue);
		} else {
			if(Numbers.currentValue.equals(""))
				Numbers.secondNumber = Numbers.defaultNumber;
			else Numbers.secondNumber = new BigDecimal(Numbers.currentValue);
			logic.command();
		}
		Numbers.fullString += Numbers.currentValue;
		Numbers.currentValue = "";
		Numbers.operation = operation;
	}
	
	@Override
	public void addInString(String symbol){
		Numbers.currentValue += symbol;
	}
	
	@Override
	public void delFromString(){
		if(!Numbers.currentValue.equals("")){
			Numbers.currentValue = Numbers.currentValue.substring(0, Numbers.currentValue.length()-1);
			if(Numbers.currentValue.equals(""))
				Numbers.currentValue = "0";
		}
	}

	@Override
	public void addOperationInFullString() {
		Numbers.fullString += " " + Numbers.operation + " ";
	}
	
	@Override 
	public void addNegative(){
		if(Numbers.currentValue.equals("")){
			Numbers.currentValue += "-";
		}
		else if(Numbers.currentValue.charAt(0) == '-'){
			Numbers.currentValue = Numbers.currentValue
					.substring(1, Numbers.currentValue.length());
		} else {
			Numbers.currentValue = "-" + Numbers.currentValue
					.substring(0, Numbers.currentValue.length());			
		}
	}
}