package task_20;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Task20_Test {
    @BeforeMethod
    public void setUp() throws Exception {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}