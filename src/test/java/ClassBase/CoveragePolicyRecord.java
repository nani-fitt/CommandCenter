package ClassBase;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CoveragePolicyRecord {

    WebDriver driver;
    @FindBy(xpath = "//h2[contains(text(),'Section I Property')]")
    WebElement sectionIHeader;

    @FindBy(css = "div[class='MuiGrid-root MuiGrid-item']")
    List<WebElement> coverageType;

    @FindBy(id = "limitOfLiabilityValue")
    WebElement dwellingValue;

    @FindBy(id = "saveCoverageButton")
    WebElement saveDwelling;

    @FindBy(id = "cancelCoverageButton")
    WebElement cancelDwelling;

    @FindBy(id = "limitOfLiabilityValue-helper-text")
    WebElement errorMessage;

    @FindBy(css = "p[class='MuiTypography-root MuiTypography-body2'] strong")
    List<WebElement> percentApplied;

    @FindBy(css = "p[class='MuiTypography-root MuiTypography-body2']")
    List<WebElement> coveragesNum;

    @FindBy(id = "issueStickyBarButton")
    WebElement issueButton;

    @FindBy(id = "saveStickyBarButton")
    WebElement saveIssueButton;


    public CoveragePolicyRecord (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void expandableListCoverage() throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(page.underwritingQueuePlus.get(2))).click();
    }

    public void selectCoverageDesired(String value)
    {
       boolean valueR= coverageType.stream().anyMatch(webElement -> webElement.getText().equals(value));
        Assert.assertTrue(valueR);
    }

    public void editMenuCoverage(String valueSelect) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        if (valueSelect.equals("Dwelling")) {
            wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(1))).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(page.editSelect.get(3))).click();
        } else if (valueSelect.equals("Additional Interest")) {
            int pos = page.propertyMenu.size() - 1;
            int posE = page.editSelect.size() - 1;
            wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(pos))).click();
            Thread.sleep(3000);
            Actions act = new Actions(driver);
            act.moveToElement(page.editSelect.get(posE)).doubleClick(page.editSelect.get(posE)).build().perform();

        }
    }

        public void enterDwellingValue(String dwelling) throws InterruptedException {
            Thread.sleep(5000);
            dwellingValue.click();
            String valueName = dwellingValue.getAttribute("value");
            Actions act = new Actions(driver);
            while (valueName.length() >= 1) {
                act.doubleClick(dwellingValue).build().perform();
                dwellingValue.sendKeys(Keys.DELETE);
                valueName = dwellingValue.getAttribute("value");
            }
            dwellingValue.sendKeys(dwelling);
            Thread.sleep(3000);
        }

    public void clickOnSaveDwelling() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(saveDwelling)).click();
    }

    public void clickOnCancelDwelling() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(cancelDwelling)).click();
    }

    public void coverageErrorMessage(String message) throws InterruptedException {
        Thread.sleep(3000);
        if (errorMessage.isDisplayed()) {
            Assert.assertEquals(errorMessage.getText(), message);
        }
    }

    public void verifyValuesChangesPP(String dwelling) throws InterruptedException {
         Thread.sleep(5000);
         double dwellingInt= Double.parseDouble(dwelling);
         double percentProperty= Double.parseDouble(percentApplied.get(2).getText().replace("%",""));
         double personalPropertyValue= dwellingInt * (percentProperty/100);
         double personalRealValue= Double.parseDouble(coveragesNum.get(3).getText().replace("$",""));
         Assert.assertEquals(personalPropertyValue,personalRealValue);

         Thread.sleep(1000);
         Actions act= new Actions(driver);
         act.moveToElement(percentApplied.get(3)).build().perform();
        double additionalPercent= Double.parseDouble(percentApplied.get(2).getText().replace("%",""));
        double additionalValue= dwellingInt * (additionalPercent/100);
        double additionalRealValue= Double.parseDouble(coveragesNum.get(6).getText().replace("$",""));
        Assert.assertEquals(additionalValue,additionalRealValue);
    }

    public void verifyStickyBar() throws InterruptedException {
        Thread.sleep(3000);
       Assert.assertTrue(issueButton.isDisplayed());
       Assert.assertTrue(saveIssueButton.isDisplayed());
    }




}
