package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class Login {
    public static String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON.RequestBody";
    public static String POST_LOGIN_SUCCESSFUL = URL + "/api/login";
    public static String POST_LOGIN_UNSUCCESSFUL = URL + "/api/login";

    @Step("Post login user")
    public void setPostLoginSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login unsuccsessful user")
    public void setPostLoginUnuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
