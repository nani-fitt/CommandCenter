@TestValidation
@ReportClaim
Feature: Report Claim section feature

  @ReportClaimCreation
  Scenario Outline: Verify report Claim section is displayed
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   select rating information section queue
    When  verify rating information is displayed
    And   select Report Claim button
    Then  verify Details section is displayed
    Then  verify report claim screen is displayed

    Examples:
      | username | password |nameQueue|index        |
      | email    | password |queu     |policyIndexSe|

  @ReportClaimOk
  Scenario Outline: Verify enter all the data correctly
    Given user Sign In with correct credentials "<username>" and "<password>"
    When  select the Queue desired "<nameQueue>"
    And   select first policy displayed "<index>"
    Then  verify Details section is displayed
    And   select rating information section queue
    When  verify rating information is displayed
    And   select Report Claim button
    Then  verify Details section is displayed
    When  enter the data for Report By section "<firstName>""<lastName>"
    And   enter the data for Loss Information section "<dateLoss>""<timeLoss>""<addres>""<city>""<state>""<zipCode>""<situation>""<damage>"
    And   select damages property "<propertyDame>"
    And   select liability "<liability>"
    And   select cause of loss "<causeLoss>"
    Then  enter the contact information desired "<firstNameC>""<lastNameC>""<phoneNumber>""<email>""<relationwithinsurance>"
    And   select other contact information
    Then  click on submit button
    And   verify the claims is created correctly "<firstNameC>"


    Examples:
      | username | password |nameQueue|index        |firstName|lastName|dateLoss|timeLoss|addres |city |state |zipCode|situation |damage |propertyDame |liability |causeLoss |firstNameC  |lastNameC      |phoneNumber   |email       |relationwithinsurance|
      | email    | password |queu     |policyIndexSe|nameC    | lastNC |  dateC |timeC   |addresC|cityC|stateC| zipC  |situationC| dameC |propDameC    |liabilityC|causeC    | nameContact|lastNameContact| numberContact|emailContact| relationContact     |
