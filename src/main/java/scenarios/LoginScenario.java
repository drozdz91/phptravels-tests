package scenarios;

import general.Scenario;
import lombok.AllArgsConstructor;
import pages.AccountPage;
import pages.LoginPage;

@AllArgsConstructor
public class LoginScenario implements Scenario<LoginPage, AccountPage> {

    private String emailAddress;
    private String password;

    @Override
    public AccountPage run(LoginPage entry) {
        return entry
                .inputEmailAddress(emailAddress)
                .inputPassword(password)
                .clickLoginButton();
    }
}
