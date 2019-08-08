package JavaMentor.api;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestingPostMethods {


    @Test
    public void placeOrderWithValidParameters() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ \"id\": 35, \"petId\": 1, \"quantity\": 1, \"shipDate\": \"2019-08-05T13:40:02.396Z\", \"status\": \"placed\", \"complete\": false}")
                .when().post("/order")
                .then().statusCode(200).log().all();

    }
    @Test
    //value for parameter "complete" is missed
    public void placeOrderWithMissedParameters() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ \"id\": 35, \"petId\": 1, \"quantity\": 1, \"shipDate\": \"2019-08-05T13:40:02.396Z\", \"status\": \"placed\", \"complete\":}")
                .when().post("/order")
                .then().statusCode(400).log().all();


    }

    @Test
    // "quantity": false      instead of     "quantity":1
    public void placeOrderWithInvalidParameters() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ \"id\": 35, \"petId\": 1, \"quantity\": false, \"shipDate\": \"2019-08-05T13:40:02.396Z\", \"status\": \"placed\", \"complete\": false}")
                .when().post("/order")
                .then().statusCode(500).log().all();


    }
    @Test
    // "quantity": false      instead of     "quantity":1
    public void placeOrderWithInvalidParameterQuantity() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ \"id\": 35, \"petId\": 1, \"quantity\": 2555555555555555555555555, \"shipDate\": \"2019-08-05T13:40:02.396Z\", \"status\": \"placed\", \"complete\": false}")
                .when().post("/order")
                .then().statusCode(500).log().all();


    }
    @Test
    // "quantity": false      instead of     "quantity":1
    public void placeOrderWithEmptyBody() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";

        given().contentType("application/json")

                .body("{ }")
                .when().post("/order")
                .then().statusCode(200).log().all();


    }

    @Test
    public void deleteOrder() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        given().contentType("application/json")
                .when().delete("/order/35")
                .then().statusCode(200).log().all();


    }
}
