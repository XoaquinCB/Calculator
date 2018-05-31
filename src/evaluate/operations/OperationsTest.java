package evaluate.operations;

import org.junit.Assert;
import org.junit.Test;

public class OperationsTest {

    @Test
    public void getTotalInt() {
        Operations op = new Operations(1);
        Assert.assertEquals(op.getTotal(), 1, 0);
    }

    @Test
    public void getTotalDouble() {
        Operations op = new Operations(1.529);
        Assert.assertEquals(op.getTotal(), 1.529, 0);
    }

    @Test
    public void addInt() {
        Operations op = new Operations(1);
        op.add(2);
        Assert.assertEquals(op.getTotal(), 3, 0);
    }

    @Test
    public void addDouble() {
        Operations op = new Operations(1.25);
        op.add(0.5);
        Assert.assertEquals(op.getTotal(), 1.75, 0);
    }

    @Test
    public void subtractInt() {
        Operations op = new Operations(4);
        op.subtract(3);
        Assert.assertEquals(op.getTotal(), 1, 0);
    }

    @Test
    public void subtractDouble() {
        Operations op = new Operations(2.25);
        op.subtract(1.25);
        Assert.assertEquals(op.getTotal(), 1, 0);
    }

    @Test
    public void multiplyInt() {
        Operations op = new Operations(3);
        op.multiply(4);
        Assert.assertEquals(op.getTotal(), 12, 0);
    }

    @Test
    public void multipleDouble() {
        Operations op = new Operations(1.5);
        op.multiply(2.25);
        Assert.assertEquals(op.getTotal(), 3.375, 0);
    }

    @Test
    public void divideInt() {
        Operations op = new Operations(8);
        op.divide(4);
        Assert.assertEquals(op.getTotal(), 2, 0);
    }

    @Test
    public void divideDouble() {
        Operations op = new Operations(4.5);
        op.divide(1.5);
        Assert.assertEquals(op.getTotal(), 3, 0);
    }

    @Test
    public void chainInt() {
        Operations op = new Operations(1);
        op.add(6);
        op.subtract(1);
        op.multiply(2);
        op.divide(3);
        Assert.assertEquals(op.getTotal(), 4, 0);
    }

    @Test
    public void chainDouble() {
        Operations op = new Operations(0.5);
        op.add(1.5);
        op.subtract(0.5);
        op.multiply(2);
        op.divide(1.5);
        Assert.assertEquals(op.getTotal(), 2, 0);
    }

    @Test
    public void chainMixed() {
        Operations op = new Operations(2);
        op.add(2.5);
        op.subtract(1);
        op.multiply(1.5);
        op.divide(3);
        Assert.assertEquals(op.getTotal(), 1.75, 0);
    }

}