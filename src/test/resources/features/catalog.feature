@SmokeTest
@RegressionTest
Feature: Tests for catalog

  Scenario Outline:
    Given Open main page: Onliner.by
    When Input "<item name>" in search input field
    Then Verify searched item name contains "<item name>"

    Examples:
      | item name |
      | iphone 13 |