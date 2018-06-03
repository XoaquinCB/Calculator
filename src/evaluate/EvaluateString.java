package evaluate;

import evaluate.operations.OpSymbol;
import evaluate.operations.Operation;
import evaluate.operations.Operations;

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
	public String evaluate(String calcString) {
		/**
		 * Remove the brackets in here?
		 * Find the innermost brackets - while loop w/ index variable
		 * Evaluate innermost brackets and substitute them in
		 * Keep going until there's no more brackets
		 * Go on as usual
		 */
		try {
			String withAsterisks = addAsterisk(calcString);
			String removeAns = replaceAns(withAsterisks);
			ArrayList<String> formattedString = formatString(removeAns);
			if (formattedString.size() == 0)
				return "Error";
			double result = evaluateStringArray(formattedString);
			ans = result;
			return Double.toString(result);
		} catch (Exception e) {
			return "Error";
		}
	}

	/**
	 * Takes a string and replaces the part "Ans" with the previous
	 * answer stored
	 *
	 * @param string The string with the "Ans" variable in
	 * @return A string with a numerical value instead of "Ans"
	 */
	public String replaceAns(String string) {
		return string.replace("Ans", "(" + ans + ")");
	}

	/**
	 * Takes a string and adds an asterisk if needed
	 * eg. 5(2+3) -> 5*(2+3)
	 *
	 * @param string The string without any asterisks
	 * @return A string containing asterisks in the correct places
	 */
	public String addAsterisk(String string) {
		String newString = "";
		boolean added = false;
		int index = 0;

		for (int i = 0; i < string.length() - 1; i++) {
			if (string.charAt(i) != '*' && string.charAt(i + 1) == '(') {
				newString += string.substring(index, i + 1) + "*";
				index = i + 1;
				added = true;
			}
			if (i == string.length() - 2)
				newString += string.substring(index);
		}

		if (!added)
			return string;
		return newString;
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
