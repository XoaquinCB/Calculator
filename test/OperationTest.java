import evaluate.operations.Operation;
import org.junit.Assert;
import org.junit.Test;

public class OperationTest {

	@Test
	public void getTotalInt() {
		Operation op = new Operation(1);
		Assert.assertEquals(op.getTotal(), 1, 0);
	}

	@Test
	public void getTotalDouble() {
		Operation op = new Operation(1.529);
		Assert.assertEquals(op.getTotal(), 1.529, 0);
	}

	@Test
	public void addInt() {
		Operation op = new Operation(1);
		op.add(2);
		Assert.assertEquals(op.getTotal(), 3, 0);
	}

	@Test
	public void addDouble() {
		Operation op = new Operation(1.25);
		op.add(0.5);
		Assert.assertEquals(op.getTotal(), 1.75, 0);
	}

	@Test
	public void subtractInt() {
		Operation op = new Operation(4);
		op.subtract(3);
		Assert.assertEquals(op.getTotal(), 1, 0);
	}

	@Test
	public void subtractDouble() {
		Operation op = new Operation(2.25);
		op.subtract(1.25);
		Assert.assertEquals(op.getTotal(), 1, 0);
	}

	@Test
	public void multiplyInt() {
		Operation op = new Operation(3);
		op.multiply(4);
		Assert.assertEquals(op.getTotal(), 12, 0);
	}

	@Test
	public void multipleDouble() {
		Operation op = new Operation(1.5);
		op.multiply(2.25);
		Assert.assertEquals(op.getTotal(), 3.375, 0);
	}

	@Test
	public void divideInt() {
		Operation op = new Operation(8);
		op.divide(4);
		Assert.assertEquals(op.getTotal(), 2, 0);
	}

	@Test
	public void divideDouble() {
		Operation op = new Operation(4.5);
		op.divide(1.5);
		Assert.assertEquals(op.getTotal(), 3, 0);
	}

	@Test
	public void chainInt() {
		Operation op = new Operation(1);
		op.add(6);
		op.subtract(1);
		op.multiply(2);
		op.divide(3);
		Assert.assertEquals(op.getTotal(), 4, 0);
	}

	@Test
	public void chainDouble() {
		Operation op = new Operation(0.5);
		op.add(1.5);
		op.subtract(0.5);
		op.multiply(2);
		op.divide(1.5);
		Assert.assertEquals(op.getTotal(), 2, 0);
	}

	@Test
	public void chainMixed() {
		Operation op = new Operation(2);
		op.add(2.5);
		op.subtract(1);
		op.multiply(1.5);
		op.divide(3);
		Assert.assertEquals(op.getTotal(), 1.75, 0);
	}

}