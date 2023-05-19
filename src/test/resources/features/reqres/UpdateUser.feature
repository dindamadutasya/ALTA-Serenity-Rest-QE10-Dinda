Feature: Update User
  @Tugas
  Scenario Outline: Put Update User Unsuccessfully
    Given Put Update User with Invalid json and valid id <id>
    When Send put update user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
      | 2  |