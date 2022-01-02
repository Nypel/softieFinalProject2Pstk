package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a")
    private WebElement blouseProduct;


    public void clickBlouseProduct() {
        blouseProduct.click();

    }
}
