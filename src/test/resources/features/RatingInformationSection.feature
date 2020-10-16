@TestValidation
@RatingInfo
Feature: Rating information section feature

  @RatingInfoSection
  Scenario Outline: Verify Rating information section is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   select rating information section queue
    When  verify rating information is displayed

    Examples:
      | username | password |nameQueue|index        |
      | email    | password |queu     |policyIndexSe|