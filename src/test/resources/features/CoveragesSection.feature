@TestValidation
@CoverageSection
Feature: Verify coverage section


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
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |coveragesValues|message     |coverageName|
      | email    | password |policyNumberC|coveragesLess  |dwellingMess|nameCoverD  |

  @ChangeDwellingIncorrect
  Scenario Outline: Verify enter incorrect values dwelling field second validation
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |coveragesValues|message     |coverageName|
      | email    | password |policyNumberC|coveragesBigger|dwellingMess|nameCoverD  |

  @ChangeDwellingCorrect
  Scenario Outline: Verify enter correct dwelling values
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the values desired "<coveragesValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify Personal Property and Additional Living values "<coveragesValues>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |coveragesValues|status  |coverageName|
      | email    | password |policyNumberC|coveragesGood  |Approved|nameCoverD  |

  @ChangeOtherStructureCorrect
  Scenario Outline: Select other structure value percent to apply
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  select the percent to apply "<dropdownValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify percent applied is correct "<dropdownValues>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |dropdownValues|status  |coverageName|
      | email    | password |policyNumberC|percentSelect |Approved|nameCoverO  |

  @ChangePersonalPropertyLess
  Scenario Outline: Select personal property value percent to apply less than 20
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the personal property percent to apply "<personalP>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |personalP      |message     |coverageName|
      | email    | password |policyNumberC|percentPerLess |dwellingMess|nameCoverPP |

  @ChangePersonalPropertyMore
  Scenario Outline: Select personal property value percent bigger than 70
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the personal property percent to apply "<personalP>"
    And   click on save coverage button
    Then  verify the information coverage error message "<message>"

    Examples:
      | username | password |criteria     |personalP       |message     |coverageName|
      | email    | password |policyNumberC|percentPerBigger|dwellingMess|nameCoverPP |

  @ChangePersonalPropertyCorrect
  Scenario Outline: Select personal property value percent between 20 and 70
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  enter the personal property percent to apply "<personalP>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify percent applied is correct personal property "<personalP>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |personalP  |status  |coverageName|
      | email    | password |policyNumberC|percentPerC|Approved|nameCoverPP |

  @ChangeAdditionalCorrect
  Scenario Outline: Select additional living expense value percent to apply
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  select the percent to apply "<dropdownValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify percent applied is correct additional living "<dropdownValues>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |dropdownValues|status  |coverageName|
      | email    | password |policyNumberC|percentSelectA|Approved|nameCoverAL |

  @ChangePersonalLiability
  Scenario Outline: Select personal liability desired
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  select the percent to apply "<dropdownValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |dropdownValues|status  |coverageName|
      | email    | password |policyNumberC|liability     |Approved|nameCoverPL |

  @ChangeMedicalPayment
  Scenario Outline: Select personal liability desired
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    And   select the policy desired "<criteria>"
    Then  verify Coverage section is displayed
    And   select expandable list for coverage
    Then  select edit option coverage "<coverageName>"
    And   select Lock for edit coverage "<coverageName>"
    When  select the percent to apply "<dropdownValues>"
    And   click on save coverage button
    Then  verify status is updated "<status>"
    And   verify sticky bar is displayed

    Examples:
      | username | password |criteria     |dropdownValues|status  |coverageName|
      | email    | password |policyNumberC|medical       |Approved|nameCoverMP |