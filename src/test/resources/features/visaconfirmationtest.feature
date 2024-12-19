@regression
Feature: Visa Confirmation

  @smoke
  Scenario: 1.anAustralianCominToUKForTourism.
    Given I am on Homepage
    When I Click on start button
    And Select a Nationality 'Australia'
    And Click on Continue button
    And Select reason 'Tourism or visiting family and friends'
    And Click on ContinueAgain button
    Then I verify result 'You will not need a visa to come to the UK'


@sanity
  Scenario: A Chilean Coming To The UK For Work And Plans On Staying For Longer Than Six Months.
    Given I am on Homepage
    And I Click on start button
    And Select a Nationality "Chile"
    And  Click on Continue button
    And Select reason "Work, academic visit or business"
    And Click on ContinueAgain button
    And Select intendent to stay for longer than six months
    And I Click on continuelink
    And Select have planning to work for "Health and care professiona"
    And I click on continueagain Link
    Then I verify the result You need a visa to work in health and care

  Scenario: A Columbian National Coming To The UK To Join A Partner For A Long Stay They Do Have An
  Article10Or20Card
    Given I am on Homepage
    And I Click on start button
    And Select a Nationality "Colombia"
    And Click on Continue button
    And Select reason "Join partner or family for a long stay"
    And Click on ContinueAgain button
    And Select state My partner of family member have uk immigration status "yes"
    And Click on Continuenext button
    Then verify result You’ll need a visa to join your family or partner in the UK

