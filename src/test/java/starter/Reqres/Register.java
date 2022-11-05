package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class Register {

    public static String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON.RequestBody";
    public static String POST_REGISTER_SUCCESSFUL = URL + "/api/register";
    public static String POST_REGISTER_UNSUCCSESSFUL = URL + "/api/register";

    @Step("Post register successful")
    public void setPostRegisterSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register unsuccessful")
    public void setPostRegisterUnuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
