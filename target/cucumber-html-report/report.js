$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/Assignment2.feature");
formatter.feature({
  "name": "Assignment2",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@TestFeature"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verifying Goibibo",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "url for navigation is \"\u003curl\u003e\"  for \"\u003cbrowser\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "select type of trip \"\u003ctype\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Enter the details for trip like \"\u003cFrom\u003e\" \"\u003cTo\u003e\" \"\u003cDeparture date\u003e\"\"\u003cDeparture month\u003e\" \"\u003cReturn date\u003e\" \"\u003cReturn month\u003e\" \"\u003cAdults\u003e\" \"\u003cTravelClass\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "clicked on Search",
  "keyword": "And "
});
formatter.step({
  "name": "filtered by price as lowest",
  "keyword": "When "
});
formatter.step({
  "name": "Click on book",
  "keyword": "Then "
});
formatter.step({
  "name": "Review page should be navigated for review checking for match of expected and actual values match i.e \"\u003cFrom\u003e\" \"\u003cTo\u003e\" \"\u003cDeparture date\u003e\"\"\u003cDeparture month\u003e\" \"\u003cReturn date\u003e\" \"\u003cReturn month\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "url",
        "browser",
        "type",
        "From",
        "To",
        "Departure date",
        "Departure month",
        "Return date",
        "Return month",
        "Adults",
        "TravelClass"
      ]
    },
    {
      "cells": [
        "https://www.goibibo.com/",
        "chrome",
        "roundtrip",
        "Mumbai",
        "Delhi",
        "3",
        "October 2020",
        "18",
        "October 2020",
        "1",
        "Premium Economy"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verifying Goibibo",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TestFeature"
    }
  ]
});
formatter.step({
  "name": "url for navigation is \"https://www.goibibo.com/\"  for \"chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.url_for_navigation_is_for(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select type of trip \"roundtrip\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.select_type_of_trip(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the details for trip like \"Mumbai\" \"Delhi\" \"3\"\"October 2020\" \"18\" \"October 2020\" \"1\" \"Premium Economy\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.enter_the_details_for_trip_like(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicked on Search",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.clicked_on_Search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "filtered by price as lowest",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.filtered_by_price_as_lowest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on book",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.click_on_book()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Review page should be navigated for review checking for match of expected and actual values match i.e \"Mumbai\" \"Delhi\" \"3\"\"October 2020\" \"18\" \"October 2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.review_page_should_be_navigated_for_review_checking_for_match_of_expected_and_actual_values_match_i_e(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.StepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});