package building_my_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class MainTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void testSearchProduct() {
        homePage.searchForProduct("bag");
        Assert.assertTrue(driver.getCurrentUrl().contains("q=bag"), "Search failed");
    }

    @Test(priority = 2)
    public void testAddToCart() throws InterruptedException {
        productPage.hoverAndAddToCart();
        Thread.sleep(2000); // يفضل تعويضه بـ Explicit Wait
        productPage.proceedToCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Didn't reach checkout page");
    }

    @Test(priority = 3)
    public void testCompletePurchase() throws InterruptedException {
        checkoutPage.fillShippingInfo();
        Thread.sleep(4000); // يفضل استخدام wait
        Assert.assertTrue(driver.getCurrentUrl().contains("payment"), "Didn't reach payment step");
        checkoutPage.placeOrder();
        Thread.sleep(5000); // انتظر تأكيد الطلب
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
