package StepsDefinitions;

import ClassBase.EndorsementPage;
import Utilities.Log;
import Utilities.TestBase;
import io.cucumber.java.en.Then;

public class EndorsementSteps extends TestBase {

    EndorsementPage endorsement= new EndorsementPage(driver);

    @Then("verify endorsement desired is displayed {string}")
    public void verifyEndorsementDesiredIsDisplayed(String nameEndorsement) {
        Log.info("Verify endorsement is displayed");
    }
}
