
import navigation.MainPage;
import navigation.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddingProductToCartTests extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    ProductPage productPage = new ProductPage(driver);

    @Test
    void doesItCorrectlyAddProductToCart() {
        mainPage.typeBlouseProduct();
        Assertions.assertTrue(isTypeBlouseSection());
        productPage.blouseProductSelection();
        Assertions.assertTrue(areTwoProductsInTheCart());

    }

    private boolean areTwoProductsInTheCart() {
        return driver.findElement(By.id("summary_products_quantity")).getText().contains("2 Products");

    }

    private boolean isTypeBlouseSection() {
        return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span")).
                getText().contains("Blouses");

    }
}



