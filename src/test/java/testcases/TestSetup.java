package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSetup {
    protected static AppiumDriver driver;
    DesiredCapabilities caps = new DesiredCapabilities();

    @BeforeTest
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        try {
            caps.setCapability("deviceName", "iPhoneX");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("platformVersion", "14.4");
            caps.setCapability("version", "14.4");
            caps.setCapability("udid", System.getenv("UDID"));
            caps.setCapability("app", System.getProperty("user.dir") + "/app/MailChimp Enterprise.ipa");
            caps.setCapability("fullReset", "true");
            caps.setCapability("noReset", "false");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }


    protected void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
