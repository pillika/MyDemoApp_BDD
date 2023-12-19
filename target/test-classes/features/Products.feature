Feature: User is able to explore products in the list

  Scenario: User scrolls down to view products
    Given user is on the "Products" page
    When user scrolls down the page
    Then user should see a continuous list of products with a visible photo, title, and price displayed

  Scenario: User clicks on a product to view details
    Given user is on the "Products" page
    When user clicks on a random product in the list
    Then user is navigated to detailed products page

  Scenario Outline: Click on the star to submit a review
    Given user is on the "Products" page
    When user clicks on the "<star>" next to a random product in the list
    Then popup appears with a message "Thank you for submitting your review!"
    When clicks "Close Modal"
    Then popup disappears
    And user is on the "Products" page

    Examples:
      | star |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |