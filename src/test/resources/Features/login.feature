Feature: Login Functionality
#  Scenario: User login with valid credential
#    Given User is on login page
#    When User enters valid username and valid password
#    And User is on login page
#    Then User should be logged in successfully


  Scenario Outline: User Login
    Given User is on login page
    When User enters username as "<username>" and password as "<password>"
    And User click on login button
    Then User should be logged in successfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | user1         | pass123      |
      | user2         | abc@123      |
      | admin         | admin123     |



