package input;

import display.Display;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.Main;

import java.util.ArrayList;

public class ButtonPad extends GridPane {

	public static InputButton button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9,
		button_plus, button_minus, button_multiply, button_divide, button_leftBracket, button_rightBracket,
		button_decimal, button_ans;

	public static Button button_equals, button_del;

	public static ArrayList<InputButton> buttonList = new ArrayList<InputButton>();

	public ButtonPad(Display display) {
		this.setVgap(5);//set vertical gap size
		this.setHgap(5);//set horizontal gap size

		// Initialise buttons
		button_0 = new InputButton("0", display);
//		HBox.setHgrow(button_0, Priority.ALWAYS);
		button_0.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_1 = new InputButton("1", display);
//		HBox.setHgrow(button_1, Priority.ALWAYS);
		button_1.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_2 = new InputButton("2", display);
//		HBox.setHgrow(button_2, Priority.ALWAYS);
		button_2.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_3 = new InputButton("3", display);
//		HBox.setHgrow(button_3, Priority.ALWAYS);
		button_3.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_4 = new InputButton("4", display);
//		HBox.setHgrow(button_4, Priority.ALWAYS);
		button_4.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_5 = new InputButton("5", display);
//		HBox.setHgrow(button_4, Priority.ALWAYS);
		button_5.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_6 = new InputButton("6", display);
//		HBox.setHgrow(button_6, Priority.ALWAYS);
		button_6.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_7 = new InputButton("7", display);
//		HBox.setHgrow(button_7, Priority.ALWAYS);
		button_7.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_8 = new InputButton("8", display);
//		HBox.setHgrow(button_8, Priority.ALWAYS);
		button_8.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_9 = new InputButton("9", display);
//		HBox.setHgrow(button_9, Priority.ALWAYS);
		button_9.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_plus = new InputButton("+", display);
//		HBox.setHgrow(button_plus, Priority.ALWAYS);
		button_plus.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_minus = new InputButton("-", display);
//		HBox.setHgrow(button_minus, Priority.ALWAYS);
		button_minus.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_multiply = new InputButton("*", display);
//		HBox.setHgrow(button_multiply, Priority.ALWAYS);
		button_multiply.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_divide = new InputButton("/", display);
//		HBox.setHgrow(button_divide, Priority.ALWAYS);
		button_divide.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_leftBracket = new InputButton("(", display);
//		HBox.setHgrow(button_leftBracket, Priority.ALWAYS);
		button_leftBracket.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_rightBracket = new InputButton(")", display);
//		HBox.setHgrow(button_rightBracket, Priority.ALWAYS);
		button_rightBracket.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_decimal = new InputButton(".", display);
//		HBox.setHgrow(button_decimal, Priority.ALWAYS);
		button_decimal.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_ans = new InputButton("Ans", display);
//		HBox.setHgrow(button_ans, Priority.ALWAYS);
		button_ans.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());

		button_equals = new Button("=");
//		HBox.setHgrow(button_equals, Priority.ALWAYS);
		button_equals.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());
		button_equals.setOnAction(e -> display.compute());//when button is pressed, compute answer using Jake's amazing interpreter

		button_del = new Button("DEL");
//		HBox.setHgrow(button_del, Priority.ALWAYS);
		button_del.setMinSize(Main.layout.getPrefWidth(), Main.layout.getPrefHeight());
		button_del.setOnAction(e -> display.backspace());
		button_del.setFocusTraversable(false);

		// Add buttons to grid
		this.add(button_del, 0, 0);
		this.add(button_leftBracket, 1, 0);
		this.add(button_rightBracket, 2, 0);
		this.add(button_divide, 3, 0);
		this.add(button_7, 0, 1);
		this.add(button_8, 1, 1);
		this.add(button_9, 2, 1);
		this.add(button_multiply, 3, 1);
		this.add(button_4, 0, 2);
		this.add(button_5, 1, 2);
		this.add(button_6, 2, 2);
		this.add(button_minus, 3, 2);
		this.add(button_1, 0, 3);
		this.add(button_2, 1, 3);
		this.add(button_3, 2, 3);
		this.add(button_plus, 3, 3);
		this.add(button_0, 0, 4);
		this.add(button_decimal, 1, 4);
		this.add(button_ans, 2, 4);
		this.add(button_equals, 3, 4);
	}

}
