Feature: Login feature

  Scenario: Success login
    Given I open browser
    And I open Login page
    When I enter email "rumkostia92@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I logged in

    Scenario: Login incorrect password
      Given I open browser
      And I open Login page
      When I enter email "rumkostia92@gmail.com"
      And I enter password "te$t$tuden"
      And I submit
      Then I am not logged in

      Scenario: Login Not existing email
        Given I open browser
        And I open Login page
        When I enter email ""
        And I enter password "te$t$tudent"
        And I submit
        Then I am not logged in


        Scenario: Empty login and password
          Given I open browser
          And I open Login page
          When I enter email ""
          And I enter password ""
          And I submit
          Then I am not logged in



