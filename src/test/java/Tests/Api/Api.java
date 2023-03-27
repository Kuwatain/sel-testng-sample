package Tests.Api;

import Model.User;
import POJO.Book;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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
        User user = new User(userName, password);
        return given().spec(spec)
                .body(user)
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
        String userId = given().spec(spec).log().all()
                .body(user)
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(201)
                .extract().response().jsonPath().get("userID");
        user.setUserId(userId);
        return userId;
    }

    public static String generateToken(User user) {
        String token = given(spec).log().ifValidationFails(LogDetail.ALL)
                .body(user)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().get("token");
        user.setToken(token);
        return token;
    }

    public static void addBook(User user, Book book) {
        given(spec).auth().preemptive().oauth2(user.getToken()).log().ifValidationFails(LogDetail.ALL)
                .body(book.getIsbn())
                .when()
                .post("/BookStore/v1/Books")
                .then().log().all()
                .statusCode(201);
    }

    public static void creatingAUniqueUserWithBooks(String randomUserName, String randomPassword) {
        User user = new User(randomUserName, randomPassword);
        creatingAUniqueUser(user);
        generateToken(user);

        Book gitPocketGuide = new Book(user, "9781449325862");
        Book learningJavaScriptDesignPatterns = new Book(user, "9781449331818");
        Book speakingJavaScript = new Book(user, "9781449365035");

        addBook(user, gitPocketGuide);
        addBook(user, learningJavaScriptDesignPatterns);
        addBook(user, speakingJavaScript);
    }

    @Test
    public void addingAnExistingUserTest() {
        User user = new User("asd", "asd", "asd@gmail.com");

        creatingAUniqueUser(user);
        generateToken(user);

        given().spec(spec)
                .body(user)
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(406);

        given().spec(spec).auth().preemptive().oauth2(user.getToken()).log().ifValidationFails(LogDetail.ALL)
                .body(user)
                .when()
                .delete("/Account/v1/User/" + user.getUserId())
                .then()
                .statusCode(204);

        given().spec(spec).auth().preemptive().oauth2(user.getToken()).log().ifValidationFails(LogDetail.ALL)
                .body(user)
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