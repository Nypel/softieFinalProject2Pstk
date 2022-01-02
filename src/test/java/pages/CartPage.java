package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "quantity_2_10_0_0")
    private WebElement twoBlouses;
    @FindBy(id = "2_10_0_0")
    private WebElement bin;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement isEmpty;

    public boolean shouldBeNumberTwo() {
        return twoBlouses.isDisplayed();

    }

    public void quantityDelete() {
        bin.click();

    }

    public boolean isCartEmpty() {
        return isEmpty.getText().contains("empty");

    }
}
