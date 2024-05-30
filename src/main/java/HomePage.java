import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public WebDriverWait wait;

    public HomePage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    // Search Test
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-2x")
    private WebElement addProductToFavorite;

    public void clickAddProductToFavorite() {
        addProductToFavorite.click();
    }

    @FindBy(id = "input-search")
    private WebElement searchField;

    public void enterSearchField() {
        searchField.sendKeys("Product");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }

    // Add to favorite button
    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement shoppingBagProducts;

    public void clickShoppingBagProducts() {
        shoppingBagProducts.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-2x")
    private WebElement addToFavoriteButton;

    public void clickAddToFavoriteButton() {
        addToFavoriteButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement wishListButton;

    public void clickWishListButton() {
        wishListButton.click();
    }
// Home page Products Button Functionality

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement addToCartAwesomeShirt;

    public void clickAddToCartAwesomeShirt() {
        addToCartAwesomeShirt.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement shoppingCartButton;

    public void clickshoppingCartButton() {
        shoppingCartButton.click();
    }


    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement HomePageProducts;

    public void clickHomePageProducts() {
        HomePageProducts.click();
    }

    // Home Page Functionality(Your Cart Button & WishList Button)
    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement yourCartButton;

    public void clickYourCartButton() {
        yourCartButton.click();
    }

    //@FindBy(css = "text-muted")
    @FindBy(xpath = "//div[@class='text-muted']")
    private WebElement YourCarMessage;

    public WebElement getYourCartMessage() {
        return YourCarMessage;
    }

    @FindBy(linkText = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement wishlistButton;

    public void clickWishlistButton() {
        wishListButton.click();
    }

    @FindBy(linkText = "Wishlist")
    private WebElement wishListMessage;

    public WebElement getWishListMessage() {
        return wishListMessage;
    }

    // reset Button from Wishlist
    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16")
    private WebElement resetButton;

    public void clickResetButton() {
        resetButton.click();
    }

    @FindBy(css=".text-muted")
    private WebElement wishListProducts;

    public WebElement getWishListProducts() {
        return wishListProducts;
    }

    // Sorting Products by Name A to Z

    @FindBy(css= ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsByNameAtoZ;

    public WebElement getSortProductsByNameAtoZ(){
        return sortProductsByNameAtoZ;
    }
    @FindBy(css = "option[value = 'az']")
    private WebElement optionAZ;
    public WebElement getOptionAZ(){
        return optionAZ;
    }
//Sortin Products by Name Zto A
    @FindBy(css= ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsDropDown;

    public WebElement getSortProductsDropDown(){
        return sortProductsDropDown;
    }
    @FindBy(css = "option[value = 'za']")
    private WebElement optionZA;
    public WebElement getOptionZA(){
        return optionZA;
    }
    //Sorting products by price Low to high
    @FindBy(css = "option[value = 'lohi']")
    private WebElement optionLoHi;
    public WebElement getOptionLoHi(){
        return optionLoHi;
    }

    //Sorting products by price high to low
    @FindBy(css = "option[value = 'hilo']")
    private WebElement optionHiLo;
    public WebElement getOptionHiLo(){
        return optionHiLo;
    }






    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }
}
