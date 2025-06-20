package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//img[@alt='Voyage Yoga Bag']")
    WebElement productImage;

    @FindBy(xpath = "//img[@alt='Voyage Yoga Bag']/ancestor::li//button[@title='Add to Cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement viewCartLink;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement checkoutBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void hoverAndAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(productImage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productImage);
        new Actions(driver).moveToElement(productImage).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }
}

