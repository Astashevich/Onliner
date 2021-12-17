@SmokeTest
Feature: Tests for shopping cart

  Background:
    Given Open main page: Onliner.by
    * Open catalog random item
    * Add item to the shopping cart
    * Open shopping cart page

  Scenario: [Test-Case ID:ONL_002] Removing item from the shopping cart and checking the cart for emptiness
    When Remove item from the shopping cart
    Then Appeared information should contain "Вы удалили"
    And Expected empty cart message should contain "Ваша корзина пуста"