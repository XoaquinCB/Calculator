package display;

import input.InputButton;
import javafx.scene.control.Button;
import sample.Main;

public class DisplayExample {
	
	public static Display display;
	
	public static void init() {
		
		display = new Display();
		
		// Buttons
		InputButton button_1 = new InputButton("1", display);
		InputButton button_2 = new InputButton("2", display);
		InputButton button_plus = new InputButton("+", display);
        
        Button equals = new Button("=");
        equals.setOnAction(e -> display.compute());//when button is pressed, set answer to 12556 (random number...)
        
        Main.layout.getChildren().add(display);
        Main.layout.getChildren().addAll(button_1, button_2, button_plus, equals);//add buttons to layout
	}

}
