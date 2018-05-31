Feature: RS Components Product catalog Search

  As a New customer/user should be able to search product catalog by

  Search Product using Keyword
  Search Product using Manufacturer no
  Search Product using RS Part no

  @KeywordSearch
  Scenario: Product Search using ProductKeyword

    Given user is on RS Component HomePage
    When user searches Emergency Stop Button on the Search bar
    Then Verify SearchResultPage is displayed with correct product Keyword

  @SortSearch
  Scenario: Sorting Search results using Sort by Drop down

    Given User is on RS Component HomePage
    When User searches Emergency Stop Button on the Search bar
    Then Verify SearchResultPage is displayed with correct product Keyword
    And User selects sort by Price: Low to High for SearchResults
    And User selects List View for Search results
    Then Verify SearchResults are sorted as Price: Low to High option

  @Search_AddAll
  Scenario: Search a product and Add all the product in the page

    Given User is on RS Component HomePage
    When User searches Emergency Stop Button on the Search bar
    Then Verify SearchResultPage is displayed with correct product Keyword
    And   User selects List View for Search results
    And Add all the product in the page




