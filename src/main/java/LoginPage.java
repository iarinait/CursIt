import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }


    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginIcon;

    public void clickloginIcon() {
        loginIcon.click();
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    public WebElement getUserNameField() {
        return getUserNameField();
    }

    public void setUsernameField() {
        userNameField.sendKeys("dino");
    }

    @FindBy(id = "password")
    private WebElement password;

    public void setPassword() {
        password.sendKeys("choochoo");
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;

    public void clickloginButton() {
        loginButton.click();
    }

    @FindBy(partialLinkText = "dino")
    private WebElement userName;

    public WebElement getUserName() {
        return userName;
    }



    @FindBy(css = ".error")
    private WebElement userNameFieldError;

    public WebElement getUserNameFieldError() {
        return userNameFieldError;
    }

    // test negativ cu Incorect UserName

    @FindBy(id = "user-name")
    private WebElement incorrectUserName;

    public void setIncorrectUserName() {
        incorrectUserName.sendKeys("Dino");
    }

    // Test negativ 2- Password
    @FindBy(css = ".error")
    private WebElement passwordFieldError;

    public WebElement getPasswordFieldError() {
        return passwordFieldError;
    }

    // Test negativ 2a- wrong Password
    @FindBy(id = "password")
    private WebElement incorrectPassword;

    public void setIncorrectPassword() {
        incorrectPassword.sendKeys("Chocho");
    }
    @FindBy(css = ".error")
    private WebElement incorectPasswordFieldError;

    public WebElement getIncorrectPasswordFieldError() {
        return incorectPasswordFieldError;
    }
}
