package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {

    public static AndroidDriver driver ;

    public static AndroidDriver setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("appium:automationName","UiAutomator2");
        dc.setCapability("appium:app",System.getProperty("user.dir")+"/calculator-8-4-1-520193683.apk");
        dc.setCapability("appium:deviceName","Android Emulator");
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}