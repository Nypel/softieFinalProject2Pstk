import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;

public class LogoAndSearchFieldTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);


    @Test
    void doesHomePageContainLogoAndSearchField() {
        Assertions.assertTrue(mainPage.isLogoDisplayed());
        Assertions.assertTrue(mainPage.isSearchFieldDisplayed());

    }
}
