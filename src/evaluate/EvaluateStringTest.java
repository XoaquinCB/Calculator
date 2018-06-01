package evaluate;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateStringTest {

	private EvaluateString es = new EvaluateString();

	@Test
	public void evaluate() {
		double stringArray = es.evaluate("1+4-3*5");
		Assert.assertEquals(stringArray, 10, 0);
	}

	@Test
	public void evaluateSameSymbol() {
		double stringArray = es.evaluate("1+4+5");
		Assert.assertEquals(stringArray, 10, 0);
	}

	@Test
	public void formatStringSingleDigit() {
		String[] stringArray = es.formatString("1+2");
		Assert.assertArrayEquals(stringArray, new String[]{"1", "+", "2"});
	}

	@Test
	public void formatStringMultipleDigit() {
		String[] stringArray = es.formatString("10+20");
		Assert.assertArrayEquals(stringArray, new String[]{"10", "+", "20"});
	}

	@Test
	public void evaluateStringArray() {
		double total = es.evaluateStringArray(new String[]{"1", "+", "2", "-", "4", "*", "-1"});
		Assert.assertEquals(total, 1, 0);
	}

}