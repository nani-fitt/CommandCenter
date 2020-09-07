package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public void selectBrowser(String browser, String env) {

            if (browser.equalsIgnoreCase("Chrome")) {

                WebDriverManager.chromedriver().version("85.0.4183.83").setup();
                //System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                // options.addArguments("headless");
                options.addArguments("--disable-gpu");
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);

            }
             else if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions geoDisabled = new FirefoxOptions();
                geoDisabled.addPreference("geo.enabled", true);
                geoDisabled.addPreference("geo.provider.use_corelocation", true);
                geoDisabled.addPreference("geo.prompt.testing", true);
                geoDisabled.addPreference("geo.prompt.testing.allow", true);
                driver = new FirefoxDriver(geoDisabled);
            }
            else if (browser.equalsIgnoreCase("Safari")) {

                SafariOptions options=new SafariOptions();
                options.setUseTechnologyPreview(true);
                driver = new SafariDriver(options);
            }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		driver.navigate().to(env);
    }

}
