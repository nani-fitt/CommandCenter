package StepsDefinitions;

import ClassBase.RatingInfoPage;
import Utilities.Log;
import Utilities.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class RatingInfoSteps extends TestBase {
    RatingInfoPage rating = new RatingInfoPage(driver);

    @And("select rating information section queue")
    public void selectRatingInformationSectionQueue() throws InterruptedException {
        Log.info("select rating information section");
        rating.ratingSection();
    }

    @When("verify rating information is displayed")
    public void verifyRatingInformationIsDisplayed() throws InterruptedException {
        rating.expandableListRating();
    }
}
