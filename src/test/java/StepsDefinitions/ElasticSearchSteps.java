package StepsDefinitions;

import ClassBase.ElasticSearchPage;

import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class ElasticSearchSteps extends TestBase {
    
     ElasticSearchPage search= new ElasticSearchPage(driver);
     Properties p;

    @When("select claims checkbook")
    public void selectClaimsCheckbook() throws InterruptedException {
        Log.info("Select Claims");
        search.selectPolicyCheck();
        Thread.sleep(2000);
        search.selectClaimsCheck();

    }

    @When("select Inspection checkbook")
    public void selectInspectionCheckbook() throws InterruptedException {
        Log.info("Select Inspection");
        search.selectPolicyCheck();
        Thread.sleep(2000);
        search.selectInspectionCheck();

    }
    @Then("verify an error message is displayed")
    public void verifyAnErrorMessageIsDisplayed() throws IOException, InterruptedException {
        Log.info("Verify an error message is displayed");
        p= PropertyHelper.loadData();
        String message= p.getProperty("errorMessage");
        search.errorMessage(message);

    }

    @Then("verify the result displayed is correct {string}")
    public void verifyTheResultDisplayedIsCorrect(String criteria) throws IOException, InterruptedException {
        Log.info("Verify the result displayed is correct");
        p= PropertyHelper.loadData();
        String policy= p.getProperty(criteria);
        search.verifyResultPolicy(policy);
        validateWindows();
    }

    @Then("verify the claims displayed is correct {string}")
    public void verifyTheClaimsDisplayedIsCorrect(String criteria) throws IOException, InterruptedException {
        Log.info("Verify claims displayed");
        p= PropertyHelper.loadData();
        String claims= p.getProperty(criteria);
        search.verifyResultClaims(claims);
        validateWindows();
    }

    @Then("verify the inspection displayed is correct {string}")
    public void verifyTheInspectionDisplayedIsCorrect(String criteria) throws IOException, InterruptedException {
       Log.info("Verify inspection displayed");
        p= PropertyHelper.loadData();
        String inspection= p.getProperty(criteria);
        search.verifyResultInspection(inspection);

    }

    @Then("verify all the option are displayed correctly")
    public void verifyAllTheOptionAreDisplayedCorrectly() throws InterruptedException {
        Log.info("Verify all the option are displayed");
         search.verifyAllResult();
         validateWindows();
    }

}
