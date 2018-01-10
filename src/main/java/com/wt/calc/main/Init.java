package com.wt.calc.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Init extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/RootLayout.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setResizable(true);;
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.show();
	}
	
	public static void startApp(String[] args){
		launch(args);
	}

}
