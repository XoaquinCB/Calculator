package sample;

import display.Display;
import input.ButtonPad;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage stage;
	public static Scene scene;
	public static VBox layout;
	
	public static Display display;
	public static ButtonPad buttonPad;
	
	private int height = 425;
	private int width = 275;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		// Store the primaryStage in a private variable
		stage = primaryStage;

		// Layout
		layout = new VBox(5);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setPadding(new Insets(15));
		layout.setPrefWidth((width-35)/4);
		layout.setPrefHeight((width-35)/4);
		
		// Display
		display = new Display();
		layout.getChildren().add(display);
		
		// ButtonPad
		buttonPad = new ButtonPad(display);
		layout.getChildren().add(buttonPad);

		// Scene & Stage
		scene = new Scene(layout, width, height, Color.WHITE);
		scene.getStylesheets().add("style.css");
		stage = new Stage();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.show();
	}

}
