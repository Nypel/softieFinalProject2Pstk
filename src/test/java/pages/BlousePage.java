package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BlousePage {

    WebDriver driver;


    public BlousePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")
    private WebElement plusButton;
    @FindBy(id = "group_1")
    private WebElement select;
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement selectMedium;
    @FindBy(id = "color_8")
    private WebElement colour;
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    private WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement cart;


    public void clickPlusButton() {
        plusButton.click();

    }

    public void selectSize() {
        select.click();

    }

    public void selectMediumSize() {
        selectMedium.click();

    }

    public void selectColour() {
        colour.click();

    }

    public void addToCartClick() {
        addToCart.click();

    }

    public void cartVerification() {
        cart.click();

    }

}

