package com.wt.calc.logic;

import javafx.scene.control.Label;

public interface ILogic {
	
	void command();
	
	void sum();
	void diff();
	void mul();
	void div();
	void pow();
	void percent();
	void c();
	
	
	void showText(Label textCurrent, Label textFull);
	void showText(Label textCurrent, Label textFull, String firstNumber);
	
}
