import Base.Setup;
import Screens.Calculator;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class testApp {
    AndroidDriver driver;
    Calculator cal;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = Setup.setUp();
        cal = new Calculator(driver);
        cal.clearResult();
    }

    @Test
    public void Addition(){
        String result = cal.sum();
        Assert.assertEquals(result, "6");
    }

    @Test
    public void Subtraction(){
        String result = cal.sub();
        Assert.assertEquals(result, "3");
    }

    @Test
    public void Multiplication(){
        String result = cal.multi();
        Assert.assertEquals(result, "42");
    }

    @Test
    public void Division(){
        String result = cal.divide();
        Assert.assertEquals(result, "3");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
