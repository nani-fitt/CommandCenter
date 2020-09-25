package StepsDefinitions;

import ClassBase.EndorsementPage;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class EndorsementSteps extends TestBase {

    EndorsementPage endorsement= new EndorsementPage(driver);
    Properties p;

    @Then("verify endorsement desired is displayed {string}")
    public void verifyEndorsementDesiredIsDisplayed(String endorsementName) throws IOException, InterruptedException {
        Log.info("Verify endorsement is displayed");
        p= PropertyHelper.loadData();
        String endorNa= p.getProperty(endorsementName);
        endorsement.verifyEndorsement(endorNa);
    }

    @And("select Lock for edit endorsement {string}")
    public void selectLockForEditEndorsement(String endorsementName) throws IOException, InterruptedException {
        Log.info("Verify endorsement is displayed");
        p= PropertyHelper.loadData();
        String endorNa= p.getProperty(endorsementName);
        endorsement.selectLockButtonEndorsement(endorNa);
    }

    @When("enter the values desired endorsement {string}")
    public void enterTheValuesDesiredEndorsement(String endorsementValues) throws IOException, InterruptedException {
        Log.info("enter the values desired");
        p= PropertyHelper.loadData();
        String animal= p.getProperty(endorsementValues);
        endorsement.enterAnimalLiabilityValue(animal);

    }

    @Then("select edit option endorsement{string}")
    public void selectEditOptionEndorsement(String endorsementName) throws IOException, InterruptedException {
        Log.info("select edit endorsement");
        p= PropertyHelper.loadData();
        String endorNa= p.getProperty(endorsementName);
        endorsement.editMenuEndorsement(endorNa);
    }

    @And("click on save endorsement button")
    public void clickOnSaveEndorsementButton() throws InterruptedException {
        Log.info("select save endorsement");
        endorsement.clickOnSaveEndorsement();
    }

    @And("select remove endorsement {string}")
    public void selectLockForEditAndRemoveEndorsement(String endorsementName) throws IOException, InterruptedException {
        Log.info("select remove endorsement");
        p= PropertyHelper.loadData();
        String endorNa= p.getProperty(endorsementName);
        endorsement.editRemoveEndorsement(endorNa);
    }

    @When("click on issue button")
    public void clickOnIssueButton() throws InterruptedException {
        Log.info("click on issue button");
        endorsement.clickOnIssueButton();
    }

    @Then("verify the issue is created")
    public void verifyTheIssueIsCreated() throws InterruptedException {
        Log.info("verify issue is created");
        endorsement.versionIsssue();

    }
}
