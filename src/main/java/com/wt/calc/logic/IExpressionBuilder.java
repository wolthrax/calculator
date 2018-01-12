package com.wt.calc.logic;

public interface IExpressionBuilder {

	void buildExpression(char operation);
	
	void addToString(String symbol);
	void delFromString();
	void addOperationInFullString();
	void addNegative();
}
