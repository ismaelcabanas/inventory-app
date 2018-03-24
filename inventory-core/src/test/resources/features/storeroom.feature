Feature: Sign up new storeroom into the platform
  In order to store products that I consume normally
  As a user
  I want to sign up a new storeroom

  Scenario: Sign up new storeroom
    Given MyStoreroom wants to become a new storeroom
    When I signup it into the platform
    Then the storeroom has not products

  Scenario: Take units of product from storeroom
    Given a storeroom
    And a product with 10 units in the storeroom
    When I take 2 units of product
    Then the product's stock in storeroom is 8

  Scenario: Refill units of product to storeroom
    Given a storeroom
    And a product with 10 units in the storeroom
    When I refill with 2 units of product
    Then the product's stock in storeroom is 12