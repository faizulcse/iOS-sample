package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.TestSetup;

public class BasePage extends TestSetup {
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(id = "welcome__skip_button")
    private MobileElement skipBtn;
    @iOSXCUITFindBy(id = "Login")
    private MobileElement loginLink;

    public void clickSkipButton() {
        skipBtn.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
