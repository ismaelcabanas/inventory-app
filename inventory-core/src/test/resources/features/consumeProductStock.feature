Feature: Consume stock of products from a storeroom

  In order to manage the product's stock of my storeroom
  As an user
  I want to consume the stock of products

  Scenario: Consume product with enough existences
    Given a product with 10 items in the storeroom
    When I consume 2 items of product
    Then the stock of product is 8

  Scenario: Consume product without enough existences
    Given a product with 10 items in the storeroom
    When I consume 12 items of product
    Then should advice me that not exist enough stock of product
