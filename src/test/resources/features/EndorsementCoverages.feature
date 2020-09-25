
@EndorsementSection
Feature: Verify endorsement coverage section


  @ReviewEndorsement
  Scenario Outline: edit  additional residence endorsement
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify endorsement desired is displayed "<endorsementName>"
    Then  select edit option endorsement"<endorsementName>"
    And   select Lock for edit endorsement "<endorsementName>"
    When  enter the values desired endorsement "<endorsementValues>"
    And   click on save endorsement button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |endorsementName |status  |endorsementValues |
      | email    | password |policyNumberE|nameEndorsementA|Approved|valuesEndorsementA|

  @ReviewEndorsementFraud
  Scenario Outline: edit fraud protection endorsement
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify endorsement desired is displayed "<endorsementName>"
    Then  select edit option endorsement"<endorsementName>"
    And   select Lock for edit endorsement "<endorsementName>"
    When  enter the values desired endorsement "<endorsementValues>"
    And   click on save endorsement button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |endorsementName |status  |endorsementValues |
      | email    | password |policyNumberE|nameEndorsementF|Approved|valuesEndorsementF|

  @ReviewEndorsementGuard
  Scenario Outline: edit inflation guard endorsement
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify endorsement desired is displayed "<endorsementName>"
    Then  select edit option endorsement"<endorsementName>"
    And   select Lock for edit endorsement "<endorsementName>"
    When  enter the values desired endorsement "<endorsementValues>"
    And   click on save endorsement button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |endorsementName |status  |endorsementValues |
      | email    | password |policyNumberE|nameEndorsementI|Approved|valuesEndorsementI|

  @DeleteEndorsement
  Scenario Outline: verify deleted endorsement desired
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify endorsement desired is displayed "<endorsementName>"
    And   select remove endorsement "<endorsementName>"
    And   select Lock for edit endorsement "<endorsementName>"
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed
    When  click on issue button
    Then  verify the issue is created

    Examples:
      | username | password |nameQueue|index      |endorsementName |status             |
      | email    | password |queu     |policyIndex|nameEndorsementD|ApprovedEndorsement|