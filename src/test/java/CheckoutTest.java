import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)
public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test(description = "This test is searching for the keyboard mouse functionality")
    public void searchTest() {
        //checkoutPage.setSearchBar();
        // checkoutPage.ckickSearchButton();
        // extentTest.log(Status.INFO, "The search engine is looking upfor the keyword'mouse");
        ExtentTestNGITestListener.getTest().pass("The user");

    }

    @Test(description = "This test is verifying the functionality of checkout process ")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickProductGraniteChips();
        Thread.sleep(1000);
        checkoutPage.setClickAddtoCart();
        checkoutPage.showCartIcon();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your cart")));
        checkoutPage.clickProceedToCheckout();
        //extentTest.pass("The checkout test worked!Test passed successfuly");
        ExtentTestNGITestListener.getTest().pass("The user");
}

    @Test(description = "Changing quantity test. Asserting that the price is updated correctly.")
    public void quantityTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() *2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product after updating should be: " + expectedTotal);
        checkoutPage.clickPlusQuantity();
        assertEquals(checkoutPage.productPrice(),expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is matching the expectedprice ");

    }
    @Test(description = "Calculating the price of a product with taxes.")
    public void totalPriceCalculationTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.productPrice());
         ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.taxPrice());
         double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is" + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(),expectedTotal);
}
}