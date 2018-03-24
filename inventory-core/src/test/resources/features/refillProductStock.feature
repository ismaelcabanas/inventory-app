Feature: Refill the stock of products to a storeroom

  In order to add new products to my storeroom
  As an user
  I want to refill the stock of products

  Scenario: Refill product
    Given a product with 10 items in the storeroom
    When I refill the product with 2 items
    Then the stock of product is 12
