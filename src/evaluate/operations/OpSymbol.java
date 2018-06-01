package evaluate.operations;

/**
 * Stores a symbol as a string and the matching operation enum
 * eg. "+" and Operations.ADD
 */
public class OpSymbol {

	public String symbol;
	public Operations op;

	public OpSymbol(String symbol, Operations op) {
		this.symbol = symbol;
		this.op = op;
	}

}
