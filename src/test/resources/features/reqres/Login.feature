Feature: Login User Feature
  @Tugas
  Scenario: User login Successfully
    Given User login with valid json
    When Send post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate login user JSON Schema

  @Tugas
  Scenario: User login Unsuccessfully
    Given User login with invalid json
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body error was "Missing password"
    And Validate unsuccessfully login user JSON Schema