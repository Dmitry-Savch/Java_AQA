package task_20;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task20_Test {

    private Task20PO calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        DriverManager.initDriver();
        calculator = new Task20PO(DriverManager.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test
    public void testMultiplication() {
        calculator.performCalculation();
        String result = calculator.getResult();
        System.out.println("Result: " + result);
        Assert.assertEquals(result, "33.306", "The multiplication result is incorrect");
    }

    @Test
    public void testAddition() {
        calculator.performAddition(); // Add this method to your Task20PO if required
        String result = calculator.getResult();
        System.out.println("Result: " + result);
        Assert.assertEquals(result, "Expected_Result", "The addition result is incorrect");
    }

    @Test
    public void testClear() {
        calculator.clearCalculator(); // Add this method to your Task20PO if required
        String result = calculator.getResult();
        System.out.println("Result after clear: " + result);
        Assert.assertTrue(result.isEmpty(), "Calculator result should be empty after clear");
    }
}
