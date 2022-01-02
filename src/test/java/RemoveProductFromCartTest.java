import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BlousePage;
import pages.CartPage;
import pages.MainPage;
import pages.WomenPage;

public class RemoveProductFromCartTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    WomenPage womenPage = new WomenPage(driver);
    BlousePage blousePage = new BlousePage(driver);
    CartPage cartPage = new CartPage(driver);


    @Test
    void doesItCorrectlyAddProductToCartAndRemoveIi() {
        mainPage.clickWomenIcon();
        Assertions.assertTrue(shouldBeInWomenSection());
        womenPage.clickBlouseProduct();
        Assertions.assertFalse(shouldBeInWomenSection());
        blousePage.clickPlusButton();
        blousePage.selectColour();
        blousePage.selectSize();
        blousePage.selectMediumSize();
        blousePage.addToCartClick();
        blousePage.cartVerification();
        Assertions.assertTrue(cartPage.shouldBeNumberTwo());
        cartPage.quantityDelete();
        Assertions.assertTrue(cartPage.isCartEmpty());

    }

    private boolean shouldBeInWomenSection() {
        return driver.getCurrentUrl().contains("3&controller=category");

    }
}
