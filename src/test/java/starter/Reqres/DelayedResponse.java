package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DelayedResponse {
    public static String URL = "https://reqres.in";
    public static String GET_DELAYED_RESPONSE = URL + "/api/users?delay={id}";

    @Step("Get delayed response")
    public void setGetDelayedResponse(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
