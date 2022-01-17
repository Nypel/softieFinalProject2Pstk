package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    private WebElement blouseImage;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")
    private WebElement clickMore;
    @FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")
    private WebElement addSecondBlousePlusButton;
    @FindBy(id = "group_1")
    private WebElement sizeSelect;
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement selectMediumSize;
    @FindBy(id = "color_8")
    private WebElement colourSelect;
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    private WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement cart;

    Actions actions = new Actions(driver);

    public void blouseProductSelection() {
        actions.moveToElement(blouseImage).perform();
        actions.moveToElement(clickMore).click().perform();
        clickPlusButton();
        clickSizeField();
        selectMediumSize();
        selectColour();
        addToCartClick();
        cartVerification();

    }

    public void clickPlusButton() {
        addSecondBlousePlusButton.click();

    }

    public void clickSizeField() {
        sizeSelect.click();

    }

    public void selectMediumSize() {

        selectMediumSize.click();
    }

    public void selectColour() {

        colourSelect.click();
    }

    public void addToCartClick() {
        addToCart.click();

    }

    public void cartVerification() {
        cart.click();

    }

}

