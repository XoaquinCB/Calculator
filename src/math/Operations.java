package math;

/**
 * 1. Create when starting calculation
 * 2. Call methods to perform an operation
 * 3. Call getTotal() when the calculation has finished
 *
 */
public class Operations implements IOperational {

    private double total;

    public Operations(double startingTotal) {
        total = startingTotal;
    }

    public void add(double num) {
        total += num;
    }

    public void subtract(double num) {
        total -= num;
    }

    public void multiply(double num) {
        total *= num;
    }

    public void divide(double num) {
        total /= num;
    }

    public double getTotal() {
        return total;
    }

}
