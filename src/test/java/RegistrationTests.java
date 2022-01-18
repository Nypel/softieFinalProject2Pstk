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
    void shouldSubmitProperly() throws InterruptedException {

        mainPage.clickSignInButton();
        Thread.sleep(2000);
        Assertions.assertTrue(isOnAuthenticationPage());
        Thread.sleep(2000);
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
