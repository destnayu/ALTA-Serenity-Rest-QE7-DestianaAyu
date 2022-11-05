package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDef {
    @Steps
    Login login;

    //Scenario 1
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Login.JSON_REQ_BODY + "/LoginSuccessful.json");
        login.setPostLoginSuccessful(json);
    }

    @When("Send post user login")
    public void sendPostUserLogin() {
        SerenityRest.when().post(Login.POST_LOGIN_SUCCESSFUL);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/PostLoginSuccessfulJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Post login user with valid json invalid password")
    public void postLoginUserWithValidJsonLoginUnsuccesful() {
        File json = new File(Login.JSON_REQ_BODY + "/LoginInvalidPassword.json");
        login.setPostLoginSuccessful(json);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BR) {
        SerenityRest.then().statusCode(BR);
    }

    //Scenario 3
    @Given("Post login user with valid json invalid username and password")
    public void postLoginUserWithValidJsonInvalidUsernameAndPassword() {
        File json = new File(Login.JSON_REQ_BODY + "/LoginInvalidUsernameAndPassword.json");
        login.setPostLoginSuccessful(json);
    }

    //Scenario 4
    @Given("Post login unsuccessful user with valid json")
    public void postLoginUnsuccessfulUserWithValidJson() {
        File json = new File(Login.JSON_REQ_BODY + "/LoginUnsuccessful.json");
        login.setPostLoginUnuccessful(json);
    }
    @When("Send post user login unsuccsessful")
    public void sendPostUserLoginUnsuccsessful() {
        SerenityRest.when().post(Login.POST_LOGIN_UNSUCCESSFUL);
    }
    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }
    @And("Validate post login unsuccsessful json schema")
    public void validatePostLoginUnsuccsessfulJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/PostUnsuccessfulJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
