@TestValidation
@ActivityLog
Feature: Verify activity log functionality


  @ActivityLogCreated
  Scenario Outline: Verify Activity Log is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   verify activity log is displayed
    When  click on activity log button
    And   enter the values desired "<LogType>" "<VisibilityType>" "<Description>"
    And   click on save activity button
    Then  verify the activity was created


    Examples:
      | username | password |nameQueue|index        |LogType |VisibilityType |Description |
      | email    | password |queu     |policyIndexSe|LogTypeS|VisibilityTypeS|DescriptionS|


  @AddDocuments
  Scenario Outline: Verify Add Documents on the policy
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   verify documents is displayed
    When  click on add documents button
    And   enter the values desired "<Type>" "<VisibilityType>"
    Then  click on file option and select the documents desired
    Then  verify documents is displayed on the list


    Examples:
      | username | password |nameQueue|index        |Type   |VisibilityType |
      | email    | password |queu     |policyIndexSe|typeDoc|VisibilityTypeD|