Feature: Delete User
  @Tugas
  Scenario Outline: Delete user with exceed parameter id
    Given Delete user with exceed id <id>
    When Send delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id |  |
      | aw |  |
      | @# |  |