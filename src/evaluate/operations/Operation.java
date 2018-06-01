package evaluate.operations;

/**
 * 1. Create when starting calculation
 * 2. Call methods to perform an operation
 * 3. Call getTotal() when the calculation has finished
 */
public class Operation implements IOperational {

	private double total;

	/**
	 * Stores the total as a private variable
	 *
	 * @param startingTotal The starting total of the operation object
	 */
	public Operation(double startingTotal) {
		total = startingTotal;
	}

	/**
	 * Adds a given number to the total
	 *
	 * @param num The number to add
	 */
	public void add(double num) {
		total += num;
	}

	/**
	 * Subtracts a given number from the total
	 *
	 * @param num The number to subtract
	 */
	public void subtract(double num) {
		total -= num;
	}

	/**
	 * Multiplies the total by a given number
	 *
	 * @param num The multiplier
	 */
	public void multiply(double num) {
		total *= num;
	}

	/**
	 * Divides the total by a given number
	 *
	 * @param num The denominator
	 */
	public void divide(double num) {
		total /= num;
	}

	/**
	 * Gets the combined total of all the operations
	 *
	 * @return The total
	 */
	public double getTotal() {
		return total;
	}

}
