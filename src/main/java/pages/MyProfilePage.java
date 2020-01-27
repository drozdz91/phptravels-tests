package pages;

import general.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyProfilePage extends BasePage {

    @FindBy(css = "[name='zip']")
    private WebElement zipCodeInput;

    @FindBy(css = ".btn.btn-block.updateprofile.btn-primary")
    private WebElement submitButton;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public MyProfilePage inputZipCode(String zipCode) {
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public AccountPage clickSubmitButton() {
        submitButton.click();
        return new AccountPage(driver);
    }
}
