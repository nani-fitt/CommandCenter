package ClassBase;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RatingInfoPage {
    WebDriver driver;


    @FindBy(xpath = "//*[contains(text(), 'Rating')]")
    WebElement ratingHeader;

    @FindBy(xpath = "//*[contains(text(), 'Insured Information')]")
    WebElement headerRating;



    public RatingInfoPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void ratingSection() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", ratingHeader);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.textToBePresentInElement(ratingHeader, "RATING INFORMATION"));
    }

    public void expandableListRating() throws InterruptedException {
        Thread.sleep(3000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(page.underwritingQueuePlus.get(5))).click();
        Thread.sleep(2000);
        Assert.assertTrue(headerRating.isDisplayed());

    }
}
