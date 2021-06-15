package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {

    @iOSXCUITFindBy(id = "login__username_textfield")
    private MobileElement username;
    @iOSXCUITFindBy(id = "login__password_textfield")
    private MobileElement password;
    @iOSXCUITFindBy(id = "login__login_button")
    private MobileElement loginBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Verification']")
    private MobileElement verificationText;

    public void enterUsernameAndPassword(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public boolean isVerificationTextDisplayed() {
        return verificationText.isDisplayed();
    }
}
