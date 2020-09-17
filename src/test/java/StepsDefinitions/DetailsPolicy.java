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
    public void selectThePolicyDesired(String criteria) throws IOException, InterruptedException {
        Log.info("Select the policy desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(criteria);
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

    @And("select edit information {string}")
    public void selectEditPrimayInsuranceInformation(String editButtonOption) throws InterruptedException, IOException {
        Log.info("Select edit primary insurance");
        p= PropertyHelper.loadData();
        String editSelect= p.getProperty(editButtonOption);
        deta.editMenu(editSelect);
    }

    @Then("verify insurance information are displayed {string}")
    public void verifyInsuranceInformationAreDisplayed(String policyNumber) throws IOException, InterruptedException {
        Log.info("Verify insurance information are displayed");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(policyNumber);
        deta.detailsHeader(policy);
    }

    @Then("verify Save button is disable")
    public void verifySaveButtonIsDisable() throws InterruptedException {
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
        String sddres= p.getProperty(address);
        deta.showEditInsuranceInfo( randomEmail, maritalStat, sddres);
    }

    @And("select Lock for edit details {string}")
    public void selectLockForEdit(String editButtonOption) throws InterruptedException, IOException {
        Log.info("Select Lock to Edit");
        p= PropertyHelper.loadData();
        String selection= p.getProperty(editButtonOption);
        deta.selectLockButtonDetails(selection);
    }

    @When("enter the criteria desired {string}")
    public void enterTheNumberOfPolicyDesired(String criteria) throws IOException, InterruptedException {
        Log.info("Enter criteria desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(criteria);
        deta.searchPolicy(policy);
    }

    @Then("verify the information error message {string}")
    public void verifyTheInformationErrorMessage(String message) throws IOException, InterruptedException {
       Log.info("Verify the error message");
        p= PropertyHelper.loadData();
        String mess= p.getProperty(message);
       deta.errorMessage(mess);
        validateWindows();
    }

    @And("verify Pending Change status is displayed")
    public void verifyPendingChangeStatusIsDisplayed() throws InterruptedException, IOException {
        Log.info("Verify pending change status is displayed");
        p= PropertyHelper.loadData();
        String status= p.getProperty("statusPending");
        deta.pendingChangeStatus(status);
        validateWindows();
    }

    @And("select Add insurance button")
    public void selectAddInsuranceButton() throws InterruptedException {
        Log.info("Click on Add insurance information");
        deta.addInsuranceInfo();
    }

    @Then("verify status is updated {string}")
    public void verifyTheSecondaryInsuranceIsDisplayed(String status) throws InterruptedException, IOException {
        Log.info("verify status is updated");
        p= PropertyHelper.loadData();
        String changePolicy= p.getProperty(status);
        deta.newInformationCreate(changePolicy);

    }

    @Then("enter the information desired {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
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

    @And("select first policy displayed {string}")
    public void selectFirstPolicyDisplayed(String index) throws InterruptedException, IOException {
        Log.info("Select first policy displayed");
        p= PropertyHelper.loadData();
        String policyPosition= p.getProperty(index);
        deta.policyFirstOption(policyPosition);
    }

    @And("select Add additional interest button")
    public void selectAddAdditionalInterestButton() throws InterruptedException {
        Log.info("Select Add Additional interest button");
        deta.addAdditionalInterest();
    }

    @When("verify additional interest screen are displayed")
    public void verifyAdditionalInterestScreenAreDisplayed() throws InterruptedException {
        Log.info("Verify Additional interest screen");
        deta.verifyAddAdditionalInterestScreen();
    }

    @Then("enter additional interest information {string}{string}{string}{string}{string}{string}{string}")
    public void enterAdditionalInterestInformation(String firstName, String lastName, String loanNumber, String institutionName, String address, String city, String postal) throws InterruptedException, IOException {
        Log.info("Enter Additional Interest information");
        p= PropertyHelper.loadData();
        Random randomGenerator= new Random(System.currentTimeMillis());
        int randomInt = randomGenerator.nextInt(10000);
        String firstNa= p.getProperty(firstName);
        String last= p.getProperty(lastName);
        String loanN= p.getProperty(loanNumber)+randomInt;
        String instName= p.getProperty(institutionName);
        String addres= p.getProperty(address);
        String cityIn= p.getProperty(city);
        String codePostal= p.getProperty(postal);
        deta.addAdditionalInterest(firstNa,last,loanN,instName,addres,cityIn,codePostal);
    }

    @Then("edit the date of birth {string}")
    public void editTheDateOfBirth(String dateBirth) throws IOException, InterruptedException {
        Log.info("Edit date of birth");
        p= PropertyHelper.loadData();
        String incorrectDate= p.getProperty(dateBirth);
        deta.enterBirthayOnly(incorrectDate);

    }
    @Then("edit the additional information desired {string}{string}{string}")
    public void editTheAdditionalInformationDesired(String lastName, String loanNumber, String institutionName) throws IOException, InterruptedException {
        Log.info("Edit Additional Interest");
        p= PropertyHelper.loadData();
        String lastNa= p.getProperty(lastName);
        String loanN= p.getProperty(loanNumber);
        String instName= p.getProperty(institutionName);
        deta.editInterest(lastNa,loanN,instName);

    }

    @And("click on save button interest")
    public void clickOnSaveButtonInterest() throws InterruptedException {
        Log.info("Save interest button");
        deta.buttonSaveInterest();
    }

    @And("verify Personal Property and Additional Living values")
    public void verifyPersonalPropertyAndAdditionalLivingValues() {
        Log.info("verify personal property and additional living values change");

    }
}
