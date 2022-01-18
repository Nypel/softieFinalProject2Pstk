package navigation;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);

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

    public void register() throws InterruptedException {
        fillRegistrationForm();
        clickRegisterButton();

    }

    private void fillRegistrationForm() throws InterruptedException {

        firstNameInput.sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        lastNameInput.sendKeys(faker.name().lastName());
        Thread.sleep(2000);
        passwordInput.sendKeys("123555");
        Thread.sleep(2000);
        addressFirstNameInput.sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        addressLastNameInput.sendKeys(faker.name().lastName());
        Thread.sleep(2000);
        addressInput.sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);
        cityInput.sendKeys(faker.address().city());
        Thread.sleep(2000);
        stateSelection();
        Thread.sleep(2000);
        zipCodeInput.sendKeys(faker.address().zipCode());
        Thread.sleep(2000);
        countryInput.click();
        Thread.sleep(2000);
        usInput.click();
        Thread.sleep(2000);
        mobileInput.sendKeys(String.valueOf(faker.number().randomNumber()));
        Thread.sleep(2000);
        aliasAddressInput.sendKeys("opo256");

    }

    private void stateSelection() {
        Select state = new Select(driver.findElement(By.id("id_state")));
        Random random = new Random();
        state.selectByIndex(random.nextInt(50));

    }

    private void clickRegisterButton() {
        registerButton.click();

    }

    public boolean isProperlyCreateAccount() {
        return isOnAccount.getText().contains("My account");

    }
}


