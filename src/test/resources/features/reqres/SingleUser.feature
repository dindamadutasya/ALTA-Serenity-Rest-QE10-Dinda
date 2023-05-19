Feature: Single User
  @Tugas
  Scenario Outline: Get single user with exceed id
    Given Get sigle user with exceed id <id>
    When Send get single user
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 1000 |
      | 2000    |

  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get sigle user with valid id <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response body name was id <id>
    And Validate single user JSON Schema
    Examples:
      | id |  |
      | 1  |  |
      | 2  |  |