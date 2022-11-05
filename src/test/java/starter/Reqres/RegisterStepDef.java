package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterStepDef {
    @Steps
    Register register;

    //Scenario 1
    @Given("Post register success with valid json")
    public void postRegisterSuccessWithValidJson() {
        File json = new File(Register.JSON_REQ_BODY+"/RegisterSuccessful.json");
        register.setPostRegisterSuccessful(json);
    }

    @When("Send post user register success")
    public void sendPostUserRegisterSuccess() {
        SerenityRest.when().post(Register.POST_REGISTER_SUCCESSFUL);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Validate post register succsess json schema")
    public void validatePostRegisterSuccsessJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/PostRegisterSuccessfulJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Post register unsuccessful with valid json")
    public void postRegisterUnsuccessfulWithValidJson() {
        File json = new File(Register.JSON_REQ_BODY + "/RegisterUnsuccessful.json");
        register.setPostRegisterUnuccessful(json);
    }

    @When("Send post user register unsuccessful")
    public void sendPostUserRegisterUnsuccessful() {
        SerenityRest.when().post(Register.POST_REGISTER_UNSUCCSESSFUL);
    }

    @And("Validate post register unsuccsessful json schema")
    public void validatePostRegisterUnsuccsessfulJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/PostUnsuccessfulJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
