@RunBackground
Feature: Product Listing
  Background:
    Given User enters username as "standard_user" and password as "secret_sauce"
    And User click on login button

  @ProductList
  Scenario: User able to placed order after adding product into cart
    Given User navigate to product listing page
    When User click on add to cart button
    And User click on cart icon
    And User should be on cart page
    And User click on checkout button
    And User should be on checkout information page
    And User enters firstName as "<firstname>" lastName as "<lastname>" and zipcode as "<zipcode>"
    And User click on continue button
    And User should be on checkout overview page
    And User click on finish button
    Then User should able to place order successfully





