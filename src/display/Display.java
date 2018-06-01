package display;

import java.util.ArrayList;
import java.util.Arrays;

import evaluate.EvaluateString;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Display extends VBox {
	
	private final ArrayList<Character> validCharacters = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '(', ')'));
	
	private HBox hBox1;
	private HBox hBox2;
	private TextField inputField;
	private Label answerLabel;
	
	// Constructor
	public Display() {
		
		inputField = new TextField();//initialise inputField
		inputField.setStyle("-fx-background-color: #fff;");//remove border
		setInputSize(20);//set font size
		HBox.setHgrow(inputField, Priority.ALWAYS);//always resize to fit container
		
		// Add listener to inputField to only allow valid characters
		inputField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.equals("")) { //make sure inputField isn't empty
		        if(!validCharacters.contains(newValue.charAt(newValue.length()-1))) { //if the last character entered isn't in validCharacters
		        	inputField.setText(newValue.substring(0, newValue.length()-1));//remove last character
		        }
			}
	    });
		
		// Add listener to inputField to stop displaying answer when it gains focus
		inputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue) { //if inputField gains focus
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
	    
	}
	
	// Set font size of intput text
	public void setInputSize(int size) {
		inputField.setFont(new Font("Monospace", size));
	}
	
	// Set font size of answer text
	public void setAnswerSize(int size) {
		answerLabel.setFont(new Font("Calibri", size));
	}
	
	public void addToInput(String input) {
		if(!inputField.isFocused()) {
			inputField.setText("");
			inputField.requestFocus();
		}
		inputField.appendText(input);
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
		EvaluateString es = new EvaluateString();
		double result = es.evaluate(getInput());
		setAnswer(result);
	}

}