package base;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    static void setupApi() {

        RestAssured.baseURI =
                "https://automationexercise.com";

        RestAssured.defaultParser =
                Parser.JSON;
    }
}