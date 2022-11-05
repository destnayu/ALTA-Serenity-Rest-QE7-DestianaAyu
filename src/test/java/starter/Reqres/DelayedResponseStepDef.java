package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class DelayedResponseStepDef {
    @Steps
    DelayedResponse delayedResponse;

    //Scenario 1
    @Given("Get delayed response with parameter {int}")
    public void getDelayedResponseWithParameterPagePage(int id) {
        delayedResponse.setGetDelayedResponse(id);
    }

    @When("Send get delayed response request")
    public void sendGetDelayedResponseRequest() {
        SerenityRest.when().get(DelayedResponse.GET_DELAYED_RESPONSE);
    }

    @And("Validate get delayed response json schema")
    public void validateGetDelayedResponseJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/GetDelayedResponseJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
