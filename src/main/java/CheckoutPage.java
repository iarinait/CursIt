import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }


    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement productGraniteChips;

    public void clickProductGraniteChips() {
        productGraniteChips.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement clickAddtoCart;

    public void setClickAddtoCart() {
        clickAddtoCart.click();
    }

    @FindBy(linkText = "Your cart")
    private WebElement addToCartMessage;

    public WebElement getAddtocartmessage() {
        return addToCartMessage;
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement showCartIcon;

    public void showCartIcon() {
        showCartIcon.click();
    }
        @FindBy(css = ".btn.btn-success")
         private WebElement proceedToCheckout;
        public void clickProceedToCheckout() {
            proceedToCheckout.click();
        }

    // ADD Awesome Granite Chips Product To Cart Test
    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToCartLink;

    public void clickAddProductGraniteChipsToCartLink() {
        addProductGraniteChipsToCartLink.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addProductGraniteChipsToCartButton;

    public void clickAddProductGraniteChipsToCartButton() {
        addProductGraniteChipsToCartButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }
    @FindBy (xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;

    @FindBy (xpath = "(//td[@class='amount'])[2]")
    private WebElement taxPrice;
    @FindBy (xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice;
    public double productPrice(){
        String amountValue= itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }
    public double taxPrice(){
        String taxValue= taxPrice.getText();
        String cleantaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleantaxValue);
    }
    public double totalPrice(){
        String totalValue= totalPrice.getText();
        String cleantotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleantotalValue);
    }
    @FindBy (css= ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;
public void clickPlusQuantity(){
    plusQuantity.click();
}

    //place for locators and methods
    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }
}
