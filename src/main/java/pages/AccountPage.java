package pages;

import general.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Getter
public class AccountPage extends BasePage {

    @FindBy(css = ".text-align-left")
    private WebElement welcomeHeader;

    @FindBy(css = "div.imagelogo")
    private WebElement headerLogo;

    @FindBy(css = "a[href='#profile']")
    private WebElement myProfileLink;

    public AccountPage(WebDriver driver) {
        super(driver);
        wait.until(visibilityOf(headerLogo));
    }

    public MyProfilePage clickMyProfileTab() {
        Actions builder = new Actions(driver);
        builder.moveToElement(myProfileLink).perform();
        myProfileLink.click();
        return new MyProfilePage(driver);
    }

}