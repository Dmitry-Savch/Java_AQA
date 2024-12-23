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
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/dec_point"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3"))).click();
        new Element(driver.findElement(AppiumBy.accessibilityId("multiply"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_4"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/dec_point"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"))).click();
        new Element(driver.findElement(AppiumBy.accessibilityId("equals"))).click();
    }

    public String getResult() {
        WebElement resultElement = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
        return new Element(resultElement).getText();
    }

    public void performAddition() {
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5"))).click();
        new Element(driver.findElement(AppiumBy.accessibilityId("plus"))).click();
        new Element(driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3"))).click();
        new Element(driver.findElement(AppiumBy.accessibilityId("equals"))).click();
    }

    public void clearCalculator() {
        new Element(driver.findElement(AppiumBy.accessibilityId("clear"))).click();
    }
}