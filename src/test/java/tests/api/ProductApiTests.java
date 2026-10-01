package tests.api;

import base.BaseApiTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductApiTests extends BaseApiTest {

    @Test
    @Tag("api")
    @Tag("smoke")
    void getAllProductsReturnsProducts() {

        String response =
                given()
                        .when()
                        .get("/api/productsList")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("GET PRODUCTS RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 200")
        );

        assertTrue(
                response.contains("\"products\"")
        );

        assertTrue(
                response.contains("\"id\"")
        );

        assertTrue(
                response.contains("\"name\"")
        );
    }

    @Test
    @Tag("api")
    @Tag("regression")
    void postProductsListIsNotSupported() {

        String response =
                given()
                        .when()
                        .post("/api/productsList")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("POST PRODUCTS RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 405")
        );

        assertTrue(
                response.toLowerCase()
                        .contains("not supported")
        );
    }
}