package ClassBase;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DetailsPolicyPage {

    WebDriver driver;

    @FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root']")
    List<WebElement> underwritingQueuePlus;

    @FindBy(xpath = "//p[contains(text(),'NEW')]")
    List<WebElement> underwritingQueueNew;

    @FindBy(xpath = "//*[contains(text(),'OH')]")
    List<WebElement> policyListNumber;

    @FindBy(id = "viewPolicyButton")
    List<WebElement> viewDetailsList;

    @FindBy(xpath = "//*[contains(text(), 'Details')]")
    WebElement detailOption;

    @FindBy(xpath = "//*[contains(text(), 'Coverages')]")
    WebElement coverageOption;

    @FindBy(xpath = "//h2[contains(text(),'Insured')]")
    WebElement insuranceSection;

    @FindBy(xpath = "//h2[contains(text(),'Additional Interests')]")
    WebElement additionalSection;

    @FindBy(id = "propertyActionsMenu")
    List<WebElement> propertyMenu;

    @FindBy(css = "div[class='MuiGrid-root MuiGrid-item']")
    List<WebElement> insuranceInfo;

    @FindBy(css = "ul[class='MuiList-root MuiMenu-list MuiList-padding'] li")
    List<WebElement> editSelect;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(css = "input[id='lastName']")
    WebElement lastName;

    @FindBy(id = "phoneNumber")
    WebElement phoneNumber;

    @FindBy(css = "input[id='email']")
    WebElement email;

    @FindBy(id = "BirthdayDate")
    WebElement birthday;

    @FindBy(css = "input[id='line1']")
    WebElement addressOne;

    @FindBy(css = "div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl MuiInputBase-marginDense MuiOutlinedInput-marginDense'] div")
    List<WebElement> dropdownOptions;

    @FindBy(id = "postalCode")
    WebElement postalCode;

    @FindBy(id = "saveInsuredButton")
    WebElement buttonSave;

    @FindBy(id = "addInsuredButton")
    List<WebElement>  buttonAddI;

    @FindBy(id = "cancelInsuredButton")
    WebElement buttonCancel;

    @FindBy(id = "addInterestButton")
    WebElement buttonSaveInterest;

    @FindBy(id = "cancelInterestButton")
    WebElement buttonCancelInterest;

    @FindBy(css = "button[class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary']")
    List<WebElement> lockOption;

    @FindBy(css = "span[class='MuiTypography-root MuiTypography-caption'] i")
    List<WebElement> blockedByUnderwriter;

    @FindBy(css = "ul[class='MuiList-root MuiMenu-list MuiList-padding'] li")
    List<WebElement> maritalStatusList;

    @FindBy(id = "siteSearchCriteria")
    WebElement searchCriteria;

    @FindBy(id = "city")
    WebElement cityEnter;

    @FindBy(css = "div[class='MuiGrid-root requestInfo MuiGrid-item']")
    List<WebElement> newChangePolicy;

    @FindBy(css = "div[class='MuiGrid-root MuiGrid-item'] button")
    List<WebElement> approvedAndReject;

    @FindBy(id = "addInsuredButton")
    WebElement addInsurance;

    @FindBy(xpath = "//*[contains(text(),'Add additional interest')]")
    WebElement addAdditionalInterest;

    @FindBy(id = "loanNumber")
    WebElement loanNumber;

    @FindBy(id = "institutionName")
    WebElement instituionName;

    @FindBy(id = "additionalInterestType")
    WebElement additionalType;

    @FindBy(css = "p[id='BirthdayDate-helper-text']")
    WebElement messageBirthday;

    @FindBy(id = "alert-dialog-description")
    WebElement alertMessage;

    @FindBy(id = "policyNumber")
    WebElement policyNu;


    public DetailsPolicyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signInAll(String email, String pass) throws InterruptedException {
        SignInPage signin = new SignInPage(driver);
        signin.enterEmail(email);
        signin.enterPassword(pass);
        signin.signIn();
        Thread.sleep(5000);
    }

    public void selectQueue(String queue) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(underwritingQueueNew.get(0).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(underwritingQueuePlus.get(2))).click();

    }

    public void policySelect(String policyNumber) throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> searchListView = driver.findElements(By.xpath("//*[contains(text(),'VIEW POLICY')]"));
        for (int i = 0; i < policyListNumber.size(); i++) {
            if (policyListNumber.get(i).getText().equals(policyNumber)) {
                if (viewDetailsList.size() >= 1 && blockedByUnderwriter.size()==0) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                    wait.until(ExpectedConditions.elementToBeClickable(viewDetailsList.get(i))).click();
                    break;
                } else if (searchListView.size() >= 1 && blockedByUnderwriter.size()==0) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                    wait.until(ExpectedConditions.elementToBeClickable(searchListView.get(i))).click();
                    break;
                }
            }
        }
    }

    public void detailsSection() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(policyNu.isDisplayed());
    }

    public void coverageSection() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.textToBePresentInElement(coverageOption, "COVERAGES"));
    }

    public void expandableListDetails() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(underwritingQueuePlus.get(1))).click();
    }

    public void detailsHeader(String policyNumber) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(policyListNumber.get(0).getText(), policyNumber);
        Assert.assertTrue(insuranceSection.isDisplayed());
        Assert.assertTrue(additionalSection.isDisplayed());
        Assert.assertTrue(propertyMenu.get(0).isDisplayed());
    }

    public void insuranceInformation() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Assert.assertTrue(insuranceInfo.get(0).isDisplayed());
    }

    public void editMenu(String valueSelect) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        Actions act= new Actions(driver);

        if (valueSelect.equals("Insurance Information")) {
            act.moveToElement(propertyMenu.get(1)).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(propertyMenu.get(1))).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(editSelect.get(3))).click();
        } else if (valueSelect.equals("Additional Interest")) {
            int pos= propertyMenu.size()-1;
            int posE= editSelect.size()-1;
            act.moveToElement(propertyMenu.get(pos)).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(propertyMenu.get(pos))).click();
            Thread.sleep(3000);
            act.moveToElement(editSelect.get(posE)).doubleClick(editSelect.get(posE)).build().perform();

        }

    }

    public void addInsuranceInfo() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Actions act = new Actions(driver);
        act.moveToElement(buttonAddI.get(0)).click(buttonAddI.get(0)).build().perform();
    }

    public void addInsuranceInfoSave() throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.moveToElement(buttonAddI.get(1)).click(buttonAddI.get(1)).build().perform();
    }

    public void buttonSaveInsuranceInfo() throws InterruptedException {
        Thread.sleep(4000);
        Actions act= new Actions(driver);
        act.moveToElement(buttonSave).click(buttonSave).build().perform();
        Thread.sleep(5000);
    }

    public void buttonCancelInsuranceInfo() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCancel)).click();
        Thread.sleep(2000);
    }

    public void buttonSaveInterest() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSaveInterest)).click();
        Thread.sleep(5000);
    }

    public void buttonCancelInterest() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCancelInterest)).click();
        Thread.sleep(2000);
    }

    public void editInsuranceScreen() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(firstName.isDisplayed());
        Assert.assertTrue(lastName.isDisplayed());
        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(birthday.isDisplayed());
        Assert.assertTrue(addressOne.isDisplayed());
    }

    public void editInformation(String name, String mail, String status, String addres) throws InterruptedException {
        Thread.sleep(5000);
        firstName.click();
        String valueName = firstName.getAttribute("value");
        Actions act = new Actions(driver);
        while (valueName.length() >= 1) {
            act.doubleClick(firstName).build().perform();
            firstName.sendKeys(Keys.DELETE);
            valueName = firstName.getAttribute("value");
        }
        firstName.sendKeys(name);
        Thread.sleep(3000);

        email.click();
        String valueEmail = email.getAttribute("value");
        while (valueEmail.length() >= 1) {
            act.doubleClick(email).build().perform();
            email.sendKeys(Keys.DELETE);
            valueEmail = email.getAttribute("value");
        }
        email.sendKeys(mail);
        Thread.sleep(3000);

        dropdownOptions.get(2).click();
        selectMaritalStatus(status);

        Thread.sleep(3000);
        addressOne.click();
        String value = addressOne.getAttribute("value");
        while (value.length() >= 1) {
            act.doubleClick(addressOne).build().perform();
            addressOne.sendKeys(Keys.DELETE);
            value = addressOne.getAttribute("value");
        }
        addressOne.sendKeys(addres);
    }

    public void showEditInsuranceInfo(String mail, String status, String addrs) throws InterruptedException {
        Thread.sleep(5000);
        if (insuranceInfo.size() > 1) {
            Assert.assertEquals(insuranceInfo.get(10).getText(), status);
            Assert.assertTrue(insuranceInfo.get(12).getText().contains(addrs));
        }

    }

    public void selectLockButtonDetails(String option) throws InterruptedException {
        Thread.sleep(5000);
        String pos= "0";
        if (blockedByUnderwriter.size() == 0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(lockOption.get(4))).click();
        }else if (blockedByUnderwriter.size() == 1) {
            if (driver.findElements(By.xpath("//span[contains(text(),'Cancel')]")).size() >= 1) {
                while (alertMessage.getText().contains("This policy is currently locked by")) {
                    driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
                    driver.navigate().back();
                    Thread.sleep(5000);
                    selectQueue("New");
                    policyFirstOption(pos);
                    expandableListDetails();
                    editMenu(option);
                    int posC = Integer.parseInt(pos);
                    posC = posC + 1;
                    pos = String.valueOf(posC);
                }

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                wait.until(ExpectedConditions.elementToBeClickable(lockOption.get(4))).click();
            }
        }


    }

    public void selectMaritalStatus(String status) {
        for (WebElement webElement : maritalStatusList) {

            if (webElement.getText().equals(status)) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
                break;
            }

        }

    }

    public void searchPolicy(String policy) throws InterruptedException {
        Thread.sleep(5000);
        searchCriteria.click();
        searchCriteria.sendKeys(policy);
        searchCriteria.sendKeys(Keys.ENTER);
    }


    public void pendingChangeStatus(String status) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(newChangePolicy.get(0).getText(), status);
    }

    public void enterInsuranceData(String name, String lastnam, String phoneN, String dateB, String city, String postal, String state, String county,
                                   String emai, String marital, String addres) throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.click(firstName).build().perform();
        firstName.sendKeys(name);
        Thread.sleep(2000);

        act.click(lastName).build().perform();
        lastName.sendKeys(lastnam);
        Thread.sleep(2000);

        act.click(phoneNumber).build().perform();
        phoneNumber.sendKeys(phoneN);
        Thread.sleep(2000);

        act.click(birthday).build().perform();
        birthday.sendKeys(dateB);
        Thread.sleep(2000);

        act.click(email).build().perform();
        email.sendKeys(emai);
        Thread.sleep(2000);

        dropdownOptions.get(2).click();
        selectMaritalStatus(marital);
        Thread.sleep(2000);

        addressOne.sendKeys(addres);
        Thread.sleep(2000);

        cityEnter.sendKeys(city);
        Thread.sleep(2000);

        postalCode.sendKeys(postal);
        Thread.sleep(2000);

        dropdownOptions.get(3).click();
        selectMaritalStatus(state);

    }

    public void enterEmailOnly(String mail) throws InterruptedException {
        Thread.sleep(5000);
        email.click();
        Actions act = new Actions(driver);
        String valueEmail = email.getAttribute("value");
        while (valueEmail.length() >= 1) {
            act.doubleClick(email).build().perform();
            email.sendKeys(Keys.DELETE);
            valueEmail = email.getAttribute("value");
        }
        email.sendKeys(mail);
        Thread.sleep(3000);
    }

    public void newInformationCreate(String status) throws InterruptedException {
        Thread.sleep(9000);
        Actions act= new Actions(driver);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", newChangePolicy.get(0));
        for (WebElement webElement : newChangePolicy) {

            if (webElement.getText().equals(status)) {
                Assert.assertEquals(webElement.getText(), status);
                break;
            }
        }
    }

    public void policyFirstOption(String policyPosition) throws InterruptedException {
        Thread.sleep(5000);
        int i = Integer.parseInt(policyPosition);
        List<WebElement> searchListView = driver.findElements(By.xpath("//*[contains(text(),'VIEW POLICY')]"));
        if (viewDetailsList.size() >= 1) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(viewDetailsList.get(i))).click();
        } else if (searchListView.size() >= 1  ) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.elementToBeClickable(searchListView.get(i))).click();
        }
    }

    public void addAdditionalInterest() throws InterruptedException {
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.moveToElement(addAdditionalInterest).doubleClick(addAdditionalInterest).build().perform();
    }

    public void verifyAddAdditionalInterestScreen() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(firstName.isDisplayed());
        Assert.assertTrue(lastName.isDisplayed());
        Assert.assertTrue(loanNumber.isDisplayed());
        Assert.assertTrue(additionalType.isDisplayed());
        Assert.assertTrue(instituionName.isDisplayed());
        Assert.assertTrue(addressOne.isDisplayed());
    }

    public void addAdditionalInterest(String name, String lastnam, String loanN, String instname, String addres, String city, String postal) throws InterruptedException {
        Thread.sleep(7000);
        Actions act = new Actions(driver);
        act.click(firstName).build().perform();
        firstName.sendKeys(name);
        Thread.sleep(2000);

        act.click(lastName).build().perform();
        lastName.sendKeys(lastnam);
        Thread.sleep(2000);

        act.click(loanNumber).build().perform();
        loanNumber.sendKeys(loanN);
        Thread.sleep(2000);

        act.click(instituionName).build().perform();
        instituionName.sendKeys(instname);
        Thread.sleep(2000);

        act.click(instituionName).build().perform();
        addressOne.sendKeys(addres);
        Thread.sleep(2000);

        cityEnter.sendKeys(city);
        Thread.sleep(2000);

        postalCode.sendKeys(postal);
        Thread.sleep(2000);

    }

    public void enterBirthayOnly(String dateBirth) throws InterruptedException {
        Thread.sleep(5000);
        birthday.click();
        Actions act = new Actions(driver);
        String valueEmail = birthday.getAttribute("value");
        act.doubleClick(birthday).build().perform();
        birthday.sendKeys(Keys.DELETE);
       /* while (valueEmail.length() >= 1) {

            birthday.sendKeys(Keys.DELETE);
            valueEmail = email.getAttribute("value");
        }*/
        birthday.sendKeys(dateBirth);
        Thread.sleep(3000);
    }

    public void errorMessage(String message) throws InterruptedException {
        Thread.sleep(3000);
        Calendar fecha= new GregorianCalendar();
        int ano= fecha.get(Calendar.YEAR);
        int year= ano - 18;
        int mes= fecha.get(Calendar.MONTH);
        int mes1= mes +1;
        int date= fecha.get(Calendar.DAY_OF_MONTH);
        String actualDate= " "+ mes1 + "/"+ date + "/" + year;
        System.out.println("actualDate = " + actualDate);
        String mess= message.concat(actualDate);
        if (messageBirthday.isDisplayed()) {
            Assert.assertEquals(messageBirthday.getText(), mess);
        }
    }

    public void editInterest(String lastNam, String loanNumb, String instName) throws InterruptedException {
        Thread.sleep(5000);
        lastName.click();
        String valueName = lastName.getAttribute("value");
        Actions act = new Actions(driver);
        while (valueName.length() >= 1) {
            act.doubleClick(lastName).build().perform();
            lastName.sendKeys(Keys.DELETE);
            valueName = lastName.getAttribute("value");
        }
        lastName.sendKeys(lastNam);
        Thread.sleep(3000);

        loanNumber.click();
        String valueEmail = loanNumber.getAttribute("value");
        while (valueEmail.length() >= 1) {
            act.doubleClick(loanNumber).build().perform();
            loanNumber.sendKeys(Keys.DELETE);
            valueEmail = loanNumber.getAttribute("value");
        }
        loanNumber.sendKeys(loanNumb);
        Thread.sleep(3000);

        instituionName.click();
        String inst = instituionName.getAttribute("value");
        while (inst.length() >= 1) {
            act.doubleClick(instituionName).build().perform();
            instituionName.sendKeys(Keys.DELETE);
            inst = instituionName.getAttribute("value");
        }
        instituionName.sendKeys(instName);
        Thread.sleep(3000);
    }


}

