package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DurationOfStayPage extends Utility {
    // nextStepButton, lessThanSixMonths, moreThanSixMonths locators and create methods
    //  'void selectLengthOfStay(String moreOrLess)' (Note: use switch statement for select moreOrLess stay)
    //  and 'void clickNextStepButton()'


    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-1\"]")
    WebElement staylongerThan6Months;


    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-0\"]")
    WebElement staylessThan6Months;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement clickContinue;



    public void intendedstaylongerThan6Months() {
        clickOnElement(staylongerThan6Months);

    }

    public void intendedstaylessThan6Months() {
        clickOnElement(staylessThan6Months);


    }

    public void ClickContinue(){
        clickOnElement(clickContinue);

    }

}

