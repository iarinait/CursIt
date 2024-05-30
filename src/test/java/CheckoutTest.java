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


    @Test(description = "This test is verifying the functionality of checkout process ")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickProductGraniteChips();
        Thread.sleep(1000);
        checkoutPage.clickAddtoCartButton();
        checkoutPage.clickShowCartIcon();
        checkoutPage.clickProceedToCheckout();
        checkoutPage.enterFirstname();
        checkoutPage.enterLastName();
        checkoutPage.enterAddressField();
        checkoutPage.clickPaymentInformationButton();
        Thread.sleep(1000);
        checkoutPage.clickContinueCkeckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals("Thank you for your order!", checkoutPage.getPageTitle().getText());
        ExtentTestNGITestListener.getTest().pass("The user is able to go easy through the checkout process!");
    }


    @Test(description = "This test is verifying if FirstNameFiled is a mandatory field!")
    public void CheckFirstNameIsMandatory() {
        checkoutPage.addProductToCart();
        checkoutPage.enterLastName();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCkeckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals("First Name is required", checkoutPage.getFirstNameFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user must fill the First Name filed.");
    }


    @Test(description = "This test is verifying is LastNameField is mandatory.")
    public void CheckLastNameIsMandatory() {
        checkoutPage.addProductToCart();
        checkoutPage.enterFirstname();
        checkoutPage.enterAddressField();
        checkoutPage.clickPaymentInformationButton();
        checkoutPage.clickContinueCkeckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals("Last Name is required", checkoutPage.getLastNameFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user must fill Last Name Field.");
    }


    @Test(description = "This test is verifying if Address is mandatory.")
    public void CheckAddressIsMandatory() {
        checkoutPage.addProductToCart();
        checkoutPage.enterFirstname();
        checkoutPage.enterLastName();
        checkoutPage.clickPaymentInformationButton();
        checkoutPage.clickContinueCkeckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals("Address is required", checkoutPage.getAddressFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user must fill Last Name Field.");
    }

    @Test(description = "Changing quantity test. Asserting that the price is updated correctly.")
    public void quantityTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product after updating should be: " + expectedTotal);
        checkoutPage.clickPlusQuantity();
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is matching the expected price ");

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
        assertEquals(checkoutPage.totalPrice(), expectedTotal);
    }

    @Test(description = "Calculating the correct price for 2 products in cart")
    public void totalPriceForTwoProductsInCart() {
        checkoutPage.clickProductGraniteChips();
        checkoutPage.clickAddtoCartButton();
        checkoutPage.clickHomeSearchButton();
        checkoutPage.clickProductAwesomeSoftShirt();
        checkoutPage.clickAddSoftShirtToCart();
        checkoutPage.clickShowCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price product is: " + checkoutPage.productSoftShirtPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.productSoftShirtPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is" + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);
    }
}