@SmokeTest
Feature: Tests for shopping cart

  Scenario: [Test-Case ID:ONL_001] Adding item to the shopping cart
    Given  Open main page: Onliner.by
    * Open catalog random item
    When Get item name
    * Add item to the shopping cart
    * Open shopping cart page
    Then Item name from shopping cart must match the chosen item from catalog
    * [Перейти к оформлению] button should be visible

  Rule: Work with shopping cart when item was added to cart
    Background:
      Given Open main page: Onliner.by
      * Open catalog random item
      * Add item to the shopping cart
      * Open shopping cart page

    Scenario: [Test-Case ID:ONL_002] Removing item from the shopping cart and checking the cart for emptiness
      When Remove item from the shopping cart
      Then Appeared information should contain "Вы удалили"
      * Expected empty cart message should contain "Ваша корзина пуста"

    Scenario: [Test-Case ID:ONL_003] Adding one more same item in the shopping cart by [+] button
      When Get item price
      * Click + button
      Then The number from quantity input will match [2]
      * The price after adding the same item shouldn't match first price*2
