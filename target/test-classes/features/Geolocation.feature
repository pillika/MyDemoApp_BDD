Feature: Geolocation Testing
Background: user is on "Geo Location" Page
  Given User is navigated to "Geo Location" Page using sidemenu

  Scenario: User doesn't allow location to be determined
    Given user sets access to the device's location by clicking "deny_button"
    Then latitude "0" and longitude "0" are displayed

  Scenario: Get actual Geolocation one time
    Given the location is mocked: latitude "54.958", longitude "54.958"
    Given user sets access to the device's location by clicking "allow_one_time_button"
    And clicks "Start Observing" button
    Then user retrieves the accurate geolocation
    When user quits the My Demo App and opens it again
    And  User is navigated to "Geo Location" Page using sidemenu
    Then user sees the permission controller popup again

  Scenario: Get geolocation while using the app
    Given the location is mocked: latitude "24.95823", longitude "24.95823"
    And user sets access to the device's location by clicking "allow_foreground_only_button"
    And clicks "Start Observing" button
    Then user retrieves the accurate geolocation
    When user quits the My Demo App and opens it again
    And  User is navigated to "Geo Location" Page using sidemenu
    Then user retrieves the accurate geolocation
