Feature: logOut functionality
  Background: user is loged in
    Given user clicks menu button
    And clicks "Log In"
    When User enters "bob@example.com"
    And enters "10203040"
    And clicks "Login" button

  Scenario Outline:User is able to log out
    Given User is navigated to "<any>" Page using sidemenu
    When user clicks menu button
    Then menu option "Log Out" is visible
    When clicks "Log Out"
    Then popup with a message "Are you sure you sure you want to logout?" appears
    When user clicks "Log out" button
    Then popup with a message title "You are successfully logged out." appears
    When user clicks "OK" button
    Then Message popup closes
    And user is navigated to "Login" page

    Examples:
      | any             |
      | About           |
      | Sauce Bot Video |

  Scenario Outline:user is able to cancel log out
    Given User is navigated to "<any>" Page using sidemenu
    When user clicks menu button
    Then menu option "Log Out" is visible
    When clicks "Log Out"
    Then popup with a message "Are you sure you sure you want to logout?" appears
    When user clicks Cancel
    Then Message popup closes
    And user is still loged in

    Examples:
      | any     |
      | Drawing |
      | Webview |