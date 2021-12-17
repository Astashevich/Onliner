Feature: Tests for shopping cart

  Scenario: [Test-Case ID:ONL_002] Removing item from the shopping cart and checking the cart for emptiness
    Given Open main page: Onliner.by
    And Open catalog random item
    And Add item to the shopping cart
    And Open shopping cart page
    When Remove item from the shopping cart
    Then Appeared information should contain [Вы удалили]
    And Expected empty cart message should contain [Ваша корзина пуста]