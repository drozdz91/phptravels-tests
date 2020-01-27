package pages;

import general.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = "//h3[text()='Login']")
    private WebElement loginHeader;

    @FindBy(css = "[name='username']")
    private WebElement emailInput;

    @FindBy(css = "[name='password']")
    private WebElement passwordInput;

    @FindBy(css = ".btn-lg.loginbtn")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputEmailAddress(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return new AccountPage(driver);
    }
}
