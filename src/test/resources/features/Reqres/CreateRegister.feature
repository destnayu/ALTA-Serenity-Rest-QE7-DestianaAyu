Feature: Reqres Create Register Feature test
  @Tugas
  Scenario: Post create register success with valid json
    Given Post register success with valid json
    When Send post user register success
    Then Status code should be 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And  Validate post register succsess json schema

  @Tugas
  Scenario: Post create register unsuccessful with valid json
    Given Post register unsuccessful with valid json
    When Send post user register unsuccessful
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"
    And Validate post register unsuccsessful json schema