package assertions;

import general.AbstractAssertions;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

@Log4j
public class LoginAssertions extends AbstractAssertions<LoginPage> {

    @Step("Check if login header contains 'login' text")
    public LoginAssertions assertThatLoginHeaderContainsLoginText() {
        assertTrue(page.getLoginHeader().getText().contains("Login"), "Login header does not contain Login text");
        log.info("Successfully verified that login header contains Login text");
        return this;
    }
}
