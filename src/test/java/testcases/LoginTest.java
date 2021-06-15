package testcases;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestSetup {
    public LoginTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickSkipButton();
        loginPage.clickLoginLink();
        loginPage.enterUsernameAndPassword(System.getenv("MC_USER"), System.getenv("MC_PASS"));
        loginPage.clickLoginButton();

        // Verify the expected text is present on the page
        Assert.assertTrue(loginPage.isVerificationTextDisplayed());
        waitFor(5);     // wait for 5 seconds before closing the app
    }

}
