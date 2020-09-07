$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ElasticSearch.feature");
formatter.feature({
  "name": "verify Elastic Search functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ElasticSearch"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Search by Claims correct data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@ElasticSearchClaims"
    }
  ]
});
formatter.step({
  "name": "user Sign In with correct credentials \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "enter the criteria desired \"\u003ccriteria\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "select claims checkbook",
  "keyword": "When "
});
formatter.step({
  "name": "verify the claims displayed is correct \"\u003ccriteria\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "criteria"
      ]
    },
    {
      "cells": [
        "email",
        "password",
        "policyclaims"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.scenario({
  "name": "Search by Claims correct data",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@ElasticSearch"
    },
    {
      "name": "@ElasticSearchClaims"
    }
  ]
});
formatter.step({
  "name": "user Sign In with correct credentials \"email\" and \"password\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DetailsPolicy.userSignInWithCorrectCredentialsAnd(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the criteria desired \"policyclaims\"",
  "keyword": "When "
});
formatter.match({
  "location": "DetailsPolicy.enterTheNumberOfPolicyDesired(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select claims checkbook",
  "keyword": "When "
});
formatter.match({
  "location": "ElasticSearchSteps.selectClaimsCheckbook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the claims displayed is correct \"policyclaims\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ElasticSearchSteps.verifyTheClaimsDisplayedIsCorrect(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});