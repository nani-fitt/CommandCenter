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
    public void verifyTheActivityWasCreated() {
        Log.info("verify activity log creation");
        activity.verifyCreation();
    }
}
