package assertions;

import general.AbstractAssertions;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import pages.AccountPage;

import static org.testng.Assert.assertTrue;

@Log4j
public class AccountAssertions extends AbstractAssertions<AccountPage> {

    @Step("Check if welcome header contains username: {username}")
    public AccountAssertions assertThatWelcomeHeaderContainsUsername(String username) {
        assertTrue(page.getWelcomeHeader().getText().contains(username), "Welcome header does not contain logged username");
        log.info("Successfully verified that welcome header contains " + username + " username");
        return this;
    }
}
