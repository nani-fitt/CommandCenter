package ClassBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EndorsementPage {

    WebDriver driver;

    public EndorsementPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}

