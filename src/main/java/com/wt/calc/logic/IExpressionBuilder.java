package com.wt.calc.logic;

public interface IExpressionBuilder {

	public void buildExpression(char operation);
	
	public void addInString(String symbol);
	public void delFromString();
	public void addOperationInFullString();
	public void addNegative();
}
