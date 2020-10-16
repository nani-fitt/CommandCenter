package StepsDefinitions;

import ClassBase.BillingSectionPage;
import Utilities.Log;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class BillingSectionSteps extends TestBase {

    BillingSectionPage billing= new BillingSectionPage(driver);


    @And("select billing section queue")
    public void selectBillingSectionQueue() throws InterruptedException {
        Log.info("select billing information");
        billing.billingSection();
    }

    @When("verify the insurance information is displayed")
    public void verifyTheInsuranceInformationIsDisplayed() throws InterruptedException {
        Log.info("verify the insurance information is displayed");
        billing.expandableListBilling();
    }
}
