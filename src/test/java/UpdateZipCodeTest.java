import assertions.MyProfileAssertions;
import general.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import scenarios.LoginScenario;

import static general.PropertyManager.getInstance;
import static org.apache.commons.lang3.RandomStringUtils.random;

public class UpdateZipCodeTest extends TestBase {

    private static final String RANDOM_ZIP_CODE = random(5, false, true);

    @Test
    public void verifyIfUserCanUpdateZipCode() {
        new HomePage(driver)
                .openHomePage()
                .openMyAccountDropdown()
                .clickLoginLink()
                .run(new LoginScenario(getInstance().getDemoUserEmail(), getInstance().getDemoUserPassword()))
                .clickMyProfileTab()
                .inputZipCode(RANDOM_ZIP_CODE)
                .clickSubmitButton()
                .clickMyProfileTab()
                .check(MyProfileAssertions.class)
                    .assertThatZipCodeIsEqualTo(RANDOM_ZIP_CODE)
                .endAssertion();
    }
}
