Feature: Country filter

  As a
  I want
  So that

  Scenario:
    Given user is on the landing page for WD site
    And the Country filter is available
    When user selects "Belgium" from the Country filter list on left panel
    And clicks on Update button for the country filter list
    Then the grid displays all meetings that are associated with the country "Belgium"
    And no meetings associated with any other country appear on the list