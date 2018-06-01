package sample;

import display.DisplayExample;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

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

		DisplayExample.init();

		// Scene & Stage
		scene = new Scene(layout, 300, 300);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.show();
	}

}
