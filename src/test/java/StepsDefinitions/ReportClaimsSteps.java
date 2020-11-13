package StepsDefinitions;

import ClassBase.DetailsPolicyPage;
import ClassBase.ReportClaimsPage;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class ReportClaimsSteps extends TestBase {

    ReportClaimsPage claims= new ReportClaimsPage(driver);
    DetailsPolicyPage details= new DetailsPolicyPage(driver);
    Properties p;

    @And("select Report Claim button")
    public void selectReportClaimButton() throws InterruptedException {
        Log.info("select report Claims button");
        claims.selectReportClaimsButton();
    }

    @Then("verify report claim screen is displayed")
    public void verifyReportClaimScreenIsDisplayed() {
        Log.info("verify claim screen is displayed");
        claims.claimsSection();
    }


    @When("enter the data for Report By section {string}{string}")
    public void enterTheDataForReportBySection(String firstName, String lastName) throws IOException, InterruptedException {
        Log.info("enter data for Report By");
        p= PropertyHelper.loadData();
        String name= p.getProperty(firstName);
        String lastN= p.getProperty(lastName);
        details.enterFirstName(name);
        details.enterLastName(lastN);
    }

    @And("enter the data for Loss Information section {string}{string}{string}{string}{string}{string}{string}{string}")
    public void enterTheDataForLossInformationSection(String dateLoss, String timeLoss, String addres, String city, String state, String zipCode, String situation, String damage) throws IOException, InterruptedException {
        Log.info("enter loss information data");
        p= PropertyHelper.loadData();
        String date= p.getProperty(dateLoss);
        String time=p.getProperty(timeLoss);
        String address= p.getProperty(addres);
        String cit= p.getProperty(city);
        String states= p.getProperty(state);
        String zip= p.getProperty(zipCode);
        String sit= p.getProperty(situation);
        String dama= p.getProperty(damage);
        claims.enterDateLoss(date);
        claims.enterTimeLoss(time);
        claims.enterLossAddres(address);
        claims.enterCity(cit);
        claims.enterZipCity(zip);
        claims.selectState(states);
        claims.selectCata(sit);
        claims.selectSituation(dama);

    }

    @And("select damages property {string}")
    public void selectDamagesProperty(String propertyDame) throws IOException, InterruptedException {
        Log.info("select damages");
        p=PropertyHelper.loadData();
        int damage= 20;
        claims.checkbookSelection(damage);

    }

    @And("select liability {string}")
    public void selectLiability(String liability) throws IOException, InterruptedException {
        Log.info("select liability");
        p=PropertyHelper.loadData();
        int liab= 22;
        claims.checkbookSelection(liab);
    }

    @And("select cause of loss {string}")
    public void selectCauseOfLoss(String causeLoss) throws IOException, InterruptedException {
        Log.info("select liability");
        p=PropertyHelper.loadData();
        int cause= 23;
        claims.checkbookSelection(cause);

    }

    @And("select other contact information")
    public void selectOtherContactInformation() throws IOException, InterruptedException {
        Log.info("select other data");
        p= PropertyHelper.loadData();
        String test= p.getProperty("TimeZone");
        String test1=p.getProperty("BestCall");
        claims.selectTimeZone(test);
        claims.enterBestCall(test1);
    }

    @Then("click on submit button")
    public void clickOnSubmitButton() throws InterruptedException {
       Log.info("click on submit button");
       claims.selectSubmitClaimsButton();
    }

    @And("verify the claims is created correctly {string}{string}")
    public void verifyTheClaimsIsCreatedCorrectly(String firstNameC, String lastNameC) throws IOException {
        Log.info("verify claim is created");
        p= PropertyHelper.loadData();
        String name= p.getProperty(firstNameC);
        String last= p.getProperty(lastNameC);

    }

    @Then("enter the contact information desired {string}{string}{string}{string}{string}")
    public void enterTheContactInformationDesired(String firstNameC, String lastNameC, String phoneNumber, String email, String relationwithinsurance) throws IOException, InterruptedException {
        Log.info("enter loss information data");
        p= PropertyHelper.loadData();
        String name= p.getProperty(firstNameC);
        String last=p.getProperty(lastNameC);
        String phone= p.getProperty(phoneNumber);
        String ema= p.getProperty(email);
        String relation= p.getProperty(relationwithinsurance);
        claims.enterFirstName(name);
        claims.enterLastName(last);
        claims.enterEmail(ema);
        claims.enterInsurance(relation);
        claims.enterHomePhone(phone);

    }

    @When("select autofill data option")
    public void selectAutofillDataOption() throws InterruptedException {
        Log.info("select autofill'");
        claims.autoFillReportBy();

    }

    @When("select autofill contact data option")
    public void selectAutofillContactOption() throws InterruptedException {
        Log.info("select autofill'");
        claims.autoFillContact();
    }

    @And("select complete data option")
    public void selectCompleteDataOption() throws InterruptedException {
        Log.info("select complete data option");
        claims.completeFields();
    }

    @And("enter the data for Loss Information section {string}{string}{string}")
    public void enterTheDataForLossInformationSection(String timeLoss, String situation, String damage) throws IOException, InterruptedException {
        Log.info("enter the data Loss Information");
        p= PropertyHelper.loadData();
        String text= p.getProperty(timeLoss);
        String sit= p.getProperty(situation);
        String dama= p.getProperty(damage);
        claims.enterTimeLoss(text);
        claims.selectCata(sit);
        claims.selectSituation(dama);
    }

    @Then("enter the contact information desired {string}")
    public void enterTheContactInformationDesired(String relationwithinsurance) throws IOException, InterruptedException {
        Log.info("enter the contact information");
        p= PropertyHelper.loadData();
        String text= p.getProperty(relationwithinsurance);
        claims.enterInsurance(text);
    }


    }