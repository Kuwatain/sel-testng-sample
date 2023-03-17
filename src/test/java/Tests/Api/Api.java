package Tests.Api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Api {

    public static Response addingAUser(String userName, String password, int statusCode) {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com")
                .setContentType(ContentType.JSON)
                .build();
        JSONObject requestBody = new JSONObject()
                .put("userName", userName)
                .put("password", password);
        return given(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(statusCode)
                .extract().response();
    }

    @Test
    public void addingAnExistingUserTest() {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com")
                .setContentType(ContentType.JSON)
                .build();
        JSONObject requestBody = new JSONObject()
                .put("userName", "User3")
                .put("password", "123456Aa!");
        String userId = addingAUser("User3", "123456Aa!", 201).jsonPath().get("userID");

        String token = given(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().get("token");

        given(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(406);

        given(spec).auth().preemptive().oauth2(token).log().ifValidationFails(LogDetail.ALL)
                .body(requestBody.toString())
                .when()
                .delete("/Account/v1/User/" + userId)
                .then()
                .statusCode(204);

        String result = given(spec).auth().preemptive().oauth2(token).log().ifValidationFails(LogDetail.ALL)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().get("result");
        Assert.assertEquals(result, "User authorization failed.");
    }

    @Test
    public void passwordIsEmpty() {
        String message = addingAUser("Stepan", " ", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordOnlyDigits() {
        String message = addingAUser("Stepan", "12345678", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordDigitsAndOneUppercase() {
        String message = addingAUser("Stepan", "1234567A", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordDigitsAndOneLowercase() {
        String message = addingAUser("Stepan", "1234567Aa", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordDigitsAndOneSpecialCharacter() {
        String message = addingAUser("Stepan", "1234567!", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordLengthSeven() {
        String message = addingAUser("Stepan", "1234!Aa", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordOnlyLowercase() {
        String message = addingAUser("Stepan", "qwertyui", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordLowercaseAndOneDigit() {
        String message = addingAUser("Stepan", "qwertyui1", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordLowercaseAndOneUppercase() {
        String message = addingAUser("Stepan", "qwertyuiA", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordLowercaseAndOneSpecialCharacter() {
        String message = addingAUser("Stepan", "qwertyui!", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }


    @Test
    public void passwordOnlyUppercase() {
        String message = addingAUser("Stepan", "QWERTYUI", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordUppercaseAndOneDigit() {
        String message = addingAUser("Stepan", "QWERTYUI1", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordUppercaseAndOneLowercase() {
        String message = addingAUser("Stepan", "QWERTYUIa", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordUppercaseAndOneSpecialCharacter() {
        String message = addingAUser("Stepan", "QWERTYUI@", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordOnlySpecialCharacter() {
        String message = addingAUser("Stepan", "!@#$%^&*", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordSpecialCharacterAndOneDigit() {
        String message = addingAUser("Stepan", "!@#$%^&*1", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordSpecialCharacterAndOneUppercase() {
        String message = addingAUser("Stepan", "!@#$%^&*A", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }

    @Test
    public void passwordSpecialCharacterAndOneLowercase() {
        String message = addingAUser("Stepan", "!@#$%^&*a", 400).jsonPath().get("message");
        Assert.assertEquals(message, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                " one uppercase ('A'-'Z')," +
                " one lowercase ('a'-'z'), " +
                "one special character and Password must be eight characters or longer.");
    }
}