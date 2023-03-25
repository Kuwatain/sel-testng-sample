package Tests.Api;

import DataProviders.DataProviders;
import Model.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertEquals;


public class Api {
    public static RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("https://demoqa.com")
            .setContentType(ContentType.JSON)
            .build();


    public static Response addingAUser(String userName, String password, int statusCode) {
        JSONObject requestBody = new JSONObject()
                .put("userName", userName)
                .put("password", password);
        return given().spec(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(statusCode)
                .extract().response();
    }

    public static Response addingAUser(String userName, String password) {
        return addingAUser(userName, password, 201);
    }

    public static String creatingAUniqueUser(User user) {

        JSONObject requestBody = new JSONObject()
                .put("userName", user.getUserName())
                .put("password", user.getPassword());
        String userId = given().spec(spec).log().all()
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(201)
                .extract().response().jsonPath().get("userID");
        user.setUserId(userId);
        return userId;
    }

    public static String generateToken(User user) {
        JSONObject requestBody = new JSONObject()
                .put("userName", user.getUserName())
                .put("password", user.getPassword());
        String token = given(spec).log().ifValidationFails(LogDetail.ALL)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().get("token");
        user.setToken(token);
        return token;
    }

    public static void addBook(String token, String userId, String isbn) {

        given(spec).auth().preemptive().oauth2(token).log().ifValidationFails(LogDetail.ALL)
                .body("{\n" +
                        "    \"userId\": \"" + userId + "\",\n" +
                        "    \"collectionOfIsbns\": [\n" +
                        "        {\n" +
                        "            \"isbn\": \"" + isbn + "\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .when()
                .post("/BookStore/v1/Books")
                .then().log().all()
                .statusCode(201);
    }

    public static void creatingAUniqueUserWithBooks(String randomUserName, String randomPassword) {
        User user = new User(randomUserName, randomPassword);
        String userId = creatingAUniqueUser(user);
        String token = generateToken(user);
        addBook(token, userId, "9781449325862");
        addBook(token, userId, "9781449331818");
        addBook(token, userId, "9781449365035");
    }

    @Test(dataProvider = "Login Params", dataProviderClass = DataProviders.class)
    public void addingAnExistingUserTest(User user) {
        JSONObject requestBody = new JSONObject()
                .put("userName", user.getUserName())
                .put("password", user.getPassword());
        String userId = addingAUser(user.getUserName(), user.getPassword()).jsonPath().get("userID");

        String token = given().spec(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().get("token");

        given().spec(spec)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(406);

        given().spec(spec).auth().preemptive().oauth2(token).log().ifValidationFails(LogDetail.ALL)
                .body(requestBody.toString())
                .when()
                .delete("/Account/v1/User/" + userId)
                .then()
                .statusCode(204);

        given().spec(spec).auth().preemptive().oauth2(token).log().ifValidationFails(LogDetail.ALL)
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .assertThat()
                .body(containsString("result"), containsString("User authorization failed."))
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void passwordValidation() {
        List<String> passwordList = Arrays.asList
                (
                        " ",
                        "1234Aa!",
                        "12345678",
                        "1234567A",
                        "1234567a",
                        "1234567!",
                        "1234567Aa",
                        "1234567A!",
                        "1234567a!",
                        "qwertyui",
                        "qwertyui1",
                        "qwertyuiA",
                        "qwertyui!",
                        "qwertyui1A",
                        "qwertyui1!",
                        "qwertyuiA!",
                        "QWERTYUI",
                        "QWERTYUI1",
                        "QWERTYUIa",
                        "QWERTYUI!",
                        "QWERTYUIa1",
                        "QWERTYUIa!",
                        "QWERTYUI1!",
                        "!@#$%^&*",
                        "!@#$%^&*1",
                        "!@#$%^&*A",
                        "!@#$%^&*a",
                        "!@#$%^&*aA",
                        "!@#$%^&*a1",
                        "!@#$%^&*A1"
                );

        passwordList.forEach(i -> assertEquals(addingAUser("Stepan", (i), 400).jsonPath().get("message"),
                "Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                        " one uppercase ('A'-'Z')," +
                        " one lowercase ('a'-'z'), " +
                        "one special character and Password must be eight characters or longer."));
    }
}