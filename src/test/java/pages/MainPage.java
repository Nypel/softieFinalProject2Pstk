package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;
    @FindBy(id = "search_query_top")
    private WebElement charactersInput;
    @FindBy(name = "submit_search")
    private WebElement clickSearch;
    @FindBy(id = "header_logo")
    private WebElement clickLogo;
    @FindBy(id = "header_logo")
    private WebElement logo;
    @FindBy(id = "searchbox")
    private WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement womenIcon;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement dressesIcon;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement tShirtsIcon;


    public void clickSignInButton() {
        System.out.println((driver.getCurrentUrl()));
        signInButton.click();

    }

    public void clickOnSearchField() {
        System.out.println(driver.getCurrentUrl());
        charactersInput.click();

    }

    public void search(String characters) {
        typeCredentials(characters);
        clickSearchButton();

    }

    private void clickSearchButton() {
        clickSearch.click();

    }

    private void typeCredentials(String characters) {
        charactersInput.sendKeys(characters);

    }

    public void clickLogoButton() {
        clickLogo.click();

    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();

    }

    public boolean isSearchFieldDisplayed() {
        return searchBox.isDisplayed();

    }

    public void clickWomenIcon() {
        womenIcon.click();

    }

    public void clickDressesIcon() {
        dressesIcon.click();

    }

    public void clickTshirtsIcon() {
        tShirtsIcon.click();

    }
}

