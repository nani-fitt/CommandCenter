package StepsDefinitions;


import ClassBase.DetailsPolicyPage;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class DetailsPolicy extends TestBase {

    DetailsPolicyPage deta= new DetailsPolicyPage(driver);
    Properties p;

    @Given("user Sign In with correct credentials {string} and {string}")
    public void userSignInWithCorrectCredentialsAnd(String username, String password) throws IOException, InterruptedException {
       // Log.info("Sign option displayed");
        p= PropertyHelper.loadData();
        String email= p.getProperty(username);
        String pass= p.getProperty(password);
        deta.signInAll(email,pass);
    }

    @When("select the Queue desired {string}")
    public void selectTheQueueDesired(String nameQueue) throws IOException, InterruptedException {
      //  Log.info("Select queue desired");
        p= PropertyHelper.loadData();
        String queue= p.getProperty(nameQueue);
        deta.selectQueue(queue);
    }

    @And("select the policy desired {string}")
    public void selectThePolicyDesired(String policyNumber) throws IOException, InterruptedException {
     //   Log.info("Select the policy desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(policyNumber);
        deta.policySelect(policy);

    }

    @Then("verify Details section is displayed")
    public void verifyDetailsSectionIsDisplayed() throws InterruptedException {
      //  Log.info("Verify details section");
        deta.detailsSection();
    }

    @And("verify Coverage section is displayed")
    public void verifyCoverageSectionIsDisplayed() throws InterruptedException {
      //  Log.info("Verify Coverage section");
        deta.coverageSection();
    }

    @And("select expandable list for details")
    public void selectExpandableListForDetails() throws InterruptedException {
     //   Log.info("Select expandable list");
        deta.expandableListDetails();
    }

    @Then("verify primary insurance information are present")
    public void verifyPrimaryInsuranceInformationArePresent() throws InterruptedException {
     //   Log.info("Verify primary insurance information");
        deta.insuranceInformation();

    }

    @And("select edit primary insurance information")
    public void selectEditPrimayInsuranceInformation() throws InterruptedException {
     //   Log.info("Select edit primary insurance");
        deta.editMenu();
    }

    @Then("verify insurance information are displayed {string}")
    public void verifyInsuranceInformationAreDisplayed(String policyNumber) throws IOException, InterruptedException {
     //   Log.info("Verify insurance information are displayed");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(policyNumber);
        deta.detailsHeader(policy);
    }

    @Then("verify Save button is desable")
    public void verifySaveButtonIsDesable() throws InterruptedException {
    //    Log.info("Verify Save button");
        deta.buttonSaveInsuranceInfo();
        deta.buttonCancelInsuranceInfo();
    }

    @When("verify edit insurance screen are displayed")
    public void verifyEditInsuranceScreenAreDisplayed() throws InterruptedException {
     //   Log.info("Verify Edit screen");
        deta.editInsuranceScreen();
    }

    @Then("edit the information desired {string} {string} {string} {string}")
    public void editTheInformationDesired(String firstName, String email, String maritalStatus, String address) throws IOException, InterruptedException {
      //  Log.info("Verify edit information");
        p= PropertyHelper.loadData();
        String firstNa= p.getProperty(firstName);
        String ema= p.getProperty(email);
        String maritalStat= p.getProperty(maritalStatus);
        String sddres= p.getProperty(address);
        deta.editInformation(firstNa,ema,maritalStat,sddres);

    }

    @And("click on save button")
    public void clickOnSaveButton() throws InterruptedException {
     //   Log.info("Click on save button");
        deta.buttonSaveInsuranceInfo();
    }

    @Then("verify the information is updated {string} {string} {string} {string}")
    public void verifyTheInformationIsUpdated(String firstName, String email, String maritalStatus, String address) throws IOException, InterruptedException {
     //   Log.info("Verify the information is updated");
        p= PropertyHelper.loadData();
        String firstNa= p.getProperty(firstName);
        String ema= p.getProperty(email);
        String maritalStat= p.getProperty(maritalStatus);
        String sddres= p.getProperty(address);
        deta.showEditInsuranceInfo(firstNa, ema, maritalStat, sddres);
    }

    @And("select Lock for edit")
    public void selectLockForEdit() throws InterruptedException {
     //   Log.info("Select Lock to Edit");
        deta.selectLockButton();
    }

    @When("enter the criteria desired {string}")
    public void enterTheNumberOfPolicyDesired(String criteria) throws IOException, InterruptedException {
     //   Log.info("Enter criteria desired");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(criteria);
        deta.searchPolicy(policy);
    }

    @Then("verify the information error message")
    public void verifyTheInformationErrorMessage() {
     //   Log.info("Verify the error message");
    }

}
