package StepsDefinitions;

import ClassBase.DwellingPage;
import Utilities.Log;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DwellingSteps extends TestBase {
    DwellingPage dwelling = new DwellingPage(driver);

    @And("select dwelling section queue")
    public void selectDwellingSectionQueue() throws InterruptedException {
        Log.info("select dwelling section queue");
        dwelling.dwellingSection();
    }

    @When("verify dwelling information is displayed")
    public void verifyDwellingInformationIsDisplayed() throws InterruptedException {
        Log.info("verify dwelling information");
        dwelling.expandableListDwelling();
    }
}
