package pages;

import general.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

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

    @Step("Input email address: {emailAddress}")
    public LoginPage inputEmailAddress(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        return this;
    }

    @Step("Input password: {password}")
    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on Login button")
    public AccountPage clickLoginButton() {
        wait.until(elementToBeClickable(loginButton));
        loginButton.click();
        return new AccountPage(driver);
    }
}
