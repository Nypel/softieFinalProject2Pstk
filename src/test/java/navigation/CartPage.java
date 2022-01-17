package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(name = "quantity_2_10_0_0")
    private WebElement productQuantity;
    @FindBy(id = "2_10_0_0")
    private WebElement removeProductIcon;
    @FindBy(id = "cart_title")
    private WebElement isEmpty;

    public boolean shouldBeNumberTwo() {
        return productQuantity.isDisplayed();

    }

    public void deleteProduct() {
        removeProductIcon.click();

    }

    public boolean isCartEmpty() {
        return isEmpty.getText().contains("SUMMARY");

    }
}
