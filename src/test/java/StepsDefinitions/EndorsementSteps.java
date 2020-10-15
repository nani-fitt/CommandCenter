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

    @Then("select add endorsement button")
    public void selectAddEndorsementButton() throws InterruptedException {
        Log.info("select add endorsement button");
        endorsement.addEndorsement();
    }

    @And("select the endorsement desired {string}")
    public void selectTheEndorsementDesired(String endorsementNameA) throws IOException, InterruptedException {
        Log.info("select the endorsement desired");
        p= PropertyHelper.loadData();
        String selectAddEndorsement= p.getProperty(endorsementNameA);
        endorsement.selectEndorsement(selectAddEndorsement);
    }

    @And("enter the data desired {string} {string}")
    public void enterTheDataDesired(String endorsementNameA, String endorsementNameValues) throws IOException, InterruptedException {
        Log.info("enter the data desired");
        p= PropertyHelper.loadData();
        String selectAddEndorsement= p.getProperty(endorsementNameA);
        String value= p.getProperty(endorsementNameValues);
        endorsement.selectEndorsementValues(selectAddEndorsement,value);
    }

    @When("click in Add button")
    public void clickInAddButton() throws InterruptedException {
        Log.info("click in the Add button");
        endorsement.addEndorsementButton();
    }

    @And("select Lock for edit")
    public void selectLockForEdit() throws InterruptedException {
        Log.info("select Lock for Edit");
        endorsement.selectLockButton();
    }
}
