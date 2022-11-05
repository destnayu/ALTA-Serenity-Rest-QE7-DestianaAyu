package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SingleUser {
    public static String URL = "https://reqres.in";
    public static String GET_SINGLE_USER = URL + "/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND = URL + "/api/users/{id}";

    @Step("Get single users")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single user not found")
    public void setGetSingleUserNotFound(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
