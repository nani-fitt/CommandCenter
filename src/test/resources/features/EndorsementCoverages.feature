@TestValidation
@EndorsementSection
Feature: Verify endorsement coverage section


  @ReviewEndorsementDisplayed
  Scenario Outline: verify endorsement displayed in the policy record
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  obtain all the endorsement displayed

    Examples:
      | username | password |criteria     |
      | email    | password |policyNumberC|