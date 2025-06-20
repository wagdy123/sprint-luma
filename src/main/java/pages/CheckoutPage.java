package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "customer-email")
    WebElement emailField;

    @FindBy(name = "firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(name = "street[0]")
    WebElement streetField;

    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(name = "region_id")
    WebElement stateDropdown;

    @FindBy(name = "postcode")
    WebElement postcodeField;

    @FindBy(name = "telephone")
    WebElement phoneField;

    @FindBy(css = "input[type='radio'][value='tablerate_bestway']")
    WebElement radioShippingMethod;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//*[text()='Place Order']")
    WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillShippingInfo() {
        emailField.sendKeys("wagdy2085@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys("Ahmed");
        lastNameField.sendKeys("Wagdy");
        streetField.sendKeys("Nasr City");
        cityField.sendKeys("Cairo");
        new Select(stateDropdown).selectByVisibleText("California");
        postcodeField.sendKeys("12345");
        phoneField.sendKeys("0123456789");

        if (!radioShippingMethod.isSelected()) {
            radioShippingMethod.click();
        }

        nextButton.click();
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }
}