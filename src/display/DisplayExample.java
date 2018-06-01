package display;

import javafx.scene.control.Button;
import sample.Main;

public class DisplayExample {
	
	public static void init() {
		// Buttons
        Button button1 = new Button("1");
        button1.setOnAction(e -> Main.display.addToInput("1"));//when button is pressed, add "1" to the input text
        button1.setFocusTraversable(false);//set this on all buttons (except '=' button) so that the text input doesn't lose focus
        
        Button button2 = new Button("2");
        button2.setOnAction(e -> Main.display.addToInput("2"));//when button is pressed, add "2" to the input text
        button2.setFocusTraversable(false);//set this on all buttons (except '=' button) so that the text input doesn't lose focus
        
        Button equals = new Button("=");
        equals.setOnAction(e -> Main.display.setAnswer(12556));//when button is pressed, set answer to 12556 (random number...)
        
        Main.layout.getChildren().addAll(button1, button2, equals);//add buttons to layout
	}

}
