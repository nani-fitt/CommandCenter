package ClassBase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

public class EndorsementPage {

    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Endorsements')]")
    WebElement endorHeader;

    public EndorsementPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyValue(String value) throws InterruptedException {
        Thread.sleep(5000);
        DetailsPolicyPage page = new DetailsPolicyPage(driver);
        if (page.insuranceInfo.size() > 1) {
            Optional<WebElement> correct = page.insuranceInfo.stream().filter((element) -> element.getText().equals(value))
                    .findFirst();
            return correct.isPresent();

        }
        return false;
    }

    public void verifyEndorsement(String endor) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(endorHeader.isDisplayed());
        boolean presentEndor= verifyValue(endor);
        if(presentEndor)
        {
            System.out.println("The endorsement is present");
        }else
            System.out.println("The endorsement isn't present");
    }

}

