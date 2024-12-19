package gov.uk.check.visa.steps;

import gov.uk.check.visa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VisaConfirmationSteps {
    @Given("I am on Homepage")
    public void iAmOnHomepage() {

    }

    @When("I Click on start button")
    public void iClickOnStartButton() {
        new StartPage().clickOnStartNowBtn();
    }

    @And("Click on Continue button")
    public void clickOnContinueButton() {
        new SelectNationalityPage().clickOnContinue();

    }

    @And("Select reason {string}")
    public void selectReasonTourism(String Reason) {
        new ReasonForTravelPage().selectReasonForVisit(Reason);
    }

    @Then("I verify result {string}")
    public void iVerifyResultYouWillNotNeedAVisaToComeToTheUK(String result) {
       // Assert.assertEquals(new ReasonForTravelPage().VerifyNoVisaRequiredText(),result, "Message Not Displayed");
    }

    @And("Select a Nationality {string}")
    public void selectANationalityAustralia(String nationality) {
        new SelectNationalityPage().SelectNatinalityFromDropsown(nationality);
    }

    @And("Click on ContinueAgain button")
    public void clickOnContinueAgainButton() {
        new ReasonForTravelPage().clickOnTourismConitnue();
    }

    @And("Select intendent to stay for longer than six months")
    public void selectIntendentToStayForLongerThanSixMonths() {
        new DurationOfStayPage().intendedstaylongerThan6Months();
    }

    @And("I Click on continuelink")
    public void iClickOnContinuelink() {
        new DurationOfStayPage().ClickContinue();
    }

    @And("Select have planning to work for {string}")
    public void selectHavePlanningToWorkForHealthAndCareProfessional(String jobtype) {
        new WorkTypeVisaPage().selectJobTypes(jobtype);
    }

    @And("I click on continueagain Link")
    public void iClickOnContinueagainLink() {
        new WorkTypeVisaPage().clickOnnextStep();
    }

    @Then("I verify the result You need a visa to work in health and care")
    public void iVerifyTheResultYouNeedAVisaToWorkInHealthAndCare() {
      //  Assert.assertEquals(new ReasonForTravelPage().VerifyNoVisaRequiredText(),"You need a visa to work in health and care", "Wrong Text");
    }

    @And("Select state My partner of family member have uk immigration status {string}")
    public void selectStateMyPartnerOfFamilyMemberHaveUkImmigrationStatusYes() {
        new FamilyImigarationStatusPage().selectImmigrationStatus("Yes");
    }

    @And("Click on Continuenext button")
    public void clickOnContinuenextButton() {
        new FamilyImigarationStatusPage().clickNextStepButton();
    }

    @Then("verify result You’ll need a visa to join your family or partner in the UK")
    public void verifyResultYouLlNeedAVisaToJoinYourFamilyOrPartnerInTheUK() {

    }
}
