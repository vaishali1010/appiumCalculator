package Base;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utility {
    WebDriverWait wait;

    AndroidDriver driver;
    public Utility(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitForElementPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement getElement(By locator) {
        waitForElementPresent(locator);
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("some exception got occurred while creating the webelement : " + locator);
            System.out.println(e.getMessage());
        }
        return element;
    }
    public void doClick(By locator) {
        try {
            getElement(locator).click();
        } catch (Exception e) {
            System.out.println("some exception got occurred while clicking on the webelement : " + locator);
            System.out.println(e.getMessage());

        }
    }

    public String getScreenshot(String testName) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            File destination = new File(path);
            try {
                FileUtils.copyFile(src, destination);
            } catch (IOException e) {
                System.out.println("Capture Failed " + e.getMessage());
            }
            return path;
        }
    }
