import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import navigation.MainPage;

public class LogoAndSearchFieldTests extends BaseTest {

    MainPage mainPage = new MainPage(driver);

    @Test
    void doesHomePageContainLogoAndSearchField() {
        Assertions.assertTrue(mainPage.isLogoDisplayed());
        Assertions.assertTrue(mainPage.isSearchFieldDisplayed());

    }
}
