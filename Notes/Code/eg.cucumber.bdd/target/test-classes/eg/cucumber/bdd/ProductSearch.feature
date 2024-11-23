Feature: Product Search

  Scenario: User searches for a Product
    Given I am on the Product search page
    When I search for "Laptop"
    Then I should see search results related to "No products found"
    
    Scenario: User searches for a Product
    Given I am on the Product search page
    When I search for ""
    Then I should see search results related to "Please enter a search term"