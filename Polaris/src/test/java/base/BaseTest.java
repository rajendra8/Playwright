package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseTest {


    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected DesiredCapabilities caps;

    @BeforeClass
    public void setup() {
        try {
            caps = new DesiredCapabilities();
            caps.setCapability("appium:platformName", "Android");
            caps.setCapability("appium:deviceName", "emulator-5554");
            caps.setCapability("appium:udid", "emulator-5554");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
            caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
            caps.setCapability("appium:noReset", true);
            //caps.setCapability("appium:newCommandTimeout", 120);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.print("App Setup Ready............");
    }

    @AfterClass
    public void afterclass() {
        if (driver != null) {
            driver.quit();
        }
    }

}
