Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "ksenia.strigkova@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

    Scenario: Login incorrect password
      Given I open Login Page
      When I enter email "ksenia.strigkova@gmail.com"
      And I enter incorrect password "te1t9tudent"
      And I submit
      Then I still Login page

      Scenario: Login Not existing email
        Given I open Login Page
        When I enter Not existing email "ksenia22@gmail.com"
        And I enter password "te$t$tudent"
        And I submit
        Then I still Login page

        Scenario: Empty Login and Password
          Given I open Login Page
          When I enter Empty email " "
          And I enter Empty password " "
          And I submit
          Then I still Login page
