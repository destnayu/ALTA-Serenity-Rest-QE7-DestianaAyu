package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class SingleResourceStepDef {
    @Steps
    SingleResource singleResource;

    //Scenario 1
    @Given("Get single resource with id {int}")
    public void getSingleResourceWithIdId(int id) {
        singleResource.setGetSingleResource(id);
    }

    @When("Send get single resource request")
    public void sendGetSingleResourceRequest() {
        SerenityRest.when().get(SingleResource.GET_SINGLE_RESOURCE);
    }

    @And("Validate get single resource json schema")
    public void validateGetSingleResourceJsonSchema() {
        File json = new File((ReqresAPI.JSON_SCHEMA+"/GetSingleResourceJsonSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Get single resource with invalid id {int}")
    public void getSingleResourceWithInvalidIdId(int id) {
        singleResource.setGetSingleResource(id);
    }

    //Scenario 3
    @Given("Get single resource not found with id {int}")
    public void getSingleResourceNotFoundWithIdId(int id) {
        singleResource.setGetSingleResourceNotFound(id);
    }

    @When("Send get single resource not found request")
    public void sendGetSingleResourceNotFoundRequest() {
        SerenityRest.when().get(SingleResource.GET_SINGLE_RESOURCE);
    }

}
