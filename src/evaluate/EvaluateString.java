package evaluate;

import evaluate.operations.OpSymbol;
import evaluate.operations.Operation;
import evaluate.operations.Operations;

import java.util.ArrayList;

public class EvaluateString implements IEvaluable {

	private OpSymbol[] opSymbols = new OpSymbol[] {
		new OpSymbol("+", Operation.ADD),
		new OpSymbol("-", Operation.SUBTRACT),
		new OpSymbol("*", Operation.MULTIPLY),
		new OpSymbol("/", Operation.DIVIDE)
	};

    public double evaluate(String calcString) {
    	return 3.1415;
    }

    public String[] formatString(String calcString) {
	    String[] stringArray = new String[calcString.length()];

	    for (int i = 0; i < calcString.length(); i++) {
			for (int j = 0; j < opSymbols.length; j++) {
				if (calcString.charAt(i) == opSymbols[j].symbol.charAt(0)) {
					// SPLIT THE STRING
				}
			}
	    }

	    return stringArray;
    }

    public double evaluateStringArray(String[] parts) {
	    Operations total = new Operations(Double.parseDouble(parts[0]));

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
