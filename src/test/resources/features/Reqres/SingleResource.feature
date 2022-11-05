Feature: Reqres Single Resource Feature test
  @Tugas
  Scenario Outline: Get single resource with valid parameter id
    Given Get single resource with id <id>
    When Send get single resource request
    Then Status code should be 200 OK
    And Validate get single resource json schema
    Examples:
      | id |
      | 1  |

  @Tugas
  Scenario Outline: Get single resource with invalid parameter id
    Given Get single resource with invalid id <id>
    When Send get single resource request
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 111 |
      | 211 |
      | 555 |

  @Tugas
  Scenario Outline: Get single resource not found with valid parameter id
    Given Get single resource not found with id <id>
    When Send get single resource not found request
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 23 |
      | 55 |
      | 33 |