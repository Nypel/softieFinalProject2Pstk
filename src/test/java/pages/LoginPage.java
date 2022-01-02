package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "email")
    private WebElement usernameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/a[1]")
    private WebElement clickHome;
    @FindBy(id = "header_logo")
    private WebElement clickLogo;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement clickOut;
    @FindBy(id = "email_create")
    private WebElement userMailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    Faker faker = new Faker();


    public void login(String username, String password) {
        typeCredentials(username, password);
        clickLoginButton();

    }

    private void clickLoginButton() {
        loginButton.click();

    }

    private void typeCredentials(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

    }

    public void clickHomeIcon() {
        clickHome.click();

    }

    public void clickLogoButton() {
        clickLogo.click();

    }

    public void clickSignOut() {
        clickOut.click();

    }

    public void userMail() {
        typeSubmitCredentials();
        clickSubmitButton();

    }

    private void typeSubmitCredentials() {
        userMailInput.sendKeys(faker.name().firstName() + faker.name().lastName() + "@kk.si");

    }

    public void clickSubmitButton() {
        submitButton.click();

    }
}
