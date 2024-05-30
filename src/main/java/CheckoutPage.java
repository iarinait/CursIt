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
    private WebElement clickAddtoCartButton;

    public void clickAddtoCartButton() {
        clickAddtoCartButton.click();
    }

//    @FindBy(linkText = "Your cart")
//    private WebElement addToCartMessage;
//
//    public WebElement getAddtocartmessage() {
//        return addToCartMessage;
//    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement clickShowCartIcon;

    public void clickShowCartIcon() {
        clickShowCartIcon.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement proceedToCheckout;

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    //            @FindBy(name = "Your information")
//        private WebElement ckeckoutInformationMessage;
//        public WebElement getCkeckoutInformationMessage(){
//            return ckeckoutInformationMessage;
//        }
    @FindBy(id = "first-name")
    private WebElement firstNamefield;

    public WebElement getFirstNamefield() {
        return firstNamefield;
    }

    public void enterFirstname() {
        firstNamefield.sendKeys("Gigi");
    }

    @FindBy(css = ".error")
    private WebElement firstNameFieldError;

    public WebElement getFirstNameFieldError() {
        return firstNameFieldError;
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void enterLastName() {
        lastNameField.sendKeys("Test");
    }

    @FindBy(css = ".error")
    private WebElement lastNameFieldError;

    public WebElement getLastNameFieldError() {
        return lastNameFieldError;
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public WebElement getAddressField() {
        return addressField;
    }

    public void enterAddressField() {
        addressField.sendKeys("Cluj");
    }

    @FindBy(css = ".error")
    private WebElement addressFieldError;

    public WebElement getAddressFieldError() {
        return addressFieldError;
    }


    @FindBy(css = ".form-check-input")
    private WebElement paymentInformationButton;

    public void clickPaymentInformationButton() {
        paymentInformationButton.click();
    }


    @FindBy(css = ".btn.btn-success")
    private WebElement continueCkeckoutButton;


    public void clickContinueCkeckoutButton() {
        continueCkeckoutButton.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement completeYourOrderButton;

    public void clickCompleteYourOrderButton() {
        completeYourOrderButton.click();
    }

    @FindBy(name = "Thank you for your order!")
    private WebElement completeOrderMessage;

    public WebElement getCompleteOrderMessage() {
        return completeOrderMessage;
    }

    @FindBy(css = ".text-center")
    private WebElement pageTitle;

    public WebElement getPageTitle() {
        return pageTitle;
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

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;

    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxPrice;
    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice;

    public double productPrice() {
        String amountValue = itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }

    public double taxPrice() {
        String taxValue = taxPrice.getText();
        String cleantaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleantaxValue);
    }

    public double totalPrice() {
        String totalValue = totalPrice.getText();
        String cleantotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleantotalValue);
    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;

    public void clickPlusQuantity() {
        plusQuantity.click();
    }


    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    public void fillMandatoryFieldsExcept(WebElement filedToSkip) {
        clickProductGraniteChips();
        clickAddtoCartButton();
        clickShowCartIcon();
        clickProceedToCheckout();
        enterFirstname();
        enterLastName();
        enterAddressField();
        filedToSkip.clear();
    }

    public void addProductToCart() {
        clickProductGraniteChips();
        clickAddtoCartButton();
        clickShowCartIcon();
        clickProceedToCheckout();
    }

    // Calculating the price for 2 products in cart
    //@FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement homeSearchButton;

    public void clickHomeSearchButton() {
        homeSearchButton.click();
    }

    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement productAwesomeSoftShirt;

    public void clickProductAwesomeSoftShirt() {
        productAwesomeSoftShirt.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addSoftShirtToCart;

    public void clickAddSoftShirtToCart() {
        addSoftShirtToCart.click();
    }

    //@FindBy(css = ".col-md-auto"
      @  FindBy(xpath = "(//div[@class='col-md-auto'])[6]")
    private WebElement SoftShirtPrice;

    public double productSoftShirtPrice() {
        String softShirtValue = SoftShirtPrice.getText();
        String productPriceValue = softShirtValue.replace("$", "");
        return Double.parseDouble(productPriceValue);
    }

//    public void selectOption(WebElement element, String option) {
//        Select optionSelect = new Select(element);
//        optionSelect.selectByVisibleText(option);
//    }
}
