package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FamilyImigarationStatusPage extends Utility {
    // nextStepButton, yes, no locators and create methods 'void selectImmigrationStatus(String status)'
    //  (Note: Use switch statement for select immigration status) and 'void clickNextStepButton()'

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-0\"]")
    WebElement yes;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"response-1\"]")
    WebElement No;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement nextBtn;



    public void selectImmigrationStatus(String status){
       /* if (status=="Yes"){
            clickOnElement(yes);
        }else {
            clickOnElement(No);
        }

        */
        switch (status){
            case "Yes":
                clickOnElement(yes);
                break;
            case "No":
                clickOnElement(No);
                break;
            default:
                System.out.println("Select Something");
                break;

        }
    }

    public void clickNextStepButton(){
        clickOnElement(nextBtn);

    }
}
