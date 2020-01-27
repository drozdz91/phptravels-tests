import assertions.AccountAssertions;
import assertions.LoginAssertions;
import general.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

import static general.PropertyManager.getInstance;

public class LoginTest extends TestBase {

    private static final String USER_NAME = "Demo User";

    @Test
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
