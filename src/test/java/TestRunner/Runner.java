package TestRunner;


import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", glue = { "StepsDefinitions" }
        , plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json"}
        , tags = {"@ChangeDwellingCorrect"}) // or


//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

public class Runner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeTest(alwaysRun = true)
    public void setUpClass() throws Exception {
        //Log.startLog("******TESTING STARTING***********");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }
    //incovationCount
    //@Parameters("BrowserType")
    @Test(dataProvider = "feature")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());

    }

    @DataProvider // (parallel=true)
    public Object[][] feature() {

        return testNGCucumberRunner.provideScenarios();

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();

    }
}
