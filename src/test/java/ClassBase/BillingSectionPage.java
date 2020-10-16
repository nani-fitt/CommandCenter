package ClassBase;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BillingSectionPage {
    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(), 'Billing')]")
    List<WebElement> billingHeader;

    @FindBy(xpath = "//*[contains(text(), 'Buyer information')]")
    WebElement headerBilling;


    public BillingSectionPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void billingSection() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", billingHeader.get(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.textToBePresentInElement(billingHeader.get(0), "BILLING"));
    }

    public void expandableListBilling() throws InterruptedException {
        Thread.sleep(3000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(page.underwritingQueuePlus.get(3))).click();
        Thread.sleep(2000);
        Assert.assertTrue(headerBilling.isDisplayed());

    }
}
