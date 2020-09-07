package StepsDefinitions;

import ClassBase.SignInPage;
import Utilities.Log;
import Utilities.PropertyHelper;
import Utilities.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Properties;

public class SignIn extends TestBase {


    SignInPage signin= new SignInPage(driver);
    Properties p;


    @When("enter email {string}")
    public void enterEmail(String Email) throws IOException, InterruptedException {
       Log.info("Enter email");
        p= PropertyHelper.loadData();
        String emailText= p.getProperty(Email);
        signin.enterEmail(emailText);
    }

    @And("enter password {string}")
    public void enterPassword(String Password) throws IOException, InterruptedException {
        Log.info("Enter password");
        p= PropertyHelper.loadData();
        String emailPass= p.getProperty(Password);
        signin.enterPassword(emailPass);
    }

    @Then("click on sign In button")
    public void clickOnSignInButton() throws InterruptedException {
       Log.info("Click on Sign In");
        signin.signIn();
    }

    @And("verify error message {string}")
    public void verifyErrorMessage(String errorMessage) throws IOException, InterruptedException {
        Log.info("Verify error message");
        p = PropertyHelper.loadData();
        String value= p.getProperty(errorMessage);
        signin.errorMessage(value);

    }

    @And("verify queue list displayed {string}")
    public void verifyQueueListDisplayed(String valueSelect) throws IOException, InterruptedException {
       Log.info("Verify list of queue");
        p = PropertyHelper.loadData();
        String value= p.getProperty(valueSelect);
        signin.verifyQueue();
    }

    @And("verify email field")
    public void verifyEmailField() throws InterruptedException {
        Log.info("Verify email field");
        signin.emailPresent();
    }

    @When("verify forgot password is displayed")
    public void verifyForgotPasswordIsDisplayed() throws InterruptedException {
        Log.info("Verify Forgot Password");
        signin.forgotPasswordDisplayed();
    }

    @And("select forgot password link")
    public void selectForgotPasswordLink() throws InterruptedException {
       Log.info("Select forgot password");
        signin.clickOnForgotPassword();
    }

    @Then("verify forgot password screen is displayed")
    public void verifyForgotPasswordScreenIsDisplayed() throws InterruptedException {
       Log.info("Verify forgot password email field");
        signin.emailPresent();
    }

    @And("click on Send confirmation button")
    public void clickOnSendConfirmationButton() throws InterruptedException {
        Log.info("Click on Send button");
        signin.confButtons();

    }
}
