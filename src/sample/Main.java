package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Main extends Application {

    private Stage stage;
    private Scene scene;
    private VBox layout;
    private Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Store the primaryStage in a private variable
        stage = primaryStage;

        // Components
        label = new Label("Calculator");

        // Layout
        layout = new VBox(15);
        layout.getChildren().add(label);
        layout.setAlignment(Pos.CENTER);

        // Scene & Stage
        scene = new Scene(layout, 300, 300);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

}
