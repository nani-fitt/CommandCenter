@TestValidation
@ElasticSearch
Feature: verify Elastic Search functionality

  Background:


  @ElasticSearchPolicy
  Scenario Outline: Search by Policy correct data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    Then  verify the result displayed is correct "<criteria>"

    Examples:
      | username | password |criteria          |
      | email    | password |policynumberSearch|

  @ElasticSearchClaims
  Scenario Outline: Search by Claims correct data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select claims checkbook
    Then  verify the claims displayed is correct "<criteria>"

    Examples:
      | username | password |criteria     |
      | email    | password |policyclaims |

  @ElasticSearchInspectionCorrect
  Scenario Outline: Search by Inspection correct data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select Inspection checkbook
    Then  verify the inspection displayed is correct "<criteria>"

    Examples:
      | username | password |criteria         |
      | email    | password |policyinspection |

  @ElasticSearchPolicyIncorrect
  Scenario Outline: Search by Policy incorrect data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    Then  verify an error message is displayed

    Examples:
      | username | password |criteria     |
      | email    | password |policynumberI|

  @ElasticSearchClaimsIncorrect
  Scenario Outline: Search by Claims incorrect data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select claims checkbook
    Then  verify an error message is displayed

    Examples:
      | username | password |criteria      |
      | email    | password |policyclaimsI |

  @ElasticSearchInspectionIncorrect
  Scenario Outline: Search by Inspection incorrect data
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select Inspection checkbook
    Then  verify an error message is displayed

    Examples:
      | username | password |criteria          |
      | email    | password |policyinspectionI |

  @ElasticSearchSelectAll
  Scenario Outline: Incorrect data selecting all the criteria
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select Inspection checkbook
    When  select claims checkbook
    Then  verify all the option are displayed correctly

    Examples:
      | username | password |criteria     |
      | email    | password |incorrectDta |

  @ElasticSearchSelectAllCorrect
  Scenario Outline: Correct data selecting all the criteria
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  enter the criteria desired "<criteria>"
    When  select Inspection checkbook
    When  select claims checkbook
    Then  verify all the option are displayed correctly

    Examples:
      | username | password |criteria    |
      | email    | password |correctData |