package ClassBase;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class EndorsementPage {

    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Endorsements')]")
    WebElement endorHeader;

    @FindBy(css = "input[class='MuiInputBase-input MuiOutlinedInput-input']")
    WebElement enterAnimal;

    @FindBy(css = "div[class='MuiGrid-root MuiGrid-item']")
    List<WebElement> name;

    @FindBy(id = "saveEndorsementButton")
    WebElement saveEndorsement;

    @FindBy(id = "issueStickyBarButton")
    WebElement issueButton;

    @FindBy(id = "selectedVersion")
    WebElement versionIssue;

    @FindBy(xpath= "//*[contains(text(),'Add Endorsement')]")
    WebElement addEndorsement;

    @FindBy(id= "selectedEndorsementId-label")
    WebElement endorAdd;

    @FindBy(css = "div[class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
    List<WebElement> animalClick;

    @FindBy(xpath= "//*[contains(text(),'ADD')]")
    WebElement buttonADD;



    public EndorsementPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyValue(String value) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if (page.insuranceInfo.size() > 1) {
            Optional<WebElement> correct = page.insuranceInfo.stream().filter((element) -> element.getText().equals(value))
                    .findFirst();
            return correct.isPresent();

        }
        return false;
    }

    public void verifyEndorsement(String endor) throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", endorHeader);
        boolean valueR= name.stream().anyMatch(webElement -> webElement.getText().equals(endor));
        Assert.assertTrue(valueR);

    }

    public void selectLockButtonEndorsement(String option) throws InterruptedException {
        Thread.sleep(5000);
        String pos= "0";
        DetailsPolicyPage details= new DetailsPolicyPage(driver);
        if (details.blockedByUnderwriter.size() == 0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(details.lockOption.get(4))).click();
        }else
        {
            while(details.alertMessage.getText().contains("This policy is currently locked by")) {
                driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
                driver.navigate().back();
                Thread.sleep(5000);
                details.selectQueue("New");
                details.policyFirstOption(pos);
                editRemoveEndorsement(option);
                int posC= Integer.parseInt(pos);
                posC= posC+1;
                pos= String.valueOf(posC);
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(details.lockOption.get(4))).click();
        }
        Thread.sleep(10000);

    }

    public void enterAnimalLiabilityValue(String animal) throws InterruptedException {
        Thread.sleep(5000);
        enterAnimal.click();
        String valueName = enterAnimal.getAttribute("value");
        Actions act = new Actions(driver);
        while (valueName.length() >= 1) {
            act.doubleClick(enterAnimal).build().perform();
            enterAnimal.sendKeys(Keys.DELETE);
            valueName = enterAnimal.getAttribute("value");
        }
        enterAnimal.sendKeys(animal);
        Thread.sleep(3000);
    }

    public void clickOnSaveEndorsement() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(saveEndorsement).click(saveEndorsement).build().perform();
    }

    public void clickOnIssueButton() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(issueButton).click(issueButton).build().perform();
        Thread.sleep(5000);
    }

    public void addEndorsement() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(addEndorsement).click(addEndorsement).build().perform();
        Thread.sleep(5000);
    }

    public void selectEndorsement(String endorsement) throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(endorAdd).click(endorAdd).build().perform();
        Thread.sleep(3000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        if(page.editSelect.size() > 1) {
            Optional<WebElement> value = page.editSelect.stream().filter((element) -> element.getText()
                    .equals(endorsement)).findFirst();
            value.ifPresent(webElement -> act.moveToElement(webElement).click(webElement).build().perform());
        }
    }

    public void selectLockButton() throws InterruptedException {
        Thread.sleep(5000);
        String pos = "0";
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if (page.blockedByUnderwriter.size() == 0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(page.lockOption.get(4))).click();
        } else if (page.blockedByUnderwriter.size() == 1) {
            if (driver.findElements(By.xpath("//span[contains(text(),'Cancel')]")).size() >= 1) {
                while (page.alertMessage.getText().contains("This policy is currently locked by")) {
                    driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
                    driver.navigate().back();
                    Thread.sleep(5000);
                    int posC = Integer.parseInt(pos);
                    posC = posC + 1;
                    pos = String.valueOf(posC);

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                    wait.until(ExpectedConditions.elementToBeClickable(page.lockOption.get(4))).click();
                }
            }
        }
    }

    public void versionIsssue() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(versionIssue).build().perform();
        Assert.assertNotEquals(versionIssue.getText(), "Invalid Date");
        Thread.sleep(5000);
    }

    public void addEndorsementButton() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(buttonADD).click(buttonADD).build().perform();
        Thread.sleep(3000);

    }


    public void editRemoveEndorsement(String valueEndorsement) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        switch (valueEndorsement) {
            case "Additional Residence Rented To Others":
            case "Animal Liability":
            case "Business Pursuits":
            case "Fraud Protection": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(8))).click();
                Thread.sleep(3000);
                wait.until(ExpectedConditions.elementToBeClickable(page.editSelect.get(11))).click();

                break;
            }
        }
    }

    public void selectEndorsementValues(String endorsement, String dataSelect) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        Optional<WebElement> element;
        switch (endorsement) {
            case "Additional Residence Rented To Others":
            case "Animal Liability":
            case "Fraud Protection":
            case "Inflation Guard":
            case "Mold And Rot":
            case "Loss Assessment Coverage":
            case "Loss Of Use Coverage":
            case "Other Structures Increased Limit":
            case "Other Structures Decreased Limit":
            case "Other Structures Rented": {
                animalClick.get(0).click();
                Thread.sleep(3000);
                element = page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
                break;
            }
            case "Business Pursuits":
            case "Watercraft Liability Coverage": {
                animalClick.get(0).click();
                Thread.sleep(3000);
                element= page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());

                animalClick.get(1).click();
                Thread.sleep(3000);
                element= page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());

                animalClick.get(2).click();
                Thread.sleep(3000);
                element= page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());

                break;
            }
            case "Ordinance Or Law Increase":
            case "Permitted Incidental Occupancies":
            case "Personal Injury":
            case "Personal Liability Increased Limit":
            case "Personal Property Increase Reduction":
            case "Personal Property Replacement Cost":
            case "Sinkhole Loss Coverage":
            case "Water Backup Coverage": {

                break;
            }
            case "Scheduled Personal Property Premium": {
                System.out.println("Implemented");
                break;
            }
            case "Screen Enclosure Coverage": {
                animalClick.get(0).click();
                Thread.sleep(3000);
                element= page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());

                animalClick.get(1).click();
                Thread.sleep(3000);
                element= page.editSelect.stream().filter(webElement -> webElement.getText().equals(dataSelect))
                        .findFirst();
                element.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());

                break;
            }


        }
    }


}

