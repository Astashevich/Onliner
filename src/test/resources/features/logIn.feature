@SmokeTest
Feature: Tests for log-in page

  Background:
    Given Open main page: Onliner.by
    * Open log-In page

  Scenario: Log-In when fields are empty
    When Click log-In form button
    Then Chek log-In form is visible
    * Verify warning message matches "укажите ник или e-mail"

  Scenario: Log-In when password field is empty
    When Input login "vs2450439@gmail.com" in log-in input field
    * Click log-In form button
    Then Chek log-In form is visible
    * Verify warning message matches "укажите пароль"

  Scenario: Log-In when after wright login put few gaps
    When Input login "vs2450439@gmail.com  " in log-in input field
    * Input password "hqhTqwje872H" in password input field
    * Click log-In form button
    Then Chek log-In form is visible
    * Verify warning message matches "укажите ник или e-mail"

  Scenario: Log-In when log-In is non-existent
    When Input login "incorecctlog@gmail.ru" in log-in input field
    * Click log-In form button
    Then Chek log-In form is visible
    * Verify warning message matches "укажите ник или e-mail"

  Scenario: Log-In when fields fills by [space]
    When Input login " " in log-in input field
    * Input password " " in password input field
    * Click log-In form button
    Then Chek log-In form is visible
    * Verify warning message matches "укажите ник или e-mail"