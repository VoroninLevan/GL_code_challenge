Feature: Country filter

  As a User
  I want to filter output by specific country
  So that system would output only meetings associated with desired country

  Scenario Outline: Grid displays only meetings associated with Country filter
    Given user is on the landing page for WD site
    And The Country filter is available
    When User selects <Country> from the Country filter list on left panel
    And Clicks on Update button for the country filter list
    Then The grid displays all meetings that are associated with the country <Country>
    And No meetings associated with any other country appear on the list
    Examples:
    |Country  |
    |"Belgium"|