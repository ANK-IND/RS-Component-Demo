Feature: RS Components user Registration

  User should be able to Login by
  Login from Homepage
  Login from CheckoutPage

  @Login
  Scenario Outline: Login from Homepage
    Given User is on RS Component HomePage
    When User clicks on Login link
    Then Verify user is navigated to Login Page
    And User enter <Username> and <password> for Login
    Then Verify user is Logged In successfully

    Examples:
      | Username | password  |
      | RSDemo   | Sample-11 |

