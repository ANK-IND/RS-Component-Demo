Feature: Product Checkout option in RS Component Web

  User should be able to checkout using the following options
  Register and Checkout
  Checkout and Login

  @Register&Checkout
  Scenario: Register as a new user and checkout

    Given User is on RS Component HomePage
    When User clicks on Register links for Registration
    Then Verify user navigation to Registration page
    And User enter details for Registration
      | Username | Password  | RetypePwd | First_name | Surname | Email            | Job_Title | Phone       | Title | Role | Hear_About |
      | Demo     | Sample-11 | Sample-11 | Demo1      | Dem     | Demo@yopmail.com | PM        | 44744383505 | 1     | 15   | 15         |
    Then Verify user is successfully registered
    And User searches 136-6475 on the Search bar
    Then Verify user is navigated to Product Detail Page
    And User check Stock level and adds 5 quantity to the cart for Checkout
    Then Verify Basket and Select Delivery
    And Select Checkout Securely for Delivery Details page
    Then Verify user is navigated to Delivery Details page
    And User enters Delivery Details and Proceed for Payment
      | Company | Address1    | Town  | County    | Postcode |
      | RS Demo | High Street | Corby | Berkshire | IG1 1NH  |
    Then Verify user is navigated to Payment page


  @Checkout_Login
  Scenario: Login before payment

    Given User is on RS Component HomePage
    And User searches 136-6475 on the Search bar
    Then Verify user is navigated to Product Detail Page
    And User adds 5 quantity to Basket
    Then Verify Basket and Select Delivery
    And Select Checkout Securely for Delivery Details page
    And User enter Login details  RSDemo and Sample-11 from Checkout
    Then Verify user is navigated to Delivery Details page
    And User enters Delivery Details and Proceed for Payment
      | Company | Address1    | Town  | County    | Postcode |
      | RS Demo | High Street | Corby | Berkshire | IG1 1NH  |
    Then Verify user is navigated to Payment page


