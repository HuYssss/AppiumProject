Feature: Final Practice AUT Android
  Scenario: Create Macro with Trigger, Action, Constraints, and Variable
    Given the user opens the application
    When the user navigates to the Macro section from the Dashboard
    And the user adds a trigger for the Macro
    And confirm trigger information
    And the user adds an action for the Macro
    And confirm action information
    And the user adds constraints to the Macro
    And confirm constraints information
    And the user adds a local variable
    Then confirm local variable information


  Scenario: Create Action Block
    Given the user opens the application
    When the user navigates to the Action Block from the Dashboard
    And the user adds Action Block Detail
    And the user adds input variable
    And the user adds action
    And the user adds output variable
    Then confirm Action Block information
    And confirm Action Block name and description
