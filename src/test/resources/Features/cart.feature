@runBackground
Feature: Cart Feature
  Background:
    Given User enters username as "standard_user" and password as "secret_sauce"
    And User click on login button

  Scenario: Verify user is able to remove the product from cart page
    Given User navigate to product listing page
    When User click on add to cart button
    And User click on cart icon
    And User click on remove button
    Then Verify product should be removed from the cart
  @Test
  Scenario: Verify user is able to access listing page when he click on continue shopping button
    Given User navigate to product listing page
    When User click on add to cart button
    And User click on cart icon
    And User click on continue shopping button
    Then Verify User should navigate to listing page
