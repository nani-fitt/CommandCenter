@TestValidation
@ActivityLog
Feature: Verify activity log functionality


  @ActivityLog
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