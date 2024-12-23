package task_20;

import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Task20_Listener.class)
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
        DriverManager.takeScreenshot(); // Add screenshot to Allure
        attachText("Multiplication Result", result);
        System.out.println("Result: " + result);
        Assert.assertEquals(result, "33.306", "The multiplication result is incorrect");
    }

    @Test
    public void testAddition() {
        calculator.performAddition(); // Add this method to your Task20PO
        String result = calculator.getResult();
        DriverManager.takeScreenshot(); // Add screenshot to Allure
        attachText("Addition Result", result);
        System.out.println("Result: " + result);
        Assert.assertEquals(result, "Expected_Result", "The addition result is incorrect");
    }

    @Test
    public void testClear() {
        calculator.clearCalculator(); // Add this method to your Task20PO
        String result = calculator.getResult();
        DriverManager.takeScreenshot(); // Add screenshot to Allure
        attachText("Clear Result", result);
        System.out.println("Result after clear: " + result);
        Assert.assertTrue(result.isEmpty(), "Calculator result should be empty after clear");
    }

    // Additional methods for Allure
    @Attachment(value = "{name}", type = "text/plain")
    public String attachText(String name, String content) {
        return content;
    }
}
