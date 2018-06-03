package display;

import evaluate.EvaluateString;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;

public class Display extends VBox {

	private final ArrayList<Character> validCharacters = new ArrayList<Character>(Arrays.asList(
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '(', ')', '.'
	));

	private final ArrayList<String> validStrings = new ArrayList<String>(Arrays.asList(
		"Ans"
	));

	private HBox hBox1;
	private HBox hBox2;
	private TextField inputField;
	private Label answerLabel;
	private EvaluateString evaluateString;

	// Constructor
	public Display() {

		inputField = new TextField() {
			public void paste() {
			}
		};//initialise inputField, and prevent pasting
		inputField.setStyle("-fx-background-color: #fff; -fx-text-fill: #005c7f;");//remove border and set text colour
		setInputSize(18);//set font size
		HBox.setHgrow(inputField, Priority.ALWAYS);//always resize to fit container

		this.setStyle("-fx-border-color: #009edb; -fx-border-width: 2px;");//set a border for the display

		// Add listener to inputField to only allow valid characters to be typed
		inputField.setOnKeyTyped(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				char character = event.getCharacter().charAt(0);//get the character which has been typed
				if (!validCharacters.contains(character)) {//if it's not valid
					event.consume();//cancel the event
				}

				// Remove all of a validString when one of its characters is removed
				for (String current : validStrings) {
					for (int i = 0; i < current.length(); i++) {
						if (inputField.getText().substring(0, inputField.getCaretPosition()).endsWith(current.substring(0, i)) &&
							inputField.getText().substring(inputField.getCaretPosition()).startsWith(current.substring(i + 1))) {
							for (int j = 0; j < current.substring(0, i).length(); j++) {
								inputField.deletePreviousChar();
							}
							for (int j = 0; j < current.substring(i).length(); j++) {
								inputField.deleteNextChar();
							}
						}
					}
				}

			}
		});

		// Add listener to show answer when ENTER is pressed
		inputField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {//if ENTER key if pressed
					compute();//compute answer
					answerLabel.requestFocus();//remove focus from inputField (give focus to answerLabel)
				}
			}
		});

		// Add listener to inputField to stop displaying answer when it gains focus
		inputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) { //if inputField gains focus
				answerLabel.setText("");//remove answer

				String inputText = inputField.getText();
				if (inputText.startsWith("+") || inputText.startsWith("-") || inputText.startsWith("*") || inputText.startsWith("/")) {
					inputField.setText("Ans" + inputText);
				}
			}
		});

		answerLabel = new Label("Answer");//initialise answerLabel
		answerLabel.setStyle("-fx-text-fill: #005c7f;");//set the text colour
		setAnswerSize(20);//set font size
		HBox.setHgrow(answerLabel, Priority.ALWAYS);//always resize to fit its container


		// Arrange objects
		hBox1 = new HBox();//initialise hBox1
		hBox1.setPadding(new Insets(0, 0, 0, 0));//set padding
		hBox1.setAlignment(Pos.BASELINE_LEFT);//set the alignment of inputField to the left
		hBox1.getChildren().add(inputField);//add inputField to hBox1
		this.getChildren().add(hBox1);//add hBox1 to VBox

		hBox2 = new HBox();//initialise hBox2
		hBox2.setPadding(new Insets(0, 5, 0, 0));//set padding
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

			// Add "Ans" if string starts with an operation
			if (input == "+" || input == "-" || input == "*" || input == "/") {
				input = "Ans" + input;
			}
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
	public void setAnswer(String answer) {
		answerLabel.setText(answer);
	}

	// Use the EvaluateString class to compute the calculation
	public void compute() {
		String result = evaluateString.evaluate(getInput());
		setAnswer(result);
	}

}