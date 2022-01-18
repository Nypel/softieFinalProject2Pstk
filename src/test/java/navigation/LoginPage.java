package navigation;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);

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
        typeUserEmailAddress();
        clickSubmitButton();

    }

    private void typeUserEmailAddress() {
        userMailInput.sendKeys(faker.name().firstName() + faker.name().lastName() + "@kk.si");

    }

    public void clickSubmitButton() {
        submitButton.click();

    }
}
