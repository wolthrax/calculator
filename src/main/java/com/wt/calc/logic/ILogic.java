package com.wt.calc.logic;

import javafx.scene.control.Label;

public interface ILogic {
	
	public void command();
	
	public void sum();
	public void diff();
	public void mul();
	public void div();
	public void pow();
	public void percent();
	public void c();
	
	
	public void showText(Label textCurrent, Label textFull);
	public void showText(Label textCurrent, Label textFull, String firstNumber);
	
}
