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
import java.util.Optional;

public class ReportClaimsPage {

    WebDriver driver;

    @FindBy (xpath="//*[contains(text(),'Report claim')]")
    WebElement reportClaimsButton;

    @FindBy (css="div[class='MuiGrid-root MuiGrid-item']")
    List<WebElement> claimsSection;

    @FindBy (id="dateOfLoss")
    WebElement dateLoss;

    @FindBy (id="timeOfLoss")
    WebElement timeLoss;

    @FindBy (id="state")
    WebElement stateSelection;

    @FindBy (id="catastrophe")
    WebElement catastropheS;

    @FindBy (id="canContineLiving")
    WebElement continueLiving;

    @FindBy (id="bestTimeToCall")
    WebElement timeCall;

    @FindBy (id="timeZone")
    WebElement timeZoneS;

    @FindBy (id="saveStickyBarButton")
    WebElement stickyBarClaims;

    @FindBy (id="lossAddress")
    WebElement lossAddres;

    @FindBy (id="city")
    WebElement cityLoss;

    @FindBy (id="zipCode")
    WebElement codeZip;

    @FindBy(xpath = "//*[contains(text(),'Contact Information')]")
    WebElement informationContact;

    @FindBy(xpath = "//span[contains(text(),'Main Home')]")
    WebElement mainHome;

    @FindBy(css = "span[class='MuiTouchRipple-root']")
    List<WebElement>  checkbook;

    @FindBy(css = "input[id='firstName']")
    List<WebElement> nameFir;

    @FindBy(css = "input[id='lastName']")
    List<WebElement> nameLast;

    @FindBy(css = "input[id='email']")
    WebElement email;

    @FindBy (id="relationshipInsured")
    WebElement insuranceRe;

    @FindBy (id="homePhone")
    WebElement phone;


    public ReportClaimsPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectReportClaimsButton() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(reportClaimsButton)).click();
    }

    public void scroll(WebElement element)
    {
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void claimsSection()
    {

        for (WebElement webElement : claimsSection) {

            scroll(webElement);
            if (webElement.isDisplayed()) {
                System.out.println("All the sections are present");
            } else {
                Assert.assertTrue(webElement.isDisplayed());
            }
        }
    }

    public void enterDateLoss(String date) throws InterruptedException {
        Thread.sleep(5000);
        scroll(dateLoss);
        dateLoss.sendKeys(date);
        Thread.sleep(2000);
    }

    public void enterTimeLoss(String time) throws InterruptedException {
        Thread.sleep(5000);
        scroll(dateLoss);
        timeLoss.sendKeys(time);
        Thread.sleep(2000);
    }

    public void enterLossAddres(String address) throws InterruptedException {
        Thread.sleep(5000);
        scroll(lossAddres);
        lossAddres.sendKeys(address);
        Thread.sleep(2000);
    }

    public void enterCity(String city) throws InterruptedException {
        Thread.sleep(5000);
        scroll(cityLoss);
        cityLoss.sendKeys(city);
        Thread.sleep(2000);
    }

    public void enterZipCity(String zipcity) throws InterruptedException {
        Thread.sleep(5000);
        scroll(codeZip);
        codeZip.sendKeys(zipcity);
        Thread.sleep(2000);
    }

    public void enterBestCall(String best) throws InterruptedException {
        Thread.sleep(5000);
        scroll(timeCall);
        timeCall.sendKeys(best);
        Thread.sleep(2000);
    }

    public void selectState(String state) throws InterruptedException {
        Thread.sleep(3000);
        scroll(dateLoss);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(stateSelection)).click();
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if(page.editSelect.size() >1)
        {
            Optional<WebElement> correct = page.editSelect.stream().filter((element) -> element.getText().equals(state))
                    .findFirst();
            correct.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
        }
    }

    public void selectCata(String cata) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(catastropheS)).click();
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if(page.editSelect.size() >1)
        {
            Optional<WebElement> correct = page.editSelect.stream().filter((element) -> element.getText().equals(cata))
                    .findFirst();
            correct.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
        }
    }

    public void selectSituation(String situ) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(continueLiving)).click();
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if(page.editSelect.size() >1)
        {
            Optional<WebElement> correct = page.editSelect.stream().filter((element) -> element.getText().equals(situ))
                    .findFirst();
            correct.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
        }
    }

    public void checkbookSelection(int pos) throws InterruptedException {
        scroll(checkbook.get(pos));
        Actions act= new Actions(driver);
        act.moveToElement(checkbook.get(pos)).click(checkbook.get(pos)).build().perform();
        Thread. sleep(2000);
    }

    public void selectTimeZone(String time) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(timeZoneS)).click();
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if(page.editSelect.size() >1)
        {
            Optional<WebElement> correct = page.editSelect.stream().filter((element) -> element.getText().equals(time))
                    .findFirst();
            correct.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
        }
    }


    public void selectSubmitClaimsButton() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(stickyBarClaims)).click();
        Thread.sleep(10000);
    }

    public void goContactInformation()
    {
        scroll(informationContact);
    }

    public void enterFirstName(String name) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(nameFir.get(1)).build().perform();
        nameFir.get(1).sendKeys(name);
        Thread.sleep(2000);
    }

    public void enterLastName(String name) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(nameLast.get(1)).build().perform();
        nameLast.get(1).sendKeys(name);
        Thread.sleep(2000);
    }

    public void enterEmail(String name) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(email).build().perform();
        email.sendKeys(name);
        Thread.sleep(2000);
    }

    public void enterInsurance(String relation) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(insuranceRe).build().perform();
        insuranceRe.sendKeys(relation);
        Thread.sleep(2000);
    }

    public void enterHomePhone(String phoneN) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(phone).build().perform();
        phone.sendKeys(phoneN);
        Thread.sleep(2000);
    }



}
