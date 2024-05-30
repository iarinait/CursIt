import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)
public class HomeTest extends Hooks {

    public HomePage homePage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test(description = "This test is searching for the 'Search Field' functionality")
    public void searchTest() throws InterruptedException {
        homePage.enterSearchField();
        homePage.clickSearchButton();
        ExtentTestNGITestListener.getTest().pass("The user can use Search field easy");
    }

    @Test(description = "This test is searching the functionality of Favorite Button")
    public void addProductToFavoriteTest() throws InterruptedException {
        homePage.clickShoppingBagProducts();
        homePage.clickAddToFavoriteButton();
        homePage.clickWishListButton();
        ExtentTestNGITestListener.getTest().pass("The user is able to add products to wishlist!");
    }

    @Test(description = "This test is searching functionality of Home Page products button")
    public void homePageProductsButtonFunctionalityTest() throws InterruptedException {
        homePage.clickAddToCartAwesomeShirt();
        homePage.clickshoppingCartButton();
        homePage.clickHomePageProducts();
        ExtentTestNGITestListener.getTest().pass("The user is able to return to HomePage Products list using the Home PageProducts Button!");
    }

    @Test(description = "This test is searching the functionality of Your Cart Button & Wishlist Button ")
    public void homePageFunctionalityTest() throws InterruptedException {
        homePage.clickYourCartButton();
        assertEquals("Your cart", homePage.getYourCartMessage().getText());
        homePage.clickWishlistButton();
        assertEquals("Wishlist", homePage.getWishListMessage().getText());
    }

    @Test(description = "This test is searching the functionality of reset button from wishlist")
    public void resetButtonTest() throws InterruptedException {
        homePage.clickAddToFavoriteButton();
        homePage.clickWishListButton();
        homePage.clickResetButton();
        Thread.sleep(2000);
        assertEquals("Wishlist", homePage.getWishListProducts().getText());
    }

    @Test(description = "This test is searching functionality os sorting products by name A to Z")
    public void sortProductsByNameAtoZ() throws InterruptedException {
        homePage.selectOption(homePage.getSortProductsByNameAtoZ(), "Sort by name (A to Z)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are sorting correctly by name from A to Z");
        assertEquals("Sort by name (A to Z)", homePage.getOptionAZ().getText());
    }

    @Test(description = "This test is searching functionality of sorting products by name Z to A")
    public void sortProductsByNameZtoA() throws InterruptedException {
        homePage.selectOption(homePage.getSortProductsDropDown(), "Sort by name (Z to A)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are sorting correctly by name from Z to A");
        assertEquals("Sort by name (Z to A)", homePage.getOptionZA().getText());
    }

    @Test(description = "This test is searching functionality of sorting products by price low to high")
    public void sortProductsByPriceLowToHigh() throws InterruptedException {
        homePage.selectOption(homePage.getSortProductsDropDown(), "Sort by price (low to high)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are sorting correctly by price low to high");
        assertEquals("Sort by price (low to high)", homePage.getOptionLoHi().getText());

    }
    @Test(description = "This test is searching functionality of sorting products by price high to low")
    public void sortProductsByPriceHighToLow() throws InterruptedException {
        homePage.selectOption(homePage.getSortProductsDropDown(), "Sort by price (high to low)");
        Thread.sleep(2000);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The products are sorting correctly by price high to low");
        assertEquals("Sort by price (high to low)", homePage.getOptionHiLo().getText());

    }
}