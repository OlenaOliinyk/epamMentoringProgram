package JavaMentor.api;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestingPostMethods {


    @Test
    public void kha() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ \"id\": 35, \"petId\": 1, \"quantity\": 1, \"shipDate\": \"2019-08-05T13:40:02.396Z\", \"status\": \"placed\", \"complete\": false}")
                .when().post("/order")
                .then().statusCode(200).log().all();


    }


}
