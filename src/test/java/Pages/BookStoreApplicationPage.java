package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStoreApplicationPage {
    @FindBy(xpath = "//li[contains(., 'Login')]")
    public WebElement menuListLogin;

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
    @FindBy(xpath = "//button[@id = 'submit' and text() ='Go To Book Store']")
    private WebElement goToBookStoreButton;
    @FindBy(xpath = "//button[@id = 'submit' and text() ='Delete All Books']")
    private WebElement deleteAllBooksButton;
    @FindBy(xpath = "//button[@id = 'closeSmallModal-ok']")
    private WebElement closeSmallModalOk;
    @FindBy(xpath = "//button[@id = 'closeSmallModal-cancel']")
    private WebElement closeSmallModalCancel;
    @FindBy(xpath = "//input[@id = 'userName']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id = 'firstname']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id = 'lastname']")
    public WebElement lastName;
    @FindBy(xpath = "//div[contains(@class, 'modal-dialog')]")
    public WebElement modalDialog;
    @FindBy(xpath = "//p[@id = 'name']")
    public WebElement error;

    @FindBy(xpath = "//label[@id = 'userName-value']")
    public WebElement userNameValue;

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

    public void clickGoToBookStoreButton() {
        goToBookStoreButton.click();
    }

    public void clickDeleteAllBooksButtonn() {
        deleteAllBooksButton.click();
    }

    public void clickCloseSmallModalOkButton() {
        closeSmallModalOk.click();
    }

    public void clickCloseSmallModalCancelButton() {
        closeSmallModalCancel.click();
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


    private WebDriver driver;

    public BookStoreApplicationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
