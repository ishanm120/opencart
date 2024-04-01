Feature: Login Functionality

  Scenario: User login with valid credential
    Given User is on login page
    When User enters valid username and valid password
    And User is on login page
    Then User should be logged in successfully

  @Login
  Scenario Outline: User Login with invalid credential
    Given User is on login page
    When User enters username as "<username>" and password as "<password>"
    And User click on login button
    Then User should be logged in successfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | error_user    | secret_sauce |
      | problem_user  | secret_sauce |



