Feature: Sign up new product into the platform
  In order to include products in storerooms
  As a user
  I want to sign up a new product

  Scenario: Sign up new product
    Given Apple wants to become a new product in storeroom
    And a storeroom called MyStoreroom
    When I signup the product into the platform
    Then the storeroom has the Apple
    And the stock of Apple in MyStoreroom is 0
