package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class ReasonForTravelPage extends Utility {
    //nextStepButton, reasonForVisitList locators and
    // create methods  'void selectReasonForVisit(String reason)'
    //  and  'void clickNextStepButton()'

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-0\"]")
    WebElement selectTourism;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-1\"]")
    WebElement selectWorkAcademicvistOrBusiness;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-4\"]")
    WebElement joinPartnerOrFamilyforLongStay;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement clickonContinue;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(@class,\"govuk-!-margin-bottom-6\")]")
    WebElement NoVisaText;



    public void clickOnTourismConitnue(){
        clickOnElement(clickonContinue);
        log.info("Clicking on Continue");

    }

    public String VerifyNoVisaRequiredText(){
        log.info(" No Visa Required Text");
        return getTextFromElement(NoVisaText);

    }

    public void selectReasonForVisit(String reason){
        if(reason =="Join partner or family for a long stay"){
            clickOnElement(joinPartnerOrFamilyforLongStay);
        } else if (reason=="Tourism or visiting family and friends") {
            clickOnElement(selectTourism);
        } else if (reason=="Work, academic visit or business") {
            clickOnElement(selectWorkAcademicvistOrBusiness);
        }else {
            System.out.println("Select an Option");
        }

    }

}
