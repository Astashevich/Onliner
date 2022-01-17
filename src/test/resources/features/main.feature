@SmokeTest
Feature: Tests for main page

  Scenario: Open about company page
    Given Open main page: Onliner.by
    When Click [О компании] link
    Then Page url should contain "/about"
    * Page message should contain "о сайте"