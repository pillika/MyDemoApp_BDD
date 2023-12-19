Feature: User can sort products by multiple criteria

Scenario Outline: Products are sorted
  Given User is on "Products" Page
  When clicks "sort" button
  And chooses the sorting by "<field>" and "<order>"
  Then products are sorted by "<field>" and "<order>"

  Examples:
  |field|order|
  |name|Asc|
  |name|Desc|
  |price|Asc |
  |price|Desc|