package ClassBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ActivityLogPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Activity')]")
    List<WebElement> activityName;

    @FindBy(xpath = "//span[contains(text(),'Documents')]")
    List<WebElement> docName;

    @FindBy(css = "i[class='fas fa-plus-square']")
    List<WebElement> addActivity;

    @FindBy(css = "select[class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
    List<WebElement> selectElementsActivity;

    @FindBy(id = "standard-textarea")
    WebElement description;

    @FindBy(css = "button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")
    WebElement saveActivityButton;

    @FindBy(xpath = "//span[contains(text(),'On')]")
    List<WebElement> activityCreation;

    @FindBy(id = "documentTypeSelected")
    WebElement typeDoc;

    @FindBy(id = "visibilityTypeSelected")
    List<WebElement> visibilityType;

    @FindBy(id = "fileDocument")
    WebElement fileDoc;

    @FindBy(xpath = "//*[contains(text(),'Upload')]")
    WebElement uploadButton;

    @FindBy(xpath = "//*[contains(text(),'DeclarationTestAuto.pdf')]")
    List<WebElement> checkDoc;

    public ActivityLogPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void activityDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElements(activityName.get(1)));
    }

    public void clickAddActivity() throws InterruptedException {
        Thread.sleep(3000);
        if(addActivity.get(0).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(addActivity.get(0))).click();
        }
    }

    public void selectElementsActivityLogType(String logType) throws InterruptedException {
        Thread.sleep(3000);
        Select select= new Select(selectElementsActivity.get(0));
        select.selectByVisibleText(logType);
        Thread.sleep(2000);
    }

    public void selectElementsActivityVisible(String visibleType) throws InterruptedException {
        Thread.sleep(3000);
        Select select= new Select(selectElementsActivity.get(1));
        select.selectByVisibleText(visibleType);
        Thread.sleep(2000);
    }

    public void enterDescription(String descrip) throws InterruptedException {
        Thread.sleep(3000);
        description.sendKeys(descrip);
    }

    public void clickSaveButtonActivity() throws InterruptedException {
        Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(saveActivityButton)).click();
            Thread.sleep(3000);

    }

    public void verifyCreation() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("verify result activity"+ activityCreation.get(0).getText());
        String [] text= activityCreation.get(0).getText().split(" ");
        System.out.println("verify result activity convert"+ text[1]);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss aa");
        Date date4 = new Date();
        String [] compare= dateFormat.format(date4).split(" ");
        System.out.println("verify real value"+ compare[0]);
        Assert.assertEquals(text[1],compare[0]);
    }

    public void activityDoc() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElements(docName.get(1)));
    }

    public void clickAddDoc() throws InterruptedException {
        Thread.sleep(3000);
        if(addActivity.get(1).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(addActivity.get(1))).click();
        }
    }

    public void selectDocType(String type) throws InterruptedException {
        Thread.sleep(3000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        Actions act= new Actions(driver);
        act.moveToElement(typeDoc).click(typeDoc).build().perform();
       Optional<WebElement> element= page.editSelect.stream()
               .filter(webElement -> webElement.getText().equals(type)).findFirst();
      element.ifPresent(webElement -> act.moveToElement(webElement).click().build().perform());
    }

    public void selectDocTypeVisible(String type) throws InterruptedException {
        Thread.sleep(3000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", visibilityType.get(0));
        Optional<WebElement> element= page.editSelect.stream()
                .filter(webElement -> webElement.getText().equals(type)).findFirst();
        element.ifPresent(webElement -> webElement.click());
    }

    public void selectDoc() throws InterruptedException {
        Thread.sleep(3000);
        Actions act= new Actions(driver);
        fileDoc.sendKeys("/Users/esneyddisguerrerodurand/Desktop/Receipt-2.pdf");
        Thread.sleep(4000);
        act.moveToElement(uploadButton).click(uploadButton).build().perform();
        Thread.sleep(5000);

    }

    public void checkDoc() throws InterruptedException {
        Thread.sleep(5000);
       // driver.navigate().refresh();
        Assert.assertTrue(checkDoc.get(0).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(checkDoc.get(1).isDisplayed());

    }
}
