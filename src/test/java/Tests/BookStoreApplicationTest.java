package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static Tests.Api.Api.addingAUser;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.Assert.assertEquals;

public class BookStoreApplicationTest extends BaseTest {
    @Test
    public void loginUserTest() {
        addingAUser("Nikita", "123456Aa!", 201);
        driver.get("https://demoqa.com/");

        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.enterUserName("Nikita");
        bookAppPage.enterPassword("123456Aa!");
        bookAppPage.clickLoginButton();
        wait.until(textToBePresentInElement(bookAppPage.userNameValue, "Nikita"));

        bookAppPage.clickLogOutButton();
        bookAppPage.enterUserName("Nikita");
        bookAppPage.enterPassword("123456Aa!");
        bookAppPage.clickLoginButton();

        bookAppPage.clickDeleteAccountButton();
        bookAppPage.clickCloseSmallModalOkButton();
    }

    @Test
    public void registerUserEmptyFieldsTest() throws InterruptedException {
        driver.get("https://demoqa.com/");
        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.clickNewUserButton();
        bookAppPage.clickRegisterButton();
        String red = "rgb(220, 53, 69)";
        Thread.sleep(2000);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.firstName), red);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.lastName), red);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.userName), red);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.password), red);
    }

    @Test
    public void registerUserCaptchaTest() {
        driver.get("https://demoqa.com/");
        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.clickNewUserButton();
        bookAppPage.enterFirstName("Nikita");
        bookAppPage.enterLastName("Rachkov");
        bookAppPage.enterUserName("niki");
        bookAppPage.enterPassword("1234567");
        bookAppPage.clickRegisterButton();
        wait.until(textToBePresentInElement(bookAppPage.error, "Please verify reCaptcha to register!"));
    }

    @Test
    public void loginUserEmptyFieldsTest() throws InterruptedException {
        driver.get("https://demoqa.com/");
        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.clickNewUserButton();
        bookAppPage.clickGoToLoginButton();
        bookAppPage.clickLoginButton();
        String red = "rgb(220, 53, 69)";
        Thread.sleep(2000);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.userName), red);
        assertEquals(bookAppPage.getBorderColorInput(bookAppPage.password), red);
    }

    @Test
    public void invalidCredentialsTest() {
        driver.get("https://demoqa.com/");
        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.enterUserName("Nikita");
        bookAppPage.enterPassword("1234567");
        bookAppPage.clickLoginButton();
        wait.until(textToBePresentInElement(bookAppPage.error, "Invalid username or password!"));
    }

    @Test
    public void deleteUserTest() {
        addingAUser("Gena", "123456Aa!", 201);
        driver.get("https://demoqa.com/");

        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.enterUserName("Gena");
        bookAppPage.enterPassword("123456Aa!");
        bookAppPage.clickLoginButton();

        bookAppPage.clickDeleteAccountButton();
        bookAppPage.clickCloseSmallModalCancelButton();

        bookAppPage.clickDeleteAccountButton();
        bookAppPage.clickCloseSmallModalOkButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        AssertJUnit.assertEquals(alert.getText(), "User Deleted.");
        alert.accept();

        bookAppPage.enterUserName("Gena");
        bookAppPage.enterPassword("123456Aa!");
        bookAppPage.clickLoginButton();
        wait.until(textToBePresentInElement(bookAppPage.error, "Invalid username or password!"));
    }
}