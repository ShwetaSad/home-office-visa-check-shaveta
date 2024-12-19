package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class StartPage extends Utility {
    //startNowButton locatores and create method 'void clickStartNow()'

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Accept additional cookies\"]")
    WebElement clickonacceptcookies;

    @CacheLookup
    @FindBy(xpath = "//a[@class=\"gem-c-button govuk-button govuk-button--start\"]")
    WebElement startNowBtn;


    public void clickOnCookies() {
        clickOnElement(clickonacceptcookies);

    }

    public void clickOnStartNowBtn(){
        clickOnElement(startNowBtn);
}
}
