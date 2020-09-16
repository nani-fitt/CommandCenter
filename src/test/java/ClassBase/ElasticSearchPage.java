package ClassBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ElasticSearchPage {

    WebDriver driver;
    @FindBy(id= "claim")
    WebElement selectClaim;

    @FindBy(id= "policy")
    WebElement selectPolicy;

    @FindBy(id= "inspection")
    WebElement selectInspection;

    @FindBy(xpath= "//span[contains(text(),'d8ce1b5b')]")
    WebElement inspectionNumber;

    @FindBy(css= "div[class='alert alert-light text-center']")
    WebElement errorMessage;

    public ElasticSearchPage (WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyResultPolicy(String policy) throws InterruptedException {
        Thread.sleep(5000);
      DetailsPolicyPage page= new DetailsPolicyPage(driver);
        Assert.assertEquals(page.policyListNumber.get(0).getText(),policy);
    }

    public void selectClaimsCheck() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(selectClaim).click(selectClaim).build().perform();

    }

    public void selectPolicyCheck() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(selectPolicy).click(selectPolicy).build().perform();

    }

    public void selectInspectionCheck() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(selectInspection).click(selectInspection).build().perform();

    }
    public void verifyResultClaims(String claims) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        Assert.assertTrue(page.policyListNumber.get(0).isDisplayed());
    }

    public void verifyResultInspection(String inspection) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(inspectionNumber.getText(), inspection);
    }

    public void errorMessage(String message) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(errorMessage.getText(), message);
    }

    public void verifyAllResult() throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        Assert.assertNotEquals(page.underwritingQueuePlus.size(), 1);
    }
}
