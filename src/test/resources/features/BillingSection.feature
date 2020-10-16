@TestValidation
  @Billing
  Feature: Billing section feature

    @BillingSection
    Scenario Outline: Verify billing is displayed
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select first policy displayed "<index>"
      Then  verify Details section is displayed
      And   select billing section queue
      When  verify the insurance information is displayed

      Examples:
        | username | password |nameQueue|index        |
        | email    | password |queu     |policyIndexSe|