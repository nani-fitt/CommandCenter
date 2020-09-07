@SignIn
  Feature: SignIn functionality

    @SignInCorrect
    Scenario Outline: Sign In successful
      When enter email "<Email>"
      And  enter password "<Password>"
      Then click on sign In button
      And  verify queue list displayed "<valueSelect>"
      Examples:
        | Email | Password |valueSelect |
        | email | password |value       |

    @SignInInCorrect
    Scenario Outline: Sign In incorrect password
      When enter email "<Email>"
      And  enter password "<Password>"
      Then click on sign In button
      And  verify error message "<errorMessage>"
      Examples:
        | Email | Password      |errorMessage|
        | email | passIncorrect | errormess  |

    @SignInInCorrectEmail
    Scenario Outline: Sign In incorrect password
      When enter email "<Email>"
      And  enter password "<Password>"
      Then click on sign In button
      And  verify email field
      Examples:
        | Email          | Password |
        | emailIncorrect | password |

    @SignInForgotPassword
    Scenario Outline: Forgot password screen
      When verify forgot password is displayed
      And  select forgot password link
      Then verify forgot password screen is displayed
      When enter email "<Email>"
      And  click on Send confirmation button
      Examples:
        | Email      |
        | emailForgot|
