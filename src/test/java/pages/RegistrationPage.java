package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "firstname")
    private WebElement addressFirstNameInput;
    @FindBy(id = "lastname")
    private WebElement addressLastNameInput;
    @FindBy(id = "address1")
    private WebElement addressInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "uniform-id_state")
    private WebElement stateInput;
    @FindBy(id = "postcode")
    private WebElement zipCodeInput;
    @FindBy(id = "id_country")
    private WebElement countryInput;
    @FindBy(xpath = "//*[@id=\"id_country\"]/option[2]")
    private WebElement usInput;
    @FindBy(id = "phone_mobile")
    private WebElement mobileInput;
    @FindBy(id = "alias")
    private WebElement aliasAddressInput;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement isOnAccount;


    Faker faker = new Faker();


    public void register() {
        typeCredentials();
        clickRegisterButton();

    }

    private void typeCredentials() {

        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        passwordInput.sendKeys("123555");
        addressFirstNameInput.sendKeys(faker.name().firstName());
        addressLastNameInput.sendKeys(faker.name().lastName());
        addressInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateSelection();
        zipCodeInput.sendKeys(faker.address().zipCode());
        countryInput.click();
        usInput.click();
        mobileInput.sendKeys(String.valueOf(faker.number().randomNumber()));
        aliasAddressInput.sendKeys("opo256");

    }

    private void stateSelection() {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("5");

    }

    private void clickRegisterButton() {
        registerButton.click();

    }

    public boolean isProperlyCreateAccount() {
        return isOnAccount.getText().contains("My account");

    }
}


