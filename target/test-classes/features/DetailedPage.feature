Feature: User can choose the color and the count of product, so that he could by what he wants.
Background: user clicks on item in "Products" page and is navigated to the detailed product page
  Given user clicks on a random product in the list

  Scenario: View product details on the detailed page
    Given user is navigated to detailed products page
    Then the page should display a title, description, photo, price, star rating, color, count, and an "Add To Cart" button

  Scenario Outline: Choose count, color and add product to the cart
    Given user is navigated to detailed products page
    When the user selects "<count>" for the product
    And selects random color
    And clicks "Add To Cart" button
    Then the product is added to the cart,where the total "<count>" of items in the cart is displayed


    Examples:
    |count|
    |1    |
    |2    |
    |3    |