package Utilities;

import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Eyes eyes;

    public void selectBrowser(String browser, String env, String hub) throws IOException {

        if (hub.equals("Not")) {
            if (browser.equalsIgnoreCase("Chrome")) {

                WebDriverManager.chromedriver().version("85.0.4183.83").setup();
                //System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                // options.addArguments("headless");
                options.addArguments("--disable-gpu");
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                iniciateEyes();

            } else if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions geoDisabled = new FirefoxOptions();
                geoDisabled.addPreference("geo.enabled", true);
                geoDisabled.addPreference("geo.provider.use_corelocation", true);
                geoDisabled.addPreference("geo.prompt.testing", true);
                geoDisabled.addPreference("geo.prompt.testing.allow", true);
                driver = new FirefoxDriver(geoDisabled);
                iniciateEyes();
            } else if (browser.equalsIgnoreCase("Safari")) {

                SafariOptions options = new SafariOptions();
                options.setUseTechnologyPreview(true);
                driver = new SafariDriver(options);
                iniciateEyes();
            }
              }
            else if (hub.equals("Yes") && browser.equals("Firefox")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(BrowserType.FIREFOX);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                }
                else if (hub.equals("Yes") && browser.equals("Chrome")){
                DesiredCapabilities capabilities= new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
            driver.navigate().to(env);

    }

    private static void iniciateEyes() throws IOException {
        eyes= new Eyes();
        Properties prop= new Properties();
        FileInputStream file= new FileInputStream("./src/properties/browser.properties");
        prop.load(file);

        String key= prop.getProperty("applitools.api.key");
        eyes.setApiKey(key);
    }

    public void validateWindows()
    {
        eyes.open(driver, "commandCenter",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        //  eyes.setMatchLevel(MatchLevel.EXACT);
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow();
        eyes.close();
    }
    public void validateElements(By locator)
    {
        eyes.open(driver, "commandCenter",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        //  eyes.setMatchLevel(MatchLevel.EXACT);
        eyes.checkElement(locator);
        eyes.close();
    }
    



}
