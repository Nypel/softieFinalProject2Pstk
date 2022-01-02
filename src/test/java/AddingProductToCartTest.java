
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BlousePage;
import pages.WomenPage;
import pages.MainPage;


public class AddingProductToCartTest extends BaseTest {


    MainPage mainPage = new MainPage(driver);
    WomenPage womenPage = new WomenPage(driver);
    BlousePage blousePage = new BlousePage(driver);


    @Test
    void doesItCorrectlyAddProductToCart() {
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
        Assertions.assertTrue(areTwoProductsInTheCart());

    }

    private boolean shouldBeInWomenSection() {
        return driver.getCurrentUrl().contains("3&controller=category");

    }

    private boolean areTwoProductsInTheCart() {
        return driver.findElement(By.id("summary_products_quantity")).getText().contains("2 Products");

    }
}



