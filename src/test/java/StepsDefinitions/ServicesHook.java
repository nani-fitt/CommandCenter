package StepsDefinitions;

import Utilities.TestBase;
import io.cucumber.core.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServicesHook {

    TestBase testBase;
    public Properties prop;


    @Before()
    public void initializeTest() throws IOException {

        testBase = new TestBase();
        prop= new Properties();
        FileInputStream file= new FileInputStream("./src/properties/browser.properties");
        prop.load(file);
        String browsers= prop.getProperty("browser");
        String env= prop.getProperty("environment");
        String hub= prop.getProperty("Hub");


        if(env.equals("demo"))
        {
            String urlDemo= prop.getProperty("demo");
            testBase.selectBrowser(browsers, urlDemo,hub);
        }else
        {
            String urlDev= prop.getProperty("dev");
            testBase.selectBrowser(browsers, urlDev,hub);
        }


    }

    @After()
    public void endTest(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {

            System.out.println("Scenario failed");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            System.out.println("Name of the scenario"+ " " + screenshotName);
            TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShot/" + screenshotName + ".png"));
            System.out.println("the Screenshot is taken");
        }

        TestBase.driver.quit();
    }

}
