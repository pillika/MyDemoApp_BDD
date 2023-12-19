Feature: Log In functionality
  Background: user is on login page
    Given user clicks menu button
    And clicks "Log In"

  Scenario: User can log in with valid credentials
    Given User can see username and password input fields
    When User enters "bob@example.com"
    And enters "10203040"
    And user clicks "Login" button
    Then user can successfully log in

  Scenario Outline: User can't log in with invalid credentials
    Given User can see username and password input fields
    When User enters "<username>"
    And enters "<password>"
    And user clicks "Login" button
    Then user gets error "<message>"

    Examples:
      | username        | password | message|
      | bob@example.com| |Password is required|
      |                |10203040|Username is required|
      |                |        |Username is required|
      |bob             |10203040|Provided credentials do not match any user in this service.|
      |bob@example.com |bob|Provided credentials do not match any user in this service.|
      |bob              |bob|Provided credentials do not match any user in this service.|
      |alice@example.com|10203040|Sorry, this user has been locked out.|

