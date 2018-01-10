package com.wt.calc.controllers;

import com.wt.calc.logic.ExpressionBuilderImpl;
import com.wt.calc.logic.IExpressionBuilder;
import com.wt.calc.logic.ILogic;
import com.wt.calc.logic.LogicImpl;
import com.wt.calc.logic.Numbers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
	
	private ILogic logic = new LogicImpl();
	private IExpressionBuilder exBuilder = new ExpressionBuilderImpl();
	
	
	@FXML 
	Label textCurrent;
	
	@FXML 
	Label textFull;
	
	@FXML 
	TextArea textHistory;
	
	public void bOne(ActionEvent event) {
		exBuilder.addInString("1");
		logic.showText(textCurrent, textFull);
	}
	
	public void bTwo(ActionEvent event) {
		exBuilder.addInString("2");
		logic.showText(textCurrent, textFull);
	}
	
	public void bThree(ActionEvent event) {
		exBuilder.addInString("3");
		logic.showText(textCurrent, textFull);
	}
	
	public void bFour(ActionEvent event) {
		exBuilder.addInString("4");
		logic.showText(textCurrent, textFull);
	}
	
	public void bFive(ActionEvent event) {
		exBuilder.addInString("5");
		logic.showText(textCurrent, textFull);
	}
	
	public void bSix(ActionEvent event) {
		exBuilder.addInString("6");
		logic.showText(textCurrent, textFull);
	}
	
	public void bSeven(ActionEvent event) {
		exBuilder.addInString("7");
		logic.showText(textCurrent, textFull);
	}
	
	public void bEight(ActionEvent event) {
		exBuilder.addInString("8");
		logic.showText(textCurrent, textFull);
	}
	
	public void bNine(ActionEvent event) {
		exBuilder.addInString("9");
		logic.showText(textCurrent, textFull);
	}
	
	public void bZero(ActionEvent event) {
		exBuilder.addInString("0");
		logic.showText(textCurrent, textFull);
	}
	
	public void bPoint(ActionEvent event) {
		exBuilder.addInString(".");
		logic.showText(textCurrent, textFull);
	}
	
	public void bNeg(ActionEvent event) {
		exBuilder.addNegative();
		logic.showText(textCurrent, textFull);
	}

	public void bC(ActionEvent event) {
		logic.c();
		textCurrent.setText("0");
	}

	public void bSum(ActionEvent event) {
		exBuilder.buildExpression('+');
		exBuilder.addOperationInFullString();
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}

	public void bDiff(ActionEvent event) {
		exBuilder.buildExpression('-');
		exBuilder.addOperationInFullString();
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}

	public void bMul(ActionEvent event) {
		exBuilder.buildExpression('*');
		exBuilder.addOperationInFullString();
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}
	
	public void bDiv(ActionEvent event) {
		exBuilder.buildExpression('/');
		exBuilder.addOperationInFullString();
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}
	
	public void bPow(ActionEvent event) {
		exBuilder.buildExpression('^');
		exBuilder.addOperationInFullString();
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}

	public void bPercent(ActionEvent event) {
		logic.percent();
		textCurrent.setText(Numbers.secondNumber.toString());
		Numbers.currentValue = Numbers.secondNumber.toString();
	}

	public void bEq(ActionEvent event) {
		exBuilder.buildExpression(Numbers.operation);
		textHistory.appendText(Numbers.fullString + " = " + 
			Numbers.firstNumber + "\n");
		logic.showText(textCurrent, textFull, Numbers.firstNumber.toString());
	}
	
	public void bClear(ActionEvent event) {
		textHistory.setText("");
	}
	
	public void bDel(ActionEvent event) {
		exBuilder.delFromString();
		logic.showText(textCurrent, textFull);
	}

	public void keyCntr(KeyEvent key) {
		
		if(key.getCode().equals(KeyCode.DIGIT1) || key.getCode().equals(KeyCode.NUMPAD1))
			bOne(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT2) || key.getCode().equals(KeyCode.NUMPAD2))
			bTwo(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT3) || key.getCode().equals(KeyCode.NUMPAD3))
			bThree(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT4) || key.getCode().equals(KeyCode.NUMPAD4))
			bFour(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT5) || key.getCode().equals(KeyCode.NUMPAD5))
			bFive(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT6) || key.getCode().equals(KeyCode.NUMPAD6))
			bSix(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT7) || key.getCode().equals(KeyCode.NUMPAD7))
			bSeven(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT8) || key.getCode().equals(KeyCode.NUMPAD8))
			bEight(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT9) || key.getCode().equals(KeyCode.NUMPAD9))
			bNine(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIGIT0) || key.getCode().equals(KeyCode.NUMPAD0))
			bZero(new ActionEvent());
		if(key.getCode().equals(KeyCode.DIVIDE))
			bDiv(new ActionEvent());
		if(key.getCode().equals(KeyCode.MULTIPLY))
			bMul(new ActionEvent());
		if(key.getCode().equals(KeyCode.SUBTRACT))
			bDiff(new ActionEvent());
		if(key.getCode().equals(KeyCode.ADD))
			bSum(new ActionEvent());
		if(key.getCode().equals(KeyCode.ENTER))
			bEq(new ActionEvent());
		if(key.getCode().equals(KeyCode.P))
			bPercent(new ActionEvent());
		if(key.getCode().equals(KeyCode.C))
			bC(new ActionEvent());
		if(key.getCode().equals(KeyCode.BACK_SPACE))
			bDel(new ActionEvent());	
	}
}
