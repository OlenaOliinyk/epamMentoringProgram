package JavaMentor.api;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestingRestMethods {


    @Test
    public void statusOK() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/#/store/getInventory")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test
    public void getInventory() {
        given().contentType("application/json")
                .when().get("https://petstore.swagger.io/v2/store/inventory")
                .then().statusCode(200).body("sold", equalTo(132))
                .body("pending", equalTo(128))
                .body("swimming", equalTo(14))
                .log().all();
    }

    @Test
    public void getOrderById() {
        given().contentType("application/json")
                .when().get("https://petstore.swagger.io/v2/store/order/2")
                .then().statusCode(200).body("id", equalTo(2)).log().all();
    }


}