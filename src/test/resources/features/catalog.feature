@SmokeTest
  @RegressionTest
Feature: Tests for catalog

 Scenario Outline:
    Given Open main page: Onliner.by
    When Input "<item name>" in search input field
    Then Searched item name will contain "<item name>"

   Examples:
   | item name |
   | iphone 13 |