@TestValidation
@PolicyDetails
  Feature: Verify policy details are displayed



    @ViewPolicyDetails
    Scenario Outline: Details screen displayed
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      Then  verify insurance information are displayed "<criteria>"

      Examples:
        | username | password |criteria      |
        | email    | password |policyNumberSe|

    @EditInsuranceInformation
    Scenario Outline: Edit primary insurance without change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select first policy displayed "<index>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit information "<editButtonOption>"
      And   select Lock for edit details "<editButtonOption>"
      When  verify edit insurance screen are displayed
      Then  verify Save button is disable

      Examples:
        | username | password |nameQueue|index      |editButtonOption|
        | email    | password |queu     |policyIndex|editSelection   |

    @EditInsuranceInformationChangeData
    Scenario Outline: Edit primary insurance change any information
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select first policy displayed "<index>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit information "<editButtonOption>"
      And   select Lock for edit details "<editButtonOption>"
      When  verify edit insurance screen are displayed
      Then  edit the information desired "<firstName>" "<email>" "<maritalStatus>" "<address>"
      And   click on save button
      Then  verify the information is updated "<email>" "<maritalStatus>" "<address>"
      Then  verify status is updated "<status>"
      And   verify sticky bar is displayed
      When  click on issue button
      Then  verify the issue is created

      Examples:
        | username | password |nameQueue  |index      |editButtonOption|firstName  |email|maritalStatus|address|status  |
        | email    | password |queu       |policyIndex|editSelection   |name       |mail |status       |addres |Approved|

    @EditInsuranceInfoIncorrectDateBirth
    Scenario Outline: Edit primary insurance with incorrect date of birth
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  enter the criteria desired "<criteria>"
      And   select the policy desired "<criteria>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      Then  verify primary insurance information are present
      And   select edit information "<editButtonOption>"
      And   select Lock for edit details "<editButtonOption>"
      When  verify edit insurance screen are displayed
      Then  edit the date of birth "<dateBirth>"
      Then  verify the information error message "<message>"

      Examples:
        | username | password |criteria          |editButtonOption|dateBirth     |message      |
        | email    | password |policyNumberChange|editSelection   |incorrectBirth|errorMessageB|

    @AddSecondaryInsurance
    Scenario Outline: Add secondary insurance
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select first policy displayed "<index>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      And   select Add insurance button
      And   select Lock for edit details "<editButtonOption>"
      When  verify edit insurance screen are displayed
      Then  enter the information desired "<firstName>""<lastName>""<phoneNumber>""<dateBirth>""<city>""<postal>""<state>""<county>""<email>""<maritalStatus>""<address>"
      And   click on save add insurance button
      Then  verify status is updated "<status>"
      And   verify sticky bar is displayed
      When  click on issue button
      Then  verify the issue is created

      Examples:
        | username | password |nameQueue |index      |editButtonOption|firstName|lastName|phoneNumber|dateBirth |city|postal|state|county|email    |maritalStatus   |address    |status             |
        | email    | password |queu      |policyIndex|editSelection   |nameInsu |lastName|phone      |dateBirth |city|postal|state|county|emailInsu|maritalStatus   |addressInsu|statusNewInsurance |

    @AddAdditionalInterest
    Scenario Outline: Add additional Interest
      Given user Sign In with correct credentials "<username>" and "<password>"
      When  select the Queue desired "<nameQueue>"
      And   select first policy displayed "<index>"
      Then  verify Details section is displayed
    #  And   select expandable list for details
      Then  verify primary insurance information are present
      And   select Add additional interest button
      And   select Lock for edit details "<editButtonOption>"
      When  verify additional interest screen are displayed
      Then  enter additional interest information "<firstName>""<lastName>""<loanNumber>""<institutionName>""<address>""<city>""<postal>"
      And   click on save button interest
      Then  verify status is updated "<status>"
      And   verify sticky bar is displayed
      When  click on issue button
      Then  verify the issue is created

      Examples:
        | username | password |status   |nameQueue |index      |firstName |lastName  |loanNumber|institutionName|address  |city  |postal  |editButtonOption|
        | email    | password |Approved |queu      |policyIndex|nameInsu  |lastNameIn|loanNumber|institution    |addresInt|cityIn|postalIn|editSelectionA  |

   # @EditAdditionalInterest
   # Scenario Outline: Edit additional Interest
   #   Given user Sign In with correct credentials "<username>" and "<password>"
   #   When  enter the criteria desired "<criteria>"
   #   And   select the policy desired "<criteria>"
   #   Then  verify Details section is displayed
   #   And   select expandable list for details
   #   Then  verify primary insurance information are present
   #   And   select edit information "<editButtonOption>"
   #   And   select Lock for edit
   #   When  verify additional interest screen are displayed
   #   Then  edit the additional information desired "<lastName>""<loanNumber>""<institutionName>"
   #   And   click on save button interest
   #   Then  verify status is updated "<status>"

   #   Examples:
   #     | username | password |status   |criteria    |editButtonOption|lastName  |loanNumber|institutionName|
   #     | email    | password |Approved |policyNumber|editSelectionA  |lastNameIn|loanNumber|institution    |