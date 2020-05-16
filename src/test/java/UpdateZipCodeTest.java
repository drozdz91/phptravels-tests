import assertions.MyProfileAssertions;
import general.TestBase;
import general.listeners.TestListener;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import scenarios.LoginScenario;

import static general.PropertyManager.getInstance;
import static org.apache.commons.lang3.RandomStringUtils.random;

@Listeners(TestListener.class)
public class UpdateZipCodeTest extends TestBase {

    private static final String RANDOM_ZIP_CODE = random(5, false, true);

    @Test
    @Description("The goal of this test is to check if user is able to update zip code")
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
