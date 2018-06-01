package evaluate;

import evaluate.operations.OpSymbol;
import evaluate.operations.Operations;
import evaluate.operations.Operation;

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

	/**
	 * Takes a string, formats it, computes the value and returns it
	 *
	 * @param calcString The string to evaluate
	 * @return The numerical result
	 */
	public double evaluate(String calcString) {
		return 3.1415;
	}

	/**
	 * Takes a string and correctly formats it so that it can
	 * be used with the evaluateStringArray() method
	 *
	 * @param calcString The string to format
	 * @return A formatted string array
	 */
	public String[] formatString(String calcString) {
		String[] stringArray = new String[calcString.length()];

		for (int i = 0; i < calcString.length(); i++) {
			for (int j = 0; j < opSymbols.length; j++) {
				if (calcString.charAt(i) == opSymbols[j].symbol.charAt(0)) {
					// TODO: 01/06/18 Format this string

				}
			}
		}

		return stringArray;
	}

	/**
	 * Takes a formatted string array and performs the appropriate
	 * calculations to return a result
	 *
	 * @param parts The formatted string array from formatString()
	 * @return The computed result
	 */
	public double evaluateStringArray(String[] parts) {
		Operation total = new Operation(Double.parseDouble(parts[0]));

		for (int i = 1; i < parts.length; i += 2) {
			for (int j = 0; j < opSymbols.length; j++) {
				if (parts[i] == opSymbols[j].symbol) {
					double number = Double.parseDouble(parts[i + 1]);
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
