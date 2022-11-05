package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SingleResource {
    public static String URL = "https://reqres.in";
    public static String GET_SINGLE_RESOURCE = URL + "/api/unknown/{id}";

    @Step("Get single resource")
    public void setGetSingleResource(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single resource not found")
    public void setGetSingleResourceNotFound(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
