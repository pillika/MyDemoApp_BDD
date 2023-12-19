Feature: smooth checkout process
Background: user logs in and adds item to cart
  Given user is on the "Products" page
  When user clicks menu button
  And clicks "Log In"
  When User enters "bob@example.com"
  And enters "10203040"
  And clicks "Login" button
  Then user can successfully log in
  And user is on the "Products" page
  When user clicks on a random product in the list
  And clicks "Add To Cart" button
  And clicks Cart icon

  Scenario: complete checkout
    Given user is on the "My Cart" page
    And user has random product in the cart
    When clicks "Proceed To Checkout" button
    Then user is navigated to "Checkout" page
    When user enters "Petras Petraitis" in shipping address "Full Name* input field"
    And user enters "Liepu 10" in shipping address "Address Line 1* input field"
    And user enters "Petrai" in shipping address "City* input field"
    And user enters "Kauno raj" in shipping address "State/Region input field"
    And user enters "55128" in shipping address "Zip Code* input field"
    And user enters "Lithuania" in shipping address "Country* input field"
    And clicks "To Payment" button
    Then user is navigated to "payment method" window
    When user enters "Petras Petraitis" in payment method "Full Name* input field"
    And user enters "4111111111111111" in payment method "Card Number* input field"
    And user enters "03/25" in payment method "Expiration Date* input field"
    And user enters "333" in payment method "Security Code* input field"
    And clicks "Review Order" button
    Then user is navigated to "Review your order" window
    When user can see "Petras Petraitis" in "checkout delivery address"
    And user can see "Liepu 10" in "checkout delivery address"
    And user can see "Petrai" in "checkout delivery address"
    And user can see "Kauno raj" in "checkout delivery address"
    And user can see "55128" in "checkout delivery address"
    And user can see "Lithuania" in "checkout delivery address"
    And user can see "Petras Petraitis" in "checkout payment info"
    And user can see "4111 1111 1111 1111" in "checkout payment info"
    And user can see "03/25" in "checkout payment info"
    Then clicks "Place Order" button
    And the user is navigated "Checkout complete" page
    When  clicks "Continue Shopping" button
    Then user is navigated to "Products" page

