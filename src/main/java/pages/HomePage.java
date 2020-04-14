package pages;

import general.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static general.PropertyManager.getInstance;

public class HomePage extends BasePage {

    @FindBy(css = ".dropdown-login #dropdownCurrency")
    private WebElement myAccountDropdown;

    @FindBy(css = "a[href='https://www.phptravels.net/login']")
    private WebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open home page")
    public HomePage openHomePage() {
        driver.get(getInstance().getWebsiteUrl());
        return this;
    }

    @Step("Click on My Account dropdown")
    public HomePage openMyAccountDropdown() {
        myAccountDropdown.click();
        return this;
    }

    @Step("Click on Login link")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }
}
