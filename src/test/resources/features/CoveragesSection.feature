@TestValidation
@CoverageSection
Feature: Verify coverage section

  Background:


  @ViewPolicyCoverage
  Scenario Outline: Coverage section is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  verify all the coverage section are present

    Examples:
      | username | password |criteria     |
      | email    | password |policyNumberC|

  @ChangeDwellingIncorrectValues
  Scenario Outline: Verify enter incorrect values dwelling field
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit Dwelling option
    And   select Lock for edit
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |coveragesValues|message     |
      | email    | password |policyNumberC|coveragesLess  |dwellingMess|

  @ChangeDwellingIncorrect
  Scenario Outline: Verify enter incorrect values dwelling field second validation
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit Dwelling option
    And   select Lock for edit
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |coveragesValues|message     |
      | email    | password |policyNumberC|coveragesBigger|dwellingMess|

  @ChangeDwellingCorrect
  Scenario Outline: Verify enter correct dwelling values
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit Dwelling option
    And   select Lock for edit
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify Personal Property and Additional Living values "<coveragesValues>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |coveragesValues|status  |
      | email    | password |policyNumberC|coveragesGood  |Approved|

  @ChangeOtherStructureCorrect
  Scenario Outline: Select other structure value percent to apply
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit Other structure option
    And   select Lock for edit
    When  select the percent to apply "<dropdownValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify percent applied is correct "<dropdownValues>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |dropdownValues|status  |
      | email    | password |policyNumberC|percentSelect |Approved|