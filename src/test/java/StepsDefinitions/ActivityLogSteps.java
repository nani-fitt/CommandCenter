package StepsDefinitions;

import ClassBase.ActivityLogPage;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class ActivityLogSteps extends TestBase {

    ActivityLogPage activity= new ActivityLogPage(driver);
    Properties p;

    @And("verify activity log is displayed")
    public void verifyActivityLogIsDisplayed() throws InterruptedException {
        Log.info("verify activity log is displayed");
        activity.activityDisplayed();
    }

    @When("click on activity log button")
    public void clickOnActivityLogButton() throws InterruptedException {
        Log.info("click on activity log");
        activity.clickAddActivity();
    }

    @And("enter the values desired {string} {string} {string}")
    public void enterTheValuesDesired(String LogType, String VisibilityType, String Description) throws IOException, InterruptedException {
        Log.info("select and enter the data desired");
        p= PropertyHelper.loadData();
        String log= p.getProperty(LogType);
        String visibility= p.getProperty(VisibilityType);
        String descp= p.getProperty(Description);
        activity.selectElementsActivityLogType(log);
        activity.selectElementsActivityVisible(visibility);
        activity.enterDescription(descp);
    }

    @And("click on save activity button")
    public void clickOnSaveActivityButton() throws InterruptedException {
        Log.info("click on save activity button");
        activity.clickSaveButtonActivity();
    }

    @Then("verify the activity was created")
    public void verifyTheActivityWasCreated() throws InterruptedException {
        Log.info("verify activity log creation");
        activity.verifyCreation();
    }

    @And("verify documents is displayed")
    public void verifyDocumentsIsDisplayed() throws InterruptedException {
        Log.info("verify documents is displayed");
        activity.activityDoc();

    }

    @When("click on add documents button")
    public void clickOnAddDocumentsButton() throws InterruptedException {
        Log.info("click on add documents icon");
        activity.clickAddDoc();
    }

    @And("enter the values desired {string} {string}")
    public void enterTheValuesDesired(String Type, String VisibilityType) throws InterruptedException, IOException {
        Log.info("enter the values desired");
        p= PropertyHelper.loadData();
        String log= p.getProperty(Type);
        String visibility= p.getProperty(VisibilityType);
        activity.selectDocType(log);
        activity.selectDocTypeVisible(visibility);

    }

    @Then("click on file option and select the documents desired")
    public void clickOnFileOptionAndSelectTheDocumentsDesired() throws InterruptedException {
        Log.info("upload file desired");
        activity.selectDoc();
    }

    @Then("verify documents is displayed on the list")
    public void verifyDocumentsIsDisplayedOnTheList() throws InterruptedException {
        Log.info("verify the documents are displayed");
        activity.checkDoc();

    }
}
