package tests.api;

import base.BaseApiTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchApiTests extends BaseApiTest {

    @Test
    @Tag("api")
    @Tag("smoke")
    void searchProductReturnsMatchingProducts() {

        String response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("search_product", "top")
                        .when()
                        .post("/api/searchProduct")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("SEARCH PRODUCT RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 200")
        );

        assertTrue(
                response.contains("\"products\"")
        );

        assertTrue(
                response.toLowerCase().contains("top")
        );
    }

    @Test
    @Tag("api")
    @Tag("regression")
    void searchWithoutProductParameterReturnsBadRequest() {

        String response =
                given()
                        .when()
                        .post("/api/searchProduct")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("MISSING SEARCH PARAMETER RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 400")
        );

        assertTrue(
                response.toLowerCase()
                        .contains("parameter is missing")
        );
    }
}