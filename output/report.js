$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "RS Components user Registration",
  "description": "\nUser should be able to Login by\nLogin from Homepage\nLogin from CheckoutPage",
  "id": "rs-components-user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Login from Homepage",
  "description": "",
  "id": "rs-components-user-registration;login-from-homepage",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User is on RS Component HomePage",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "User clicks on Login link",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Verify user is navigated to Login Page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User enter \u003cUsername\u003e and \u003cpassword\u003e for Login",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify user is Logged In successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "rs-components-user-registration;login-from-homepage;",
  "rows": [
    {
      "cells": [
        "Username",
        "password"
      ],
      "line": 16,
      "id": "rs-components-user-registration;login-from-homepage;;1"
    },
    {
      "cells": [
        "RSDemo",
        "Sample-11"
      ],
      "line": 17,
      "id": "rs-components-user-registration;login-from-homepage;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2504311289,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Login from Homepage",
  "description": "",
  "id": "rs-components-user-registration;login-from-homepage;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User is on RS Component HomePage",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "User clicks on Login link",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Verify user is navigated to Login Page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User enter RSDemo and Sample-11 for Login",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify user is Logged In successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.homePage()"
});
formatter.result({
  "duration": 7163666079,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.clickLogin()"
});
formatter.result({
  "duration": 62094798,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.verifyLoginNav()"
});
formatter.result({
  "duration": 14654867,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "RSDemo",
      "offset": 11
    },
    {
      "val": "Sample-11",
      "offset": 22
    }
  ],
  "location": "HomePageSteps.loginDetails(String,String)"
});
formatter.result({
  "duration": 44055368,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.loginCheck()"
});
formatter.result({
  "duration": 19480479,
  "status": "passed"
});
formatter.after({
  "duration": 195319411,
  "status": "passed"
});
});