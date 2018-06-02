package display;

import input.InputButton;
import javafx.scene.control.Button;
import sample.Main;

public class DisplayExample {

	public static Display display;

	public static void init() {

		display = new Display();

		// Input buttons
		InputButton button_1 = new InputButton("1", display);
		InputButton button_2 = new InputButton("2", display);
		InputButton button_plus = new InputButton("Ans", display);
        
		// Equals button
		Button equals = new Button("=");
		equals.setOnAction(e -> display.compute());//when button is pressed, compute answer using Jake's amazing interpreter

		// Set minimum button width & heights
		button_1.setMinWidth(Main.layout.getPrefWidth());
		button_2.setMinWidth(Main.layout.getPrefWidth());
		button_plus.setMinWidth(Main.layout.getPrefWidth());
		equals.setMinWidth(Main.layout.getPrefWidth());

		button_1.setMinHeight(Main.layout.getPrefHeight());
		button_2.setMinHeight(Main.layout.getPrefHeight());
		button_plus.setMinHeight(Main.layout.getPrefHeight());
		equals.setMinHeight(Main.layout.getPrefHeight());

		Main.layout.getChildren().add(display);
		Main.layout.getChildren().addAll(button_1, button_2, button_plus, equals);//add buttons to layout
	}

}
