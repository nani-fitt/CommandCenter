@TestValidation
@Dwelling
Feature: Billing section feature

  @DwellingSection
  Scenario Outline: Verify Dwelling section is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   select dwelling section queue
    When  verify dwelling information is displayed

    Examples:
      | username | password |nameQueue|index        |
      | email    | password |queu     |policyIndexSe|