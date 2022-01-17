import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import navigation.LoginPage;
import navigation.MainPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "test@softie.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1qaz!QAZ";
    private static final String NOT_EXISTING_USERNAME_LOGIN = "";
    private static final String NOT_EXISTING_USERNAME_PASSWORD = "";

    @Test
    void shouldLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage());

    }

    @Test
    void shouldNotLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }

    private boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");

    }

    @Test
    void shouldNotLoginWithoutLoginValue() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }

    @Test
    void shouldNotLoginWithoutLoginPassword() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }
}
