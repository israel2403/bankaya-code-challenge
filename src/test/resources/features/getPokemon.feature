Feature: Get Pokemon

  Scenario: Get Pokemon by name
    Given a request to get Pokemon with name "pikachu"
    When the request is made
    Then the response contains the Pokemon with name "pikachu"
