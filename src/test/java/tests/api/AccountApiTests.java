package tests.api;

import base.BaseApiTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountApiTests extends BaseApiTest {

    @Test
    @Tag("api")
    @Tag("regression")
    void userAccountLifecycle() {

        String email =
                "jasmyn" + System.currentTimeMillis() + "@example.com";

        String password = "Password123";

        String createResponse =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("name", "Jasmyn")
                        .formParam("email", email)
                        .formParam("password", password)
                        .formParam("title", "Mrs")
                        .formParam("birth_date", "10")
                        .formParam("birth_month", "5")
                        .formParam("birth_year", "1995")
                        .formParam("firstname", "Jasmyn")
                        .formParam("lastname", "Medina")
                        .formParam("company", "QA Portfolio")
                        .formParam("address1", "123 Test Street")
                        .formParam("country", "United States")
                        .formParam("zipcode", "93550")
                        .formParam("state", "California")
                        .formParam("city", "Palmdale")
                        .formParam("mobile_number", "5551234567")
                        .when()
                        .post("/api/createAccount")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("CREATE RESPONSE");
        System.out.println(createResponse);

        assertTrue(
                createResponse.contains("\"responseCode\": 201")
        );

        assertTrue(
                createResponse.contains("\"message\": \"User created!\"")
        );


        String getResponse =
                given()
                        .queryParam("email", email)
                        .when()
                        .get("/api/getUserDetailByEmail")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("GET RESPONSE");
        System.out.println(getResponse);

        assertTrue(
                getResponse.contains("\"responseCode\": 200")
        );

        assertTrue(
                getResponse.contains(email)
        );


        String updateResponse =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("name", "Jasmyn Updated")
                        .formParam("email", email)
                        .formParam("password", password)
                        .formParam("title", "Mrs")
                        .formParam("birth_date", "10")
                        .formParam("birth_month", "5")
                        .formParam("birth_year", "1995")
                        .formParam("firstname", "Jasmyn")
                        .formParam("lastname", "Medina")
                        .formParam("company", "QA Portfolio")
                        .formParam("address1", "456 Updated Street")
                        .formParam("country", "United States")
                        .formParam("zipcode", "93550")
                        .formParam("state", "California")
                        .formParam("city", "Palmdale")
                        .formParam("mobile_number", "5551234567")
                        .when()
                        .put("/api/updateAccount")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("UPDATE RESPONSE");
        System.out.println(updateResponse);

        assertTrue(
                updateResponse.contains("\"responseCode\": 200")
        );


        String updatedUserResponse =
                given()
                        .queryParam("email", email)
                        .when()
                        .get("/api/getUserDetailByEmail")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("UPDATED USER RESPONSE");
        System.out.println(updatedUserResponse);

        assertTrue(
                updatedUserResponse.contains("Jasmyn Updated")
        );

        assertTrue(
                updatedUserResponse.contains(
                        "456 Updated Street"
                )
        );


        String deleteResponse =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("email", email)
                        .formParam("password", password)
                        .when()
                        .delete("/api/deleteAccount")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("DELETE RESPONSE");
        System.out.println(deleteResponse);

        assertTrue(
                deleteResponse.contains("\"responseCode\": 200")
        );


        String deletedUserResponse =
                given()
                        .queryParam("email", email)
                        .when()
                        .get("/api/getUserDetailByEmail")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        System.out.println("DELETED USER RESPONSE");
        System.out.println(deletedUserResponse);

        assertTrue(
                deletedUserResponse.contains("\"responseCode\": 404")
        );
    }
}