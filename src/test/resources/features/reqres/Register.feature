Feature: Register for User
  @Tugas
  Scenario: Post Register User with Valid JSON
    Given Post register user with valid json
    When Send post register user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4" and id 4
    And Validate register user JSON Schema

  @Tugas
  Scenario: Post Register User with Invalid JSON
    Given Post register user with invalid json
    When Send post register user
    Then Status code should be 400 Bad Request
    And Validate invalid register user JSON Schema
