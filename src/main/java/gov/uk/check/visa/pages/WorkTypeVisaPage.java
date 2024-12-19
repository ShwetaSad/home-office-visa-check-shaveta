package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class WorkTypeVisaPage extends Utility {
    //nextStepButton, selectJobtypeList locators and create methods  'void selectJobType(String job)'
    //  and 'void clickNextStepButton()'

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-0\"]")
    WebElement HealthandCareProfessional;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement nextStep;


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()=\"You need a visa to work in health and care\"]")
    WebElement needVisaText;


    public void selectJobTypes(String job) {
        if (job == "Health and care professional") {
            clickOnElement(HealthandCareProfessional);
            log.info("select Job Types");
        }

    }
    public void clickOnnextStep(){
        clickOnElement(nextStep);
        log.info("Click on next Step");

    }

    public String NeedVisaText(){
        log.info("Verify Need Visa Text");

        return getTextFromElement(needVisaText);
    }

}

