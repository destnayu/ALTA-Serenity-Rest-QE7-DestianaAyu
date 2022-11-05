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

public class SingleUserStepDef {
    @Steps
    SingleUser singleUser;

    //Scenario 1

    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidIdId(int id) {
        singleUser.setGetSingleUser(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(SingleUser.GET_SINGLE_USER);
    }
    @And("Response body should be {int}")
    public void responseBodyShouldBeId(int dataId) {
        SerenityRest.then()
                .body(ReqresResponses.DATA_ID,equalTo(dataId));
    }

    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/GetSingleUserJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Get single user with invalid id {int}")
    public void getSingleUserWithInvalidIdId(int id){
        singleUser.setGetSingleUser(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NF) {
        SerenityRest.then().statusCode(NF);
    }


    //Scenario 3
    @Given("Get single user not found with id {int}")
    public void getSingleUserNotFoundWithIdId(int id) {
        singleUser.setGetSingleUserNotFound(id);
    }

    @When("Send get single user not found request")
    public void sendGetSingleUserNotFoundRequest() {
        SerenityRest.when().get(SingleUser.GET_SINGLE_USER_NOT_FOUND);
    }

}

