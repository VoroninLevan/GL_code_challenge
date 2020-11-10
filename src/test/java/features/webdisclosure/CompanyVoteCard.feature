Feature: Company vote card

  As a User
  I want to locate and click the company name link
  So that system would redirect me to company vote card page

  Scenario Outline: Company href redirects to company vote card
    Given User is on the landing page for WD site
    When User clicks the Company Name <CompanyName> hyperlink
    Then The user lands onto the <CompanyName> vote card page.
    And <CompanyName> should appear in the top banner
    Examples:
    |CompanyName              |
    |"Activision Blizzard Inc"|