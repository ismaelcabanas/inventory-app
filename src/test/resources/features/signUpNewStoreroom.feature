Feature: Sign up new storeroom into the platform
  In order to store products that I consume normally
  As a user
  I want to sign up a new storeroom

  Scenario: Sign up new storeroom
    Given MyStoreroom wants to become a new storeroom
    When I signup it into the platform
    Then the storeroom has not products
