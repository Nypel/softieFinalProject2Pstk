import navigation.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchFieldTests extends BaseTest {

    MainPage mainPage = new MainPage(driver);

    public static final String LOWERCASE = "dresses";
    public static final String UPPERCASE = "DRESSES";
    public static final String UPPER_ADN_LOWERCASE = "CasUal";
    public static final String TWO_WORLDS = "casual dresses";
    public static final String SPECIAL_CHARACTERS = "@%&(@%++--";
    public static final String NOT_EXISTING_SEARCH = "";

    @Test
    void doesSearchFieldAcceptWordsInLowerCase() {
        mainPage.search(LOWERCASE);
        String urlQuery = "search_query=" + LOWERCASE;
        Assertions.assertTrue(driver.getCurrentUrl().contains(urlQuery));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInUpperCase() {
        mainPage.search(UPPERCASE);
        String urlQuery = "search_query=" + UPPERCASE;
        Assertions.assertTrue(driver.getCurrentUrl().contains(urlQuery));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInUpperAdnLowerCase() {
        mainPage.search(UPPER_ADN_LOWERCASE);
        String urlQuery = "search_query=" + UPPER_ADN_LOWERCASE;
        Assertions.assertTrue(driver.getCurrentUrl().contains(urlQuery));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptTwoWords() {
        mainPage.search(TWO_WORLDS);
        Assertions.assertTrue(driver.getCurrentUrl().contains("search_query=casual+dresses"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptWordsInSpecialCharacters() {
        mainPage.search(SPECIAL_CHARACTERS);
        Assertions.assertTrue(driver.getCurrentUrl().contains("%40%25%26%28%40%25%2B%2B--"));
        mainPage.clickLogoButton();

    }

    @Test
    void doesSearchFieldAcceptNotExistingSearch() {
        mainPage.search(NOT_EXISTING_SEARCH);
        String urlQuery = "search_query=" + NOT_EXISTING_SEARCH;
        Assertions.assertTrue(driver.getCurrentUrl().contains(urlQuery));
        mainPage.clickLogoButton();

    }
}

