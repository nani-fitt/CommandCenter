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


    public void editMenuEndorsement(String valueEndorsement) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        switch (valueEndorsement) {
            case "Additional Residence Rented To Others":
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(7))).click();
                Thread.sleep(3000);
                wait.until(ExpectedConditions.elementToBeClickable(page.editSelect.get(9))).click();
                break;
            case "Animal Liability": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(8))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(11)).build().perform();

                break;
            }
            case "Business Pursuits": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(9))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(13)).build().perform();

                break;
            }

            case "Fraud Protection": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(10))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(15)).build().perform();

                break;
            }
            case "Inflation Guard": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(11))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(17)).build().perform();

                break;
            }
            case "Mold And Rot": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(12))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(19)).build().perform();

                break;
            }
            case "Loss Assessment Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(13))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(21)).build().perform();

                break;
            }
            case "Loss Of Use Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(14))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(23)).build().perform();

                break;
            }
            case "Ordinance Or Law Increase": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(15))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(25)).build().perform();

                break;
            }
            case "Other Structures Increased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(16))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(27)).build().perform();

                break;
            }
            case "Other Structures Decreased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(17))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(29)).build().perform();

                break;
            }
            case "Other Structures Rented": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(18))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(31)).build().perform();

                break;
            }
            case "Permitted Incidental Occupancies": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(19))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(33)).build().perform();

                break;
            }
            case "Personal Injury": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(20))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(35)).build().perform();

                break;
            }
            case "Personal Liability Increased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(21))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(37)).build().perform();

                break;
            }
            case "Personal Property Increase Reduction": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(22))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(39)).build().perform();

                break;
            }
            case "Personal Property Replacement Cost": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(23))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(41)).build().perform();

                break;
            }
            case "Scheduled Personal Property Premium": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(24))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(43)).build().perform();

                break;
            }
            case "Screen Enclosure Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(25))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(45)).build().perform();

                break;
            }
            case "Sinkhole Loss Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(26))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(47)).build().perform();

                break;
            }
            case "Water Backup Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(27))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(49)).build().perform();

                break;
            }
            case "Watercraft Liability Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(28))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(51)).build().perform();

                break;
            }


        }
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
                editMenuEndorsement(option);
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

    public void versionIsssue() throws InterruptedException {
        Thread.sleep(5000);
        Actions act= new Actions(driver);
        act.moveToElement(versionIssue).build().perform();
        Assert.assertNotEquals(versionIssue.getText(), "Invalid Date");
        Thread.sleep(5000);
    }

    public void editRemoveEndorsement(String valueEndorsement) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        switch (valueEndorsement) {
            case "Additional Residence Rented To Others":
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(7))).click();
                Thread.sleep(3000);
                wait.until(ExpectedConditions.elementToBeClickable(page.editSelect.get(10))).click();

                break;
            case "Animal Liability": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(8))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(12)).build().perform();

                break;
            }
            case "Business Pursuits": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(9))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(14)).build().perform();

                break;
            }

            case "Fraud Protection": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(10))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(16)).build().perform();

                break;
            }
            case "Inflation Guard": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(11))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(18)).build().perform();

                break;
            }
            case "Mold And Rot": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(12))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(20)).build().perform();

                break;
            }
            case "Loss Assessment Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(13))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(22)).build().perform();

                break;
            }
            case "Loss Of Use Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(14))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(24)).build().perform();

                break;
            }
            case "Ordinance Or Law Increase": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(15))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(26)).build().perform();

                break;
            }
            case "Other Structures Increased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(16))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(28)).build().perform();

                break;
            }
            case "Other Structures Decreased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(17))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(30)).build().perform();

                break;
            }
            case "Other Structures Rented": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(18))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(32)).build().perform();

                break;
            }
            case "Permitted Incidental Occupancies": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(19))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(34)).build().perform();

                break;
            }
            case "Personal Injury": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(20))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(36)).build().perform();

                break;
            }
            case "Personal Liability Increased Limit": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(21))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(38)).build().perform();

                break;
            }
            case "Personal Property Increase Reduction": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(22))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(40)).build().perform();

                break;
            }
            case "Personal Property Replacement Cost": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(23))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(42)).build().perform();

                break;
            }
            case "Scheduled Personal Property Premium": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(24))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(44)).build().perform();

                break;
            }
            case "Screen Enclosure Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(25))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(46)).build().perform();

                break;
            }
            case "Sinkhole Loss Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(26))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(48)).build().perform();

                break;
            }
            case "Water Backup Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(27))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(50)).build().perform();

                break;
            }
            case "Watercraft Liability Coverage": {
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(28))).click();
                Thread.sleep(3000);
                Actions act = new Actions(driver);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(52)).build().perform();

                break;
            }


        }
    }

}

