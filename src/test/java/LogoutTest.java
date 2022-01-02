import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class LogoutTest extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "test@softie.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1qaz!QAZ";


    @Test
    void shouldLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage());
        loginPage.clickSignOut();
        Assertions.assertFalse(isOnMyAccountPage());

    }

    private boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");

    }
}