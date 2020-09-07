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
      When  select the Queue desired "<nameQueue>"
      And   select the policy desired "<policyNumber>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify insurance information are displayed "<policyNumber>"

      Examples:
        | username | password |policyNumber |nameQueue|
        | email    | password |policynumber |queu     |

    @EditInsuranceInformation
    Scenario Outline: Edit primary insurance without change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select the policy desired "<policyNumber>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      When  verify edit insurance screen are displayed
      Then  verify Save button is desable
      Then  verify primary insurance information are present

      Examples:
        | username | password |policyNumber |nameQueue|
        | email    | password |policynumber |queu     |

    @EditInsuranceInformationChangeData
    Scenario Outline: Edit primary insurance change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select the policy desired "<policyNumber>"
      Then  verify Details section is displayed
      And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit primary insurance information
      And   select Lock for edit
      When  verify edit insurance screen are displayed
      Then  edit the information desired "<firstName>" "<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the information is updated "<firstName>" "<email>" "<maritalStatus>" "<address>"

      Examples:
        | username | password |policyNumber |nameQueue|firstName|email|maritalStatus|address|
        | email    | password |policynumber |queu     | name    |mail |status       |addres |

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
      Then  edit the information desired "<firstName>" "<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the information error message

      Examples:
        | username | password |criteria     |firstName|email         |maritalStatus|address|
        | email    | password |policynumberS| name    |incorrectEmail|status       |addres |