package StepsDefinitions;

import ClassBase.CoveragePolicyRecord;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class CoveragePolicySteps extends TestBase {

    CoveragePolicyRecord coverage= new CoveragePolicyRecord(driver);
    Properties p;

    @And("select expandable list for coverage")
    public void selectExpandableListForCoverage() throws InterruptedException {
        Log.info("Select Coverage section Policy record");
        coverage.expandableListCoverage();
    }

    @Then("verify all the coverage section are present")
    public void verifyAllTheCoverageSectionArePresent() {
        Log.info("Verify all the type of coverage are displayed");
        coverage.selectCoverageDesired("A. Dwelling");
        coverage.selectCoverageDesired("B. Other Structures");
        coverage.selectCoverageDesired("C. Personal Property");
        coverage.selectCoverageDesired("D. Fair Rental Value and Additional Living Expense");
        coverage.selectCoverageDesired("E. Personal Liability (each occurrence)");
        coverage.selectCoverageDesired("F. Medical Payments");
    }

    @Then("select edit Dwelling option")
    public void selectEditDwellingOption() throws InterruptedException {
        Log.info("Select edit dwelling option");
        coverage.editMenuCoverage("Dwelling");
    }

    @When("enter the values desired {string}")
    public void enterTheValuesDesired(String coveragesValues) throws IOException, InterruptedException {
        Log.info("Enter the values desired");
        p= PropertyHelper.loadData();
        String dwellingV= p.getProperty(coveragesValues);
        coverage.enterDwellingValue(dwellingV);

    }

    @And("click on save coverage button")
    public void clickOnSaveDwellingButton() throws InterruptedException {
        Log.info("click on save coverage button");
        coverage.clickOnSaveDwelling();
    }

    @Then("verify the information coverage error message {string}")
    public void verifyTheInformationCoverageErrorMessage(String dwellingMess) throws IOException, InterruptedException {
        Log.info("verify an error message is displayed");
        p= PropertyHelper.loadData();
        String message= p.getProperty(dwellingMess);
        coverage.coverageErrorMessage(message);

    }

    @And("verify Personal Property and Additional Living values {string}")
    public void verifyPersonalPropertyAndAdditionalLivingValues(String coveragesValues) throws IOException, InterruptedException {
        Log.info("verify personal property and additional living values change");
        p= PropertyHelper.loadData();
        String dwellingV= p.getProperty(coveragesValues);
        coverage.verifyValuesChangesPP(dwellingV);

    }

    @And("verify sticky bar is displayed")
    public void verifyStickyBarIsDisplayed() throws InterruptedException {
        Log.info("verify sticky bar is displayed");
        coverage.verifyStickyBar();
    }

    @When("select the percent to apply {string}")
    public void selectThePercentToApply(String dropdownValues) throws IOException, InterruptedException {
        Log.info("select percent desired");
        p= PropertyHelper.loadData();
        String other= p.getProperty(dropdownValues);
        coverage.selectOtherStructure(other);
    }

    @And("verify percent applied is correct {string}")
    public void verifyPercentAppliedIsCorrect(String dropdownValues) throws IOException, InterruptedException {
        Log.info("verify percent applied is correct");
        p= PropertyHelper.loadData();
        String other= p.getProperty(dropdownValues);
        coverage.correctPercentApplied(other);
    }

    @Then("select edit Other structure option")
    public void selectEditOtherStructureOption() throws InterruptedException {
        Log.info("select edit other structure");
        coverage.editMenuCoverage("Other structure");
    }
}
