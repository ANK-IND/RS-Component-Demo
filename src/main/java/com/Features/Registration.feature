Feature: RS Components user Registration

  User should able to register in RS Component from HomePage

  @Registration
  Scenario: RS Component Registration

    Given User is on RS Component HomePage
    When User clicks on Register links for Registration
    Then Verify user navigation to Registration page
    And User enter details for Registration
      | Username | Password  | RetypePwd | First_name | Surname | Email            | Job_Title | Phone       | Title | Role | Hear_About |
      | Demo     | Sample-11 | Sample-11 | Demo1      | Dem     | Demo@yopmail.com | PM        | 44744383505 | 1     | 15   | 15         |
    Then Verify user is successfully registered

