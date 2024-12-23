package task_20;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

public class Task20_DataProvider {

    @DataProvider(name = "calculationData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"33.306"},
        };
    }

    @Test(dataProvider = "calculationData")
    @Description("Test calculator functionality")
    @Feature("Calculator")
    @Story("Perform calculation and verify result")
    public void testCalculator(String expectedResult) throws Exception {
        AndroidDriver driver = initializeDriver();

        Task20PO calculatorPage = new Task20PO(driver);

        performCalculation(calculatorPage);

        String actualResult = calculatorPage.getResult();

        attachText("Expected Result", expectedResult);
        attachText("Actual Result", actualResult);

        Assert.assertEquals(actualResult, expectedResult, "The result is incorrect!");

        driver.quit();
    }

    @Step("Initialize Android driver")
    private AndroidDriver initializeDriver() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Step("Perform calculation")
    private void performCalculation(Task20PO calculatorPage) {
        calculatorPage.performCalculation();
    }

    @Attachment(value = "{name}", type = "text/plain")
    public String attachText(String name, String content) {
        return content;
    }
}
