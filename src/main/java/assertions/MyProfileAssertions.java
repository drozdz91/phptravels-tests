package assertions;

import general.AbstractAssertions;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import pages.MyProfilePage;

import static org.testng.Assert.assertEquals;

@Log4j
public class MyProfileAssertions extends AbstractAssertions<MyProfilePage> {

    @Step("Check if zip code is equal to: {zipCode}")
    public MyProfileAssertions assertThatZipCodeIsEqualTo(String zipCode) {
        assertEquals(page.getZipCodeInput().getAttribute("value"), zipCode, "Zip code is not equal to: " + zipCode);
        log.info("Successfully verified that zip code is equal to: " + zipCode);
        return this;
    }
}
