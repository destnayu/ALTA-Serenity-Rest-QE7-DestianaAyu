Feature: Reqres Single User Feature test
  @Tugas
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid id <id>
    When Send get single user request
    Then Status code should be 200 OK
    And Response body should be <data.id>
    And Validate get single user json schema
    Examples:
      | id | data.id |
      | 1  | 1       |
      | 2  | 2       |

  @Tugas
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid id <id>
    When Send get single user request
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 111 |
      | 211 |
      | 555 |

  @Tugas
  Scenario Outline: Get single user not found with valid parameter id
    Given Get single user not found with id <id>
    When Send get single user not found request
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 23 |
      | 55 |
      | 33 |