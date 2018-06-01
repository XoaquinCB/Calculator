package evaluate;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
		ArrayList<String> stringArray = es.formatString("1+2");
		ArrayList<String> compareArray = new ArrayList<String>();
		compareArray.add("1");
		compareArray.add("+");
		compareArray.add("2");
		assertThat(stringArray, is(compareArray));
	}

	@Test
	public void formatStringMultipleDigit() {
		ArrayList<String> stringArray = es.formatString("10+20");
		ArrayList<String> compareArray = new ArrayList<String>();
		compareArray.add("10");
		compareArray.add("+");
		compareArray.add("20");
		assertThat(stringArray, is(compareArray));
	}

	@Test
	public void formatStringMultipleDigit3Args() {
		ArrayList<String> stringArray = es.formatString("10+20-5");
		ArrayList<String> compareArray = new ArrayList<String>();
		compareArray.add("10");
		compareArray.add("+");
		compareArray.add("20");
		compareArray.add("-");
		compareArray.add("5");
		assertThat(stringArray, is(compareArray));
	}

	@Test
	public void evaluateStringArray() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("10");
		array.add("+");
		array.add("20");
		double total = es.evaluateStringArray(array);
		Assert.assertEquals(total, 30, 0);
	}

	@Test
	public void evaluateStringArray2() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("1");
		array.add("+");
		array.add("4");
		array.add("+");
		array.add("5");
		double total = es.evaluateStringArray(array);
		Assert.assertEquals(total, 10, 0);
	}

}