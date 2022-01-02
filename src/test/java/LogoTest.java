import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class LogoTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @Test
    void doesItCorrectlyRedirectFromTheLoginPageToTheHomePageByLogoIcon() {
        mainPage.clickSignInButton();
        Assertions.assertTrue(isOnLoginPage());
        loginPage.clickLogoButton();
        Assertions.assertTrue(isOnHomePage());

    }

    private boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("back=my-account");

    }

    private boolean isOnHomePage() {
        return driver.getCurrentUrl().contains("index.php");

    }
}
