package input;

import display.Display;
import javafx.scene.control.Button;

public class InputButton extends Button {
	
	public InputButton(String input, Display display) {
		this.setText(input);//set the text in the button to its number
        this.setOnAction(e -> display.addToInput(input));//when button is pressed, add "1" to the input text
        this.setFocusTraversable(false);//set this on all buttons (except '=' button) so that the text input doesn't lose focus
	}

}
