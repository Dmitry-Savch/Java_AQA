package task_20;

import io.appium.java_client.android.AndroidDriver;
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
    public void testCalculator(String expectedResult) throws Exception {
        AndroidDriver driver = initializeDriver();

        Task20PO calculatorPage = new Task20PO(driver);

        calculatorPage.performCalculation();

        String actualResult = calculatorPage.getResult();

        Assert.assertEquals(actualResult, expectedResult, "The result is incorrect!");

        driver.quit();
    }

    private AndroidDriver initializeDriver() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }
}