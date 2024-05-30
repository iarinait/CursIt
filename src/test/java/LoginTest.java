
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
        loginPage.setUsernameField();
        loginPage.setPassword();
        loginPage.clickloginButton();
        assertEquals("dino", loginPage.getUserName().getText());
        ExtentTestNGITestListener.getTest().pass("The user was able to login with success!Test passed");

    }


    @Test(description = "This test is searching the login functionality without Username ")
    public void negativeLoginTest1() throws InterruptedException {
        loginPage.clickloginIcon();
        loginPage.setPassword();
        loginPage.clickloginButton();
        assertEquals("Please fill in the username!", loginPage.getUserNameFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user is not able to login without a Username");
    }


    @Test(description = " This test is searching the login functionality with a wrong UserName")
    public void negativeLoginTest1a() throws InterruptedException {
        loginPage.clickloginIcon();
        loginPage.setIncorrectUserName();
        loginPage.setPassword();
        loginPage.clickloginButton();
        assertEquals(("Incorrect username or password!"), loginPage.getUserNameFieldError().getText());
        Thread.sleep(1000);
        ExtentTestNGITestListener.getTest().pass("The user is not able to login with a wrong Username");
    }

    @Test(description = "This test is searching the login functionality without Password ")
    public void negativeLoginTest2() throws InterruptedException {
        loginPage.clickloginIcon();
        loginPage.setUsernameField();
        loginPage.clickloginButton();
        assertEquals("Please fill in the password!", loginPage.getPasswordFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user is not able to login without a Password");
    }

    @Test(description = "This test is searching the login functionality with a wrong Password ")
    public void negativeLoginTest2a() throws InterruptedException {
        loginPage.clickloginIcon();
        loginPage.setUsernameField();
        loginPage.setIncorrectPassword();
        loginPage.clickloginButton();
        assertEquals(("Incorrect username or password!"), loginPage.getIncorrectPasswordFieldError().getText());
        ExtentTestNGITestListener.getTest().pass("The user is not able to login with a wrong Password");
    }


}
