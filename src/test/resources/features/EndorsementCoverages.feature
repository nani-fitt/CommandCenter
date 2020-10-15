@TestValidation
@EndorsementSection
Feature: Verify endorsement coverage section

  @AddEndorsement
  Scenario Outline: verify added endorsement desired
    Given user Sign In with correct credentials "<username>" and "<password>"
    When   enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select add endorsement button
    And   select Lock for edit
    And   select the endorsement desired "<endorsementNameA>"
    And   enter the data desired "<endorsementNameA>" "<endorsementNameValues>"
    When  click in Add button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed
    When  click on issue button
    Then  verify the issue is created

    Examples:
      | username | password |criteria  |endorsementNameA   |endorsementNameValues|status             |
      | email    | password |criteriaE |nameEndorsementAdd |endorsementNameV     |ApprovedEndorsement|

  @DeleteEndorsement
  Scenario Outline: verify deleted endorsement desired
    Given user Sign In with correct credentials "<username>" and "<password>"
    When   enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    And   select remove endorsement "<endorsementName>"
    And   select Lock for edit
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed
    When  click on issue button
    Then  verify the issue is created

    Examples:
      | username | password |criteria  |endorsementName |status             |
      | email    | password |criteriaE |nameEndorsementD|ApprovedEndorsement|

  Scenario Outline: verify added endorsement desired second time
    Given user Sign In with correct credentials "<username>" and "<password>"
    When   enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select add endorsement button
    And   select Lock for edit
    And   select the endorsement desired "<endorsementNameA>"
    And   enter the data desired "<endorsementNameA>" "<endorsementNameValues>"
    When  click in Add button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed
    When  click on issue button
    Then  verify the issue is created

    Examples:
      | username | password |criteria  |endorsementNameA    |endorsementNameValues|status             |
      | email    | password |criteriaE |nameEndorsementAdd1 |endorsementNameV1    |ApprovedEndorsement|









