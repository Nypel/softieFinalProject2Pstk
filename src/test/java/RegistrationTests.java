import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import navigation.LoginPage;
import navigation.MainPage;
import navigation.RegistrationPage;

public class RegistrationTests extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Test
    void shouldSubmitProperly() {

        mainPage.clickSignInButton();
        Assertions.assertTrue(isOnAuthenticationPage());
        loginPage.userMail();
        Assertions.assertTrue(isOnRegistrationPage());
        registrationPage.register();
        Assertions.assertTrue(registrationPage.isProperlyCreateAccount());

    }

    private boolean isOnRegistrationPage() {
        return driver.getCurrentUrl().contains("my-account#account-creation");

    }

    private boolean isOnAuthenticationPage() {
        return driver.getCurrentUrl().contains("my-account");

    }
}






