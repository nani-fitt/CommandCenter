
@EndorsementSection
Feature: Verify endorsement coverage section


  @ReviewEndorsementDisplayed
  Scenario Outline: verify animal liability endorsement is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify endorsement desired is displayed "<endorsementName>"
    Then  select edit option endorsement"<endorsementName>"
    And   select Lock for edit endorsement "<endorsementName>"
    When  enter the values desired endorsement "<endorsementValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |endorsementName|status  |endorsementValues|
      | email    | password |policyNumberC|nameEndorsement|Approved|valuesEndorsement|