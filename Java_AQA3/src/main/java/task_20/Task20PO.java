package task_20;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class Task20PO {

    private AndroidDriver driver;

    public Task20PO(AndroidDriver driver) {
        this.driver = driver;
    }

    public void performCalculation() {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/dec_point")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/dec_point")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
    }

    public String getResult() {
        WebElement resultElement = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
        return resultElement.getText();
    }
}