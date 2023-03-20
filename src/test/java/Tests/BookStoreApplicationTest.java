package Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static Tests.Api.Api.*;
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

    @Test
    public void addBookProfileUserTest() {
        String randomUserName = RandomStringUtils.randomAlphabetic(15);
        String randomPassword = RandomStringUtils.randomAlphanumeric(15) + "8Aa!";
        creatingAUniqueUser(randomUserName, randomPassword);
        driver.get("https://demoqa.com");

        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.enterUserName(randomUserName);
        bookAppPage.enterPassword(randomPassword);
        bookAppPage.clickLoginButton();

        bookAppPage.clickGotoStoreButton();
        bookAppPage.enterSearchBox("Git Pocket Guide");
        bookAppPage.clickBook("Git Pocket Guide");
        assertEquals(bookAppPage.ISBNWrapper.getText(), "9781449325862");
        assertEquals(bookAppPage.titleWrapper.getText(), "Git Pocket Guide");
        assertEquals(bookAppPage.subtitleWrapper.getText(), "A Working Introduction");
        assertEquals(bookAppPage.authorWrapper.getText(), "Richard E. Silverman");
        assertEquals(bookAppPage.publisherWrapper.getText(), "O'Reilly Media");
        assertEquals(bookAppPage.pagesWrapper.getText(), "234");
        assertEquals(bookAppPage.descriptionWrapper.getText(), "This pocket guide is the perfect on-the-job companion to Git," +
                " the distributed version control system." +
                " It provides a compact, readable introduction to Git for new users," +
                " as well as a reference to common commands and procedures for those of you with Git exp");
        assertEquals(bookAppPage.websiteWrapper.getText(), "http://chimera.labs.oreilly.com/books/1230000000561/index.html");

        bookAppPage.clickAddToYourCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        AssertJUnit.assertEquals(alert.getText(), "Book added to your collection.");
        alert.accept();

        bookAppPage.clickAddToYourCollectionButton();
        wait.until(ExpectedConditions.alertIsPresent());
        AssertJUnit.assertEquals(alert.getText(), "Book already present in the your collection!");
        alert.accept();

        clickJS(bookAppPage.menuListProfile);
        bookAppPage.clickBook("Git Pocket Guide");
        bookAppPage.clickBackToBookStoredButton();

        bookAppPage.clickLogOutButton();
        bookAppPage.enterUserName(randomUserName);
        bookAppPage.enterPassword(randomPassword);
        bookAppPage.clickLoginButton();
        bookAppPage.visibilityBook("Git Pocket Guide");
    }

    @Test
    public void deleteBookProfileUserTest() {
        String randomUserName = RandomStringUtils.randomAlphabetic(15);
        String randomPassword = RandomStringUtils.randomAlphanumeric(15) + "8Aa!";
        creatingAUniqueUserWithBooks(randomUserName, randomPassword);
        driver.get("https://demoqa.com");

        clickJS(landingPage.bookStoreApplication);
        clickJS(bookAppPage.menuListLogin);

        bookAppPage.enterUserName(randomUserName);
        bookAppPage.enterPassword(randomPassword);
        bookAppPage.clickLoginButton();

        bookAppPage.enterSearchBox("Learning JavaScript Design Patterns");
        bookAppPage.clickDeleteBook();
        bookAppPage.clickCloseSmallModalCancelButton();

        bookAppPage.clickDeleteBook();
        bookAppPage.clickCloseSmallModalOkButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        AssertJUnit.assertEquals(alert.getText(), "Book deleted.");
        alert.accept();

        bookAppPage.clickDeleteAllBooksButton();
        bookAppPage.clickCloseSmallModalCancelButton();

        bookAppPage.clickDeleteAllBooksButton();
        bookAppPage.clickCloseSmallModalOkButton();
        wait.until(ExpectedConditions.alertIsPresent());
        AssertJUnit.assertEquals(alert.getText(), "All Books deleted.");
        alert.accept();

        bookAppPage.clickDeleteAllBooksButton();
        bookAppPage.clickCloseSmallModalOkButton();
        wait.until(ExpectedConditions.alertIsPresent());
        AssertJUnit.assertEquals(alert.getText(), "No books available in your's collection!");
        alert.accept();

        bookAppPage.clickLogOutButton();
        bookAppPage.enterUserName(randomUserName);
        bookAppPage.enterPassword(randomPassword);
        bookAppPage.clickLoginButton();
        bookAppPage.invisibilityBook("Git Pocket Guide");
        bookAppPage.invisibilityBook("Learning JavaScript Design Patterns");
        bookAppPage.invisibilityBook("Speaking JavaScript");
    }
}