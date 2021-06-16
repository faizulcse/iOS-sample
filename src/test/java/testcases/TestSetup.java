package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
    public static AppiumDriver driver;
    public static String screenshotName;
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
            caps.setCapability("app", System.getProperty("user.dir") + "/app/demo-app.ipa");
            caps.setCapability("fullReset", "true");
            caps.setCapability("noReset", "false");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void getTestResult(ITestResult result) {
        screenshotName = result.getName() + "(" + result.getTestClass().getRealClass().getSimpleName() + ")" + ".png";
        if (!result.isSuccess())
            takeScreenshot(screenshotName);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public void takeScreenshot(String screenshotName) {
        try {
            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new GregorianCalendar().getTime());
            String screenshotDir = System.getProperty("user.dir") + "/screenshot/" + currentDate + "/";
            if (driver != null) {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotFile, new File(screenshotDir + screenshotName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
