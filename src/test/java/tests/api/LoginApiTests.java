package tests.api;

import base.BaseApiTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginApiTests extends BaseApiTest {

    @Test
    @Tag("api")
    @Tag("regression")
    void missingEmailReturnsBadRequest() {

        String response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("password", "Password123")
                        .when()
                        .post("/api/verifyLogin")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("MISSING EMAIL RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 400")
        );

        assertTrue(
                response.toLowerCase()
                        .contains("parameter is missing")
        );
    }

    @Test
    @Tag("api")
    @Tag("regression")
    void missingPasswordReturnsBadRequest() {

        String response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("email", "test@example.com")
                        .when()
                        .post("/api/verifyLogin")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("MISSING PASSWORD RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 400")
        );

        assertTrue(
                response.toLowerCase()
                        .contains("parameter is missing")
        );
    }

    @Test
    @Tag("api")
    @Tag("regression")
    void invalidCredentialsReturnUserNotFound() {

        String response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("email", "notreal@example.com")
                        .formParam("password", "WrongPassword")
                        .when()
                        .post("/api/verifyLogin")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("INVALID LOGIN RESPONSE");
        System.out.println(response);

        assertTrue(
                response.contains("\"responseCode\": 404")
        );

        assertTrue(
                response.contains("\"message\": \"User not found!\"")
        );
    }
}