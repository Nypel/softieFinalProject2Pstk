import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;

public class SearchFieldTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);

    public static final String LOWERCASE = "dresses";
    public static final String UPPERCASE = "DRESSES";
    public static final String UPPER_ADN_LOWERCASE = "Casual DressES";
    public static final String SPECIAL_CHARACTERS = "@%&(@%++--";
    public static final String NOT_EXISTING_SEARCH = "";


    @Test
    void doesSearchFieldAcceptWordsInLowerCase() {
        mainPage.search(LOWERCASE);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query=dresses"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInUpperCase() {
        mainPage.search(UPPERCASE);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query=DRESSES"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInUpperAdnLowerCase() {
        mainPage.search(UPPER_ADN_LOWERCASE);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query=Casual+Dress"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInSpecialCharacters() {
        mainPage.search(SPECIAL_CHARACTERS);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query=%40%25%26%28%40%25%2B%2B--"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptNotExistingSearch() {
        mainPage.search(NOT_EXISTING_SEARCH);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query="));
        mainPage.clickLogoButton();

    }
}

