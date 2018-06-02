package display;

import java.util.ArrayList;
import java.util.Arrays;

import evaluate.EvaluateString;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Display extends VBox {

	private final ArrayList<Character> validCharacters = new ArrayList<Character>(Arrays.asList(
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '(', ')', '.'
	));
  
	private HBox hBox1;
	private HBox hBox2;
	private TextField inputField;
	private Label answerLabel;
	private EvaluateString evaluateString;

	// Constructor
	public Display() {
		
		inputField = new TextField() { public void paste() { } };//initialise inputField, and prevent pasting
		inputField.setStyle("-fx-background-color: #fff;");//remove border
		setInputSize(20);//set font size
		HBox.setHgrow(inputField, Priority.ALWAYS);//always resize to fit container
		
		// Add listener to inputField to only allow valid characters to be typed
		 inputField.setOnKeyTyped(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				char character = event.getCharacter().charAt(0);//get the character which has been typed
				if(!validCharacters.contains(character)) {//if it's not valid
					event.consume();//cancel the event
				}
				
				// Removing "Ans"
				if(inputField.getText().substring(0, inputField.getCaretPosition()).endsWith("An")) {
					inputField.deletePreviousChar();
					inputField.deletePreviousChar();
				} else if(inputField.getText().substring(inputField.getCaretPosition()).startsWith("ns")) {
					inputField.deleteNextChar();
					inputField.deleteNextChar();
				} else if(inputField.getText().substring(0, inputField.getCaretPosition()).endsWith("A") && inputField.getText().substring(inputField.getCaretPosition()).startsWith("s")) {
					inputField.deleteNextChar();
					inputField.deletePreviousChar();
				}
			}
		 });

		// Add listener to inputField to stop displaying answer when it gains focus
		inputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) { //if inputField gains focus
				answerLabel.setText("");//remove answer
			}
		});

		answerLabel = new Label("Answer");//initialise answerLabel
		setAnswerSize(30);//set font size
		HBox.setHgrow(answerLabel, Priority.ALWAYS);//always resize to fit its container


		// Arrange objects
		hBox1 = new HBox();//initialise hBox1
		hBox1.setPadding(new Insets(0, 10, 0, 10));//set padding
		hBox1.setAlignment(Pos.BASELINE_LEFT);//set the alignment of inputField to the left
		hBox1.getChildren().add(inputField);//add inputField to hBox1
		this.getChildren().add(hBox1);//add hBox1 to VBox

		hBox2 = new HBox();//initialise hBox2
		hBox2.setPadding(new Insets(0, 10, 0, 0));//set padding
		hBox2.setAlignment(Pos.BASELINE_RIGHT);//set the alignment of inputField to the right
		hBox2.getChildren().add(answerLabel);//add inputField to hBox2
		this.getChildren().add(hBox2);//add hBox1 to VBox
		
		evaluateString = new EvaluateString();
    
	}

	// Set font size of intput text
	public void setInputSize(int size) {
		inputField.setFont(new Font("Monospace", size));
	}

	// Set font size of answer text
	public void setAnswerSize(int size) {
		answerLabel.setFont(new Font("Calibri", size));
	}
	
  // Add text to inputField
	public void addToInput(String input) {
		if (!inputField.isFocused()) {
			inputField.setText("");
			inputField.requestFocus();
		}
		inputField.insertText(inputField.getCaretPosition(), input);//insert the input where the caret is (vertical cursor)
	}
	
	// Maunually perform a backspace
	public void backspace() {
		inputField.deletePreviousChar();
	}

	// Get the text from the inputField
	public String getInput() {
		return inputField.getText();
	}

	// Set the answerLabel to a value
	public void setAnswer(double answer) {
		answerLabel.setText(Double.toString(answer));
	}

	// Use the EvaluateString class to compute the calculation
	public void compute() {
		double result = evaluateString.evaluate(getInput());
		setAnswer(result);
	}

}