Feature: Reqres Patch Update Feature test
  @Tugas
  Scenario Outline: Patch update user with valid json
    Given Patch update user with valid json with id <id>
    When Send patch update user request
    Then Status code should be 200 OK
    And Response body should contain name "na update" and job "QA Engineer"
    And Validate patch update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |