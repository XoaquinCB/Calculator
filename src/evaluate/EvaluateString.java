package evaluate;

import com.sun.javaws.exceptions.InvalidArgumentException;
import evaluate.operations.OpSymbol;
import evaluate.operations.Operations;
import evaluate.operations.Operation;

import java.util.ArrayList;

/**
 * A class that is responsible for computing the value
 * of a given string that contains arithmetic operations
 */
public class EvaluateString implements IEvaluable {

	// Store the symbols along with the given operation for reference
	private OpSymbol[] opSymbols = new OpSymbol[]{
		new OpSymbol("+", Operations.ADD),
		new OpSymbol("-", Operations.SUBTRACT),
		new OpSymbol("*", Operations.MULTIPLY),
		new OpSymbol("/", Operations.DIVIDE)
	};

	// Store the previous answer
	private double ans = 0;

	/**
	 * Takes a string, formats it, computes the value and returns it
	 *
	 * @param calcString The string to evaluate
	 * @return The numerical result
	 */
	public double evaluate(String calcString) {
		String removeAns = replaceAns(calcString);
		ArrayList<String> formattedString = formatString(removeAns);
		if (formattedString.size() == 0)
			return 0;
		double result = evaluateStringArray(formattedString);
		ans = result;
		return result;
	}

	/**
	 * Takes a string and replaces the part "Ans" with the previous
	 * answer stored
	 *
	 * @param string The string with the "Ans" variable in
	 * @return A string with a numerical value instead of "Ans"
	 */
	public String replaceAns(String string) {
		return string.replace("Ans", "" + ans);
	}

	/**
	 * Takes a string and correctly formats it so that it can
	 * be used with the evaluateStringArray() method
	 *
	 * @param calcString The string to format
	 * @return A formatted string array
	 */
	public ArrayList<String> formatString(String calcString) {
		ArrayList<String> stringArrayList = new ArrayList<String>();
		int startIndex = 0;

		for (int i = 0; i < calcString.length(); i++) {
			for (int j = 0; j < opSymbols.length; j++) {
				char symbol = opSymbols[j].symbol.charAt(0);
				if (calcString.charAt(i) == symbol) {
					stringArrayList.add(calcString.substring(startIndex, i));
					stringArrayList.add("" + calcString.charAt(i));
					startIndex = i + 1;
				}
			}
			if (i == calcString.length() - 1) {
				stringArrayList.add(calcString.substring(startIndex, calcString.length()));
			}
		}

		return stringArrayList;
	}

	/**
	 * Takes a formatted string array and performs the appropriate
	 * calculations to return a result
	 *
	 * @param parts The formatted string array from formatString()
	 * @return The computed result
	 */
	public double evaluateStringArray(ArrayList<String> parts) {
		Operation total = new Operation(Double.parseDouble(parts.get(0)));

		for (int i = 1; i < parts.size(); i += 2) {
			for (int j = 0; j < opSymbols.length; j++) {
				if (parts.get(i).equals(opSymbols[j].symbol)) {
					double number = Double.parseDouble(parts.get(i + 1));
					switch (opSymbols[j].op) {
						case ADD:
							total.add(number);
							break;
						case SUBTRACT:
							total.subtract(number);
							break;
						case MULTIPLY:
							total.multiply(number);
							break;
						case DIVIDE:
							total.divide(number);
							break;
					}
				}
			}
		}

		return total.getTotal();
	}

}
