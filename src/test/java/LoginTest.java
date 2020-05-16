import assertions.AccountAssertions;
import assertions.LoginAssertions;
import general.TestBase;
import general.listeners.TestListener;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import static general.PropertyManager.getInstance;

@Listeners(TestListener.class)
public class LoginTest extends TestBase {

    private static final String USER_NAME = "Demo User";

    @Test
    @Description("The goal of this test is to log in to the site with valid username and password")
    public void verifyIfUserCanLogin() {
        new HomePage(driver)
                .openHomePage()
                .openMyAccountDropdown()
                .clickLoginLink()
                .check(LoginAssertions.class)
                    .assertThatLoginHeaderContainsLoginText()
                .endAssertion()
                .inputEmailAddress(getInstance().getDemoUserEmail())
                .inputPassword(getInstance().getDemoUserPassword())
                .clickLoginButton()
                .check(AccountAssertions.class)
                    .assertThatWelcomeHeaderContainsUsername(USER_NAME)
                .endAssertion();
    }
}
