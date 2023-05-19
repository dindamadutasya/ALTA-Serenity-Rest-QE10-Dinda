Feature: Delete User
  @Tugas
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid id <id>
    When Send delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id |  |
      | aw |  |
      | @# |  |