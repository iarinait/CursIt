
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)
public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Testing the login functionality")
    public void loginTest() throws InterruptedException {
        loginPage.clickloginIcon();
        loginPage.setUsername();
        loginPage.setPassword();
        loginPage.clickloginButton();
        assertEquals("dino", loginPage.getUserName().getText());
        ExtentTestNGITestListener.getTest().pass("The user was able to login with success!Test passed");

    }


}
