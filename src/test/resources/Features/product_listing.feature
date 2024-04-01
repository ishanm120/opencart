Feature: Product Listing
  Background:
    Given User is on login page
    When User enters valid username and valid password
    And User click on login button
    Then User should be logged in successfully

@ProductList
  Scenario: User able to see product on listing page
    When User navigate to product listing page
    Then User should able to see list of product

  Scenario: User able to placed order after adding product into cart
    Given User navigate to product listing page
    When User click on add to cart button
    And User click on cart icon
    And User should be on cart page
    And User click on checkout button
    And User should be on checkout information page
    And User enters first name as "<firstName>" last name as "<lastName>" and zipcode as "<zipCode>"
    And User click on continue button
    And User should be on checkout overview page
    And User click on finish button
    Then User should able to place order successfully




