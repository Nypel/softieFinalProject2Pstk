import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class NavigationMenuTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);


    @Test
    void doesWomenIconRedirectToTheWomenMenu() {
        mainPage.clickWomenIcon();
        Assertions.assertTrue(shouldBeInWomenSection());

    }

    private boolean shouldBeInWomenSection() {
        return driver.getCurrentUrl().contains("3&controller=category");

    }

    @Test
    void doesDressesIconRedirectToTheDressesMenu() {
        mainPage.clickDressesIcon();
        Assertions.assertTrue(shouldBeInDressesSection());

    }

    private boolean shouldBeInDressesSection() {
        return driver.getCurrentUrl().contains("8&controller=category");

    }

    @Test
    void doesTshirtsIconRedirectToTheTshirtsMenu() {
        mainPage.clickTshirtsIcon();
        Assertions.assertTrue(shouldBeInTshirtsSection());

    }

    private boolean shouldBeInTshirtsSection() {
        return driver.getCurrentUrl().contains("5&controller=category");

    }
}