package ClassBase;


import org.junit.Assert;
import org.openqa.selenium.By;
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
import java.util.Optional;
import java.util.stream.Stream;


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

    @FindBy(css = "div[class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
    WebElement otherStructureSelect;


    public CoveragePolicyRecord (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void expandableListCoverage() throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page= new DetailsPolicyPage(driver);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
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
        Actions act= new Actions(driver);
        switch (valueSelect) {
            case "Dwelling":
                act.moveToElement(page.propertyMenu.get(2)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(2))).click();
                Thread.sleep(3000);
                wait.until(ExpectedConditions.elementToBeClickable(page.editSelect.get(4))).click();
                break;
            case "Other Structure": {
                act.moveToElement(page.propertyMenu.get(3)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(3))).click();
                Thread.sleep(3000);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(5)).build().perform();

                break;
            }
            case "Personal Property": {
                act.moveToElement(page.propertyMenu.get(4)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(4))).click();
                Thread.sleep(3000);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(6)).build().perform();

                break;
            }
            case "Additional Living": {
                act.moveToElement(page.propertyMenu.get(5)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(5))).click();
                Thread.sleep(3000);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(7)).build().perform();

                break;
            }
            case "Personal liability": {
                act.moveToElement(page.propertyMenu.get(6)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(6))).click();
                Thread.sleep(3000);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(8)).build().perform();

                break;
            }
            case "Medical Payment": {
                act.moveToElement(page.propertyMenu.get(7)).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(page.propertyMenu.get(7))).click();
                Thread.sleep(3000);
                act.moveToElement(page.editSelect.get(3)).doubleClick(page.editSelect.get(9)).build().perform();

                break;
            }
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
        Actions act= new Actions(driver);
        act.moveToElement(saveDwelling).click(saveDwelling).build().perform();
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
         double percentProperty= Double.parseDouble(percentApplied.get(8).getText().replace("%",""));
         double personalPropertyValue= dwellingInt * (percentProperty/100);
         String valuePP= String.valueOf(personalPropertyValue);
         System.out.println("value personal property calculate"+ " "+ valuePP);
         String personalRealValue= coveragesNum.get(10).getText().replace("$","").
                replace(".00", ".0").replace(",","");
         System.out.println("value personal property real"+ " "+ personalRealValue);
          Assert.assertEquals(valuePP,personalRealValue);

         Thread.sleep(1000);
         Actions act= new Actions(driver);
         act.moveToElement(percentApplied.get(9)).build().perform();
        double additionalPercent= Double.parseDouble(percentApplied.get(9).getText().replace("%",""));
        double additionalValue= dwellingInt * (additionalPercent/100);
        String valueALE= String.valueOf(additionalValue);
        System.out.println("value additional living expense"+ " "+ valueALE);
        String additionalRealValue= coveragesNum.get(12).getText().replace("$","").
                replace(".00", ".0").replace(",","");
        System.out.println("value additional living expense"+ " "+ additionalRealValue);
        Assert.assertEquals(valueALE,additionalRealValue);

        if (percentApplied.get(7).getText().equals("0%"))
        {
            Assert.assertEquals("$0.00", coveragesNum.get(8).getText());
        }else
        {
            double otherStructure= Double.parseDouble(percentApplied.get(7).getText().replace("%",""));
            double otherStructureValue= dwellingInt * (otherStructure/100);
            String valueOther= String.valueOf(otherStructureValue);
            System.out.println("value other structure"+ " "+ valueALE);
            String otherRealValue= coveragesNum.get(8).getText().replace("$","").
                    replace(".00", ".0").replace(",","");
            System.out.println("value other structure"+ " "+ otherRealValue);
            Assert.assertEquals(valueOther,otherRealValue);
        }
    }

    public void verifyStickyBar() throws InterruptedException {
        Thread.sleep(3000);
       Assert.assertTrue(issueButton.isDisplayed());
       Assert.assertTrue(saveIssueButton.isDisplayed());
    }

    public void selectOtherStructure(String percent) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(otherStructureSelect)).click();
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if(page.editSelect.size() >1)
        {
            Optional<WebElement> correct = page.editSelect.stream().filter((element) -> element.getText().equals(percent))
                    .findFirst();
            correct.ifPresent(webElement -> wait.until(ExpectedConditions.elementToBeClickable(webElement)).click());
        }
    }

    public void correctPercentApplied(String value, String name) throws InterruptedException {
        Thread.sleep(3000);
        String dwellingValue= coveragesNum.get(6).getText().replace("$","")
                .replace(".00", "").replace(",",".");
        double percent= Double.parseDouble(value.replace("%",""));
        double dwellingConvert= Double.parseDouble(dwellingValue);
        double valueApplied= dwellingConvert * percent/100;

        String revertDwelling= String.valueOf(valueApplied);
        System.out.println("value applied"+ " "+ revertDwelling);
        String resultShow= "";

        switch (name) {
            case "Other Structure":
                resultShow = coveragesNum.get(8).getText().replace("$", "").
                        replace(".00", ".0").replace(",", "");
                System.out.println("value coverted" + " " + resultShow);
                break;
            case "Personal Property":
                resultShow = coveragesNum.get(10).getText().replace("$", "").
                        replace(".00", ".0").replace(",", "");
                System.out.println("value coverted" + " " + resultShow);
                break;
            case "Additional Living":
                resultShow = coveragesNum.get(12).getText().replace("$", "").
                        replace(".00", ".0").replace(",", "");
                System.out.println("value coverted" + " " + resultShow);
                break;
        }
        Assert.assertEquals(revertDwelling, resultShow);

    }

    public void selectLockButtonCoverage(String option) throws InterruptedException {
        Thread.sleep(5000);
        String pos = "0";
        DetailsPolicyPage details = new DetailsPolicyPage(driver);
        if (details.blockedByUnderwriter.size() == 0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(details.lockOption.get(4))).click();
        } else if (details.blockedByUnderwriter.size() == 1) {
            if(driver.findElements(By.xpath("//span[contains(text(),'Cancel')]")).size()>=1) {
                while (details.alertMessage.getText().contains("This policy is currently locked by")) {
                    driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
                    driver.navigate().back();
                    Thread.sleep(5000);
                    details.selectQueue("New");
                    details.policyFirstOption(pos);
                    expandableListCoverage();
                    editMenuCoverage(option);
                    int posC = Integer.parseInt(pos);
                    posC = posC + 1;
                    pos = String.valueOf(posC);
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                wait.until(ExpectedConditions.elementToBeClickable(details.lockOption.get(4))).click();
            }
        }
    }


    }


