Feature: Sign in

  As a QA engineer
  I want to sign in to Viewpoint platform without providing username and password
  So that system will not let me to sign in and would output the error message: "The fields USERNAME and PASSWORD are required."

  Scenario: Sign in without credentials provided
    Given I am in "http://www.glasslewis.com" web app
    When I navigate to login link
    And From the dialog I login to Viewpoint Voting Platform
    Then System navigates me to the "https://viewpoint.glasslewis.com/" page
    And I click "Sign in" button on the page without providing username and password
    Then System would not let me to sign in and the error message would appear: The fields USERNAME and PASSWORD are required.