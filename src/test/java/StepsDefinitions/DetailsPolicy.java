package StepsDefinitions;


import ClassBase.DetailsPolicyPage;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class DetailsPolicy extends TestBase {

    DetailsPolicyPage deta= new DetailsPolicyPage(driver);
    Properties p;

    @Given("user Sign In with correct credentials {string} and {string}")
    public void userSignInWithCorrectCredentialsAnd(String username, String password) throws IOException, InterruptedException {
        Log.info("Sign option displayed");
        p= PropertyHelper.loadData();
        String email= p.getProperty(username);
        String pass= p.getProperty(password);
        deta.signInAll(email,pass);
    }

    @When("select the Queue desired {string}")
    public void selectTheQueueDesired(String nameQueue) throws IOException, InterruptedException {
        Log.info("Select queue desired");
        p= PropertyHelper.loadData();
        String queue= p.getProperty(nameQueue);
        deta.selectQueue(queue);
    }

    @And("select the policy desired {string}")
    public void selectThePolicyDesired(String policyNumber) throws IOException, InterruptedException {
        Log.info("Select the policy desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(policyNumber);
        deta.policySelect(policy);

    }

    @Then("verify Details section is displayed")
    public void verifyDetailsSectionIsDisplayed() throws InterruptedException {
        Log.info("Verify details section");
        deta.detailsSection();
    }

    @And("verify Coverage section is displayed")
    public void verifyCoverageSectionIsDisplayed() throws InterruptedException {
        Log.info("Verify Coverage section");
        deta.coverageSection();
    }

    @And("select expandable list for details")
    public void selectExpandableListForDetails() throws InterruptedException {
        Log.info("Select expandable list");
        deta.expandableListDetails();
    }

    @Then("verify primary insurance information are present")
    public void verifyPrimaryInsuranceInformationArePresent() throws InterruptedException {
        Log.info("Verify primary insurance information");
        deta.insuranceInformation();

    }

    @And("select edit primary insurance information")
    public void selectEditPrimayInsuranceInformation() throws InterruptedException {
        Log.info("Select edit primary insurance");
        deta.editMenu();
    }

    @Then("verify insurance information are displayed {string}")
    public void verifyInsuranceInformationAreDisplayed(String policyNumber) throws IOException, InterruptedException {
        Log.info("Verify insurance information are displayed");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(policyNumber);
        deta.detailsHeader(policy);
    }

    @Then("verify Save button is desable")
    public void verifySaveButtonIsDesable() throws InterruptedException {
        Log.info("Verify Save button");
        deta.buttonSaveInsuranceInfo();
        deta.buttonCancelInsuranceInfo();
    }

    @When("verify edit insurance screen are displayed")
    public void verifyEditInsuranceScreenAreDisplayed() throws InterruptedException {
       Log.info("Verify Edit screen");
        deta.editInsuranceScreen();
    }

    @Then("edit the information desired {string} {string} {string} {string}")
    public void editTheInformationDesired(String firstName, String email, String maritalStatus, String address) throws IOException, InterruptedException {
        Log.info("Verify edit information");
        p= PropertyHelper.loadData();
        String firstNa= p.getProperty(firstName);
        Random randomGenerator= new Random(System.currentTimeMillis());
        int randomInt = randomGenerator.nextInt(10000);
        String randomEmail=p.getProperty(email)+randomInt+"@mailinator.com";
        String maritalStat= p.getProperty(maritalStatus);
        String sddres= p.getProperty(address);
        deta.editInformation(firstNa,randomEmail,maritalStat,sddres);

    }

    @And("click on save button")
    public void clickOnSaveButton() throws InterruptedException {
       Log.info("Click on save button");
        deta.buttonSaveInsuranceInfo();
    }

    @Then("verify the information is updated {string} {string} {string}")
    public void verifyTheInformationIsUpdated(String email, String maritalStatus, String address) throws IOException, InterruptedException {
       Log.info("Verify the information is updated");
        p= PropertyHelper.loadData();
        Random randomGenerator= new Random(System.currentTimeMillis());
        int randomInt = randomGenerator.nextInt(10000);
        String randomEmail=p.getProperty(email)+randomInt+"@mailinator.com";
        String maritalStat= p.getProperty(maritalStatus);
        String sddres= p.getProperty(address)+ randomInt;
        deta.showEditInsuranceInfo( randomEmail, maritalStat, sddres);
    }

    @And("select Lock for edit")
    public void selectLockForEdit() throws InterruptedException {
        Log.info("Select Lock to Edit");
        deta.selectLockButton();
    }

    @When("enter the criteria desired {string}")
    public void enterTheNumberOfPolicyDesired(String criteria) throws IOException, InterruptedException {
        Log.info("Enter criteria desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(criteria);
        deta.searchPolicy(policy);
    }

    @Then("verify the information error message")
    public void verifyTheInformationErrorMessage() {
       Log.info("Verify the error message");
        validateWindows();
    }

    @And("verify Pending Change status is displayed")
    public void verifyPendingChangeStatusIsDisplayed() throws InterruptedException, IOException {
        Log.info("Verify pending change status is displayed");
        p= PropertyHelper.loadData();
        String status= p.getProperty("statusPending");
        deta.pendingChangeStatus(status);
    }

    @And("select Add insurance button")
    public void selectAddInsuranceButton() throws InterruptedException {
        Log.info("Click on Add insurance information");
        deta.addInsuranceInfo();
    }

    @Then("verify the secondary Insurance is displayed")
    public void verifyTheSecondaryInsuranceIsDisplayed() throws InterruptedException, IOException {
        Log.info("verify secondary insurance displayed");
        p= PropertyHelper.loadData();
        String status= p.getProperty("statusCreate");
        deta.newSecondaryInsurance(status);

    }

    @Then("enter the information desired {string} {string} {string} {string} {string} {string} {string}{string}{string} {string} {string}")
    public void enterTheInformationDesired(String firstName, String lastName, String phoneNumber, String dateBirth, String city, String postal, String state, String county, String email, String maritalStatus, String address) throws IOException, InterruptedException {
        Log.info("Enter the data desired Add insurance");
        p= PropertyHelper.loadData();
        Random randomGenerator= new Random(System.currentTimeMillis());
        int randomInt = randomGenerator.nextInt(10000);
        String firstNa= p.getProperty(firstName);
        String last= p.getProperty(lastName);
        String numberP= p.getProperty(phoneNumber)+randomInt;
        String birth= p.getProperty(dateBirth);
        String cit= p.getProperty(city);
        String codePostal= p.getProperty(postal);
        String stateS= p.getProperty(state);
        String coun= p.getProperty(county);
        String randomEmail=p.getProperty(email);
        String maritalStat= p.getProperty(maritalStatus);
        String sddres= p.getProperty(address);

        deta.enterInsuranceData(firstNa,last,numberP,birth,cit,codePostal,stateS,coun,randomEmail,maritalStat,sddres);

    }

    @Then("edit the information desired {string}")
    public void editTheInformationDesired(String email) throws IOException, InterruptedException {
        Log.info("Incorrect email");
        p= PropertyHelper.loadData();
        String mailIn= p.getProperty(email);
        deta.enterEmailOnly(mailIn);

    }

    @When("select approve button")
    public void selectApproveButton() {

    }

    @And("verify Approved status is displayed")
    public void verifyApprovedStatusIsDisplayed() {

    }

    @And("select first policy displayed")
    public void selectFirstPolicyDisplayed() throws InterruptedException {
        Log.info("Select first policy displayed");
        deta.policyFirstOption();
    }
}
