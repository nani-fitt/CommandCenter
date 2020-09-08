@PolicyDetails
  Feature: Verify policy details are displayed

    Background:



       @ViewPolicyOption
      Scenario Outline: Policy record screen displayed
        Given user Sign In with correct credentials "<username>" and "<password>"
        When  select the Queue desired "<nameQueue>"
        And   select the policy desired "<policyNumber>"
        Then  verify Details section is displayed
        And   verify Coverage section is displayed

        Examples:
          | username | password |policyNumber |nameQueue|
          | email    | password |policynumber |queu     |

    @ViewPolicyDetails
    Scenario Outline: Details screen displayed
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify insurance information are displayed "<criteria>"

      Examples:
        | username | password |criteria      |
        | email    | password |policynumberSe|

    @EditInsuranceInformation
    Scenario Outline: Edit primary insurance without change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  verify Save button is desable
      Then  verify primary insurance information are present

      Examples:
        | username | password |criteria       |
        | email    | password |policynumberSe |

    @EditInsuranceInformationChangeData
    Scenario Outline: Edit primary insurance change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  edit the information desired "<firstName>" "<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the information is updated "<email>" "<maritalStatus>" "<address>"
      And   verify Pending Change status is displayed

      Examples:
        | username | password |criteria        |firstName  |email|maritalStatus|address|
        | email    | password |policynumberSe1 |name       |mail |status       |addres |

    @EditInsuranceInfoIncorrectEmail
    Scenario Outline: Edit primary insurance with incorrect email
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  edit the information desired "<email>"
      And   click on save button
      Then  verify the information error message

      Examples:
        | username | password |criteria     |email         |
        | email    | password |policynumberS|incorrectEmail|

    @AddSecondaryInsurance
    Scenario Outline: Add secondary insurance
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select Add insurance button
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  enter the information desired "<firstName>" "<lastName>" "<phoneNumber>" "<dateBirth>" "<city>" "<postal>" "<state>""<county>""<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the secondary Insurance is displayed
      And   verify Pending Change status is displayed

      Examples:
        | username | password |criteria     |firstName|lastName|phoneNumber|dateBirth |city|state|county|postal|email   |maritalStatus   |address   |
        | email    | password |policynumberS| nameadd |lastName|phone      |datebirth |city|state|county|postal|emailadd|maritalStatusadd|addressadd|

    @EditInsuranceInformationApproved
    Scenario Outline: Edit primary insurance change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  edit the information desired "<firstName>" "<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the information is updated "<email>" "<maritalStatus>" "<address>"
      And   verify Pending Change status is displayed
      When  select approve button
      And   verify Approved status is displayed


      Examples:
        | username | password |criteria        |firstName  |email|maritalStatus|address|
        | email    | password |policynumberSe1 |name       |mail |status       |addres |