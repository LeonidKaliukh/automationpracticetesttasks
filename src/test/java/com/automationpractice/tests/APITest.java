package com.automationpractice.tests;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static api.FileUtils.readStringFromFile;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest {

    @BeforeMethod
    void setup() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    @Description("Create user")
    void createUserTest() throws ParseException {
        String data = readStringFromFile("src/test/resources/loginData.txt");
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(data);

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("api/users")
                .then()
                .statusCode(201)
                .log().body()
                .body("id", notNullValue())
                .body("name", is(jsonData.get("name")))
                .body("job", is(jsonData.get("job")))
                .body("createdAt", notNullValue());
    }

    @Test
    @Description("Get Single user")
    void getSingleUserTest() throws ParseException{
        String data = readStringFromFile("src/test/resources/singleUser.txt");
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(data);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("api/users/12")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.id", notNullValue())
                .body("data.email", is(jsonData.get("email")))
                .body("data.first_name", is(jsonData.get("first_name")))
                .body("data.last_name", is(jsonData.get("last_name")))
                .body("data.avatar", is(jsonData.get("avatar")))
                .body("support.url", is(jsonData.get("url")))
                .body("support.text", is(jsonData.get("text")));
    }

    @Test
    @Description("Update user")
    void updateUserTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"job\": \"zion resident\" }")
                .when()
                .put("api/users/12")
                .then()
                .statusCode(200)
                .log().body()
                .body("job", equalTo("zion resident"));
    }

    @Test
    @Description("Delete user")
    void deleteUserTest() {
        given()
                .when()
                .delete("api/users/12")
                .then()
                .statusCode(204);
    }
}
