package sample;

import display.DisplayExample;
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
		layout.setPrefWidth(40);
		layout.setPrefHeight(40);

		DisplayExample.init();

		// Scene & Stage
		scene = new Scene(layout, 300, 350, Color.WHITE);
		scene.getStylesheets().add("style.css");
		stage = new Stage();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.show();
	}

}
