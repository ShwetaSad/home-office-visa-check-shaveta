package gov.uk.check.visa.pages;

import gov.uk.check.visa.utlities.Utility;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SelectNationalityPage extends Utility {
    //-nationalityDropDownList, nextStepButton locators and
    // create methods  'void selectNationality(String nationality)'
    //  and 'void clickNextStepButton()'

    @CacheLookup
    @FindBy(xpath = "//select[@id ='response']")
    WebElement nationalityDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement continueBtn;


    public void SelectNatinalityFromDropsown(String Nationality) {
        selectByVisibleTextFromDropDown(nationalityDropdown, Nationality);

    }


    public void clickOnContinue() {
        clickOnElement(continueBtn);


    }
    public void isCountryListAvailableInDropdown(DataTable dataTable) {

        Select dropdown = new Select(nationalityDropdown);

        // Extract the list of expected country values from the feature file
        List<String> expectedCountries = dataTable.asList();

        // Retrieve all options from the dropdown
        List<WebElement> actualOptions = dropdown.getOptions();

        // Verify each expected country exists in the dropdown
        for (String country : expectedCountries) {
            boolean isCountryPresent = actualOptions.stream()
                    .anyMatch(option -> option.getText().equalsIgnoreCase(country));
            if (!isCountryPresent)
                System.out.println("Country '" + country + "' not found in the dropdown!");

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(isCountryPresent, "Country '" + country + "' not found in the dropdown!");
            softAssert.assertAll();

        }
    }
}
