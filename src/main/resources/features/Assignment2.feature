@TestFeature
Feature: Assignment2

  
  Scenario Outline: Verifying Goibibo
    Given url for navigation is "<url>"  for "<browser>"
    When select type of trip "<type>"
    Then Enter the details for trip like "<From>" "<To>" "<Departure date>""<Departure month>" "<Return date>" "<Return month>" "<Adults>" "<TravelClass>"
    And clicked on Search
    When filtered by price as lowest
    Then Click on book
    And Review page should be navigated for review checking for match of expected and actual values match i.e "<From>" "<To>" "<Departure date>""<Departure month>" "<Return date>" "<Return month>"
    Then Close the browser

    Examples:
      | url                      | browser | type      | From   | To    | Departure date | Departure month | Return date | Return month | Adults | TravelClass     |
      | https://www.goibibo.com/ | chrome  | roundtrip | Mumbai | Delhi | 3              | October 2020    | 18          | October 2020 | 1      | Premium Economy |