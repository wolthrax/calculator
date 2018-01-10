package com.wt.calc.logic;

public interface IExpressionBuilder {

	void buildExpression(char operation);
	
	void addInString(String symbol);
	void delFromString();
	void addOperationInFullString();
	void addNegative();
}
