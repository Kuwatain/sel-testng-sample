package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Tests.BaseTest.wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BookStoreApplicationPage {
    @FindBy(xpath = "//li[contains(., 'Login')]")
    public WebElement menuListLogin;
    @FindBy(xpath = "//li[contains(., 'Profile')]")
    public WebElement menuListProfile;

    @FindBy(xpath = "//button[@id = 'login']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@id = 'newUser']")
    private WebElement newUserButton;
    @FindBy(xpath = "//button[@id = 'register']")
    private WebElement registerButton;
    @FindBy(xpath = "//button[@id = 'gotologin']")
    private WebElement goToLoginButton;
    @FindBy(xpath = "//button[@id = 'submit' and text() ='Delete Account']")
    private WebElement deleteAccountButton;
    @FindBy(xpath = "//button[@id = 'submit' and text() ='Log out']")
    private WebElement logOutButton;
    @FindBy(xpath = "//button[@id = 'gotoStore']")
    private WebElement gotoStore;
    @FindBy(xpath = "//button[@id = 'submit' and text() ='Delete All Books']")
    private WebElement deleteAllBooksButton;
    @FindBy(xpath = "//button[@id = 'closeSmallModal-ok']")
    private WebElement closeSmallModalOk;
    @FindBy(xpath = "//button[@id = 'closeSmallModal-cancel']")
    private WebElement closeSmallModalCancel;
    @FindBy(xpath = "//button[@id = 'addNewRecordButton' and text() = 'Back To Book Store']")
    private WebElement backToBookStoredButton;
    @FindBy(xpath = "//button[@id = 'addNewRecordButton' and text() = 'Add To Your Collection']")
    private WebElement addToYourCollectionButton;

    @FindBy(xpath = "//input[@id = 'userName']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id = 'firstname']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id = 'lastname']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@id = 'searchBox']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@id = 'ISBN-wrapper']//label[@id ='userName-value']")
    public WebElement ISBNWrapper;
    @FindBy(xpath = "//div[@id = 'title-wrapper']//label[@id ='userName-value']")
    public WebElement titleWrapper;
    @FindBy(xpath = "//div[@id = 'subtitle-wrapper']//label[@id ='userName-value']")
    public WebElement subtitleWrapper;
    @FindBy(xpath = "//div[@id = 'author-wrapper']//label[@id ='userName-value']")
    public WebElement authorWrapper;
    @FindBy(xpath = "//div[@id = 'publisher-wrapper']//label[@id ='userName-value']")
    public WebElement publisherWrapper;
    @FindBy(xpath = "//div[@id = 'pages-wrapper']//label[@id ='userName-value']")
    public WebElement pagesWrapper;
    @FindBy(xpath = "//div[@id = 'description-wrapper']//label[@id ='userName-value']")
    public WebElement descriptionWrapper;
    @FindBy(xpath = "//div[@id = 'website-wrapper']//label[@id ='userName-value']")
    public WebElement websiteWrapper;

    @FindBy(xpath = "//p[@id = 'name']")
    public WebElement error;

    @FindBy(xpath = "//label[@id = 'userName-value']")
    public WebElement userNameValue;

    @FindBy(xpath = "//span[@id ='delete-record-undefined']")
    private WebElement deleteBook;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickNewUserButton() {
        newUserButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickGoToLoginButton() {
        goToLoginButton.click();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

    public void clickGotoStoreButton() {
        gotoStore.click();
    }

    public void clickDeleteAllBooksButton() {
        deleteAllBooksButton.click();
    }

    public void clickCloseSmallModalOkButton() {
        closeSmallModalOk.click();
    }

    public void clickCloseSmallModalCancelButton() {
        closeSmallModalCancel.click();
    }

    public void clickBackToBookStoredButton() {
        backToBookStoredButton.click();
    }

    public void clickAddToYourCollectionButton() {
        addToYourCollectionButton.click();
    }

    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public String getBorderColorInput(WebElement element) {
        return element.getCssValue("border-color");
    }

    public void enterSearchBox(String book) {
        searchBox.clear();
        searchBox.sendKeys(book);
    }

    private WebElement getDeleteButtonBookById(String id) {
        return wait.until(presenceOfElementLocated(By.xpath("//span[@id = 'see-book-" + id + "']/parent::div/parent::div/following-sibling::div//span")));
    }

    public void clickButtonDeleteBook(String title) {
        getDeleteButtonBookById(title).click();
    }

    private WebElement getBookById(String id) {
        return wait.until(presenceOfElementLocated(By.xpath("//span[@id = 'see-book-" + id + "']")));
    }

    public void clickBook(String title) {
        getBookById(title).click();
    }

    public boolean invisibilityBook(String title) {
        return wait.until(invisibilityOfElementLocated(By.xpath("//span[@id = 'see-book-" + title + "']")));
    }

    public WebElement visibilityBook(String title) {
        return wait.until(visibilityOf(getBookById(title)));
    }


    private WebDriver driver;

    public BookStoreApplicationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}