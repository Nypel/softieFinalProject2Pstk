import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class HomeIconTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @Test
    void doesItCorrectlyRedirectFromTheLoginPageToTheHomePageByHomeIcon() {
        mainPage.clickSignInButton();
        Assertions.assertTrue(isOnLoginPage());
        loginPage.clickHomeIcon();
        Assertions.assertTrue(isOnHomePage());

    }

    private boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("back=my-account");

    }

    private boolean isOnHomePage() {
        return driver.getCurrentUrl().contains("index.php");

    }
}


