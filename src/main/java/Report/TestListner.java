package Report;

import Base.Setup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;

public class TestListner extends Setup implements ITestListener {

    private static String getMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getMethodName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("TEST START: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("TEST PASS: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("TEST FAIL: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
        Object testClass = iTestResult.getInstance();
        AndroidDriver driver = Setup.driver;
        saveScreenshot(driver, iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("TEST SKIP: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST FINISH: "+context.getName());
    }

    @Attachment(value = "Actual Screenshot", type = "image/png")
    public void saveScreenshot(AndroidDriver driver, ITestResult iTestResult) {
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
