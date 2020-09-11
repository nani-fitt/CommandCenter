package ClassBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SignInPage {

    WebDriver driver;


   @FindBy (id= "email")
    WebElement email;

    @FindBy (id= "password")
    WebElement pass;

    @FindBy (css= "span[class='MuiButton-label']")
    WebElement signInButton;

    @FindBy (css= "button[class='MuiButtonBase-root MuiIconButton-root']")
    List<WebElement> expand;

    @FindBy (css= "span[class='MuiTouchRipple-root']")
    List<WebElement> underwriting;

    @FindBy (css= "span[class='MuiTypography-root MuiListItemText-primary MuiTypography-body1']")
    WebElement menuItem;

    @FindBy (id= "errorMessage")
    WebElement errorMess;

    @FindBy (xpath= "//*[contains(text(),'Forgot your password?')]")
    WebElement forgotPassword;

    @FindBy (xpath= "//*[contains(text(),'Send Confirmation')]")
    WebElement buttonConf;

    public SignInPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String emailText) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys(emailText);
    }

    public void enterPassword(String passText) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.sendKeys(passText);
    }

    public void signIn() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", signInButton);
        Thread.sleep(5000);
    }

    public void verifyQueue() throws InterruptedException {
          Thread.sleep(5000);
          expand.get(0).click();
          Thread.sleep(5000);
    }

    public void errorMessage(String mess) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMess,mess));

    }
    public void emailPresent() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(email.isDisplayed());
    }

    public void forgotPasswordDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(forgotPassword.isDisplayed());
    }

    public void clickOnForgotPassword() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();
    }

    public void confButtons() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(buttonConf.isDisplayed());
    }

}
