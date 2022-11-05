Feature: Reqres Feature test
  @Latihan
  Scenario Outline: Get List User with valid parameter page
    Given Get List User with parameter page <page>
    When Send Get List User request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
  Examples:
    | page |
    | 1    |
    | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post user request
    Then Status code should be 201 Created
    And Response body should contain name "na" and job "QA Engineer"
    And Validate create user json schema

  @Latihan
  Scenario Outline: Put update user with valid json
      Given Put update user with valid json with id <id>
      When Send put update user request
      Then Status code should be 200 OK
      And Response body should contain name "na update" and job "QA Engineer"
      And Validate put update user json schema
     Examples:
       | id |  |
       | 1  |  |
       | 2  |  |

  @Latihan
  Scenario Outline: Delete user with valid id
      Given Delete user with Id <id>
      When Send delete user request
      Then Status code should be 204 No Content
    Examples:
      | id |  |
      | 2  |  |



