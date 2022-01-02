import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

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
