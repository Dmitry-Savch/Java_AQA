package task_20;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static task_20.DriverManager.getDriver;

public class Task20_Listener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(Task20_Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test started: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Test passed: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test failed: " + result.getName());
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.warn("Test skipped: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.error("Test failed but within success percentage: " + iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("Test execution started: " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Test execution finished: " + iTestContext.getName());
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot() {
        try {
            if (getDriver() != null) {
                return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            }
        } catch (Exception e) {
            LOGGER.error("Error capturing screenshot: " + e.getMessage());
        }
        return new byte[0];
    }
}