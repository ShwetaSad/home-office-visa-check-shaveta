@regression
  Feature: Counrtry Dropdown Feature

    Background: I am on homepage

    @sanity
    Scenario: Verify the following country available in country dropdown list.
    Given
      When I click on start button
      Then I can see following country into dropdown
        | albania                  |
        | bhutan                   |
        | british-protected-person |
        | haiti                    |
        | kazakhstan               |
        | mozambique               |
        | norway                   |
        | portugal                 |
        | russia                   |
        | zambia                   |