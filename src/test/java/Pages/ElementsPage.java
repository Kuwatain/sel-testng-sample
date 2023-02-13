package Pages;

import Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Tests.BaseTest.sendText;

public class ElementsPage {
    @FindBy(xpath = "//li[contains(.,'Text Box')]")
    private WebElement textBox;
    @FindBy(xpath = "//input[contains(@id, 'userName')]")
    private WebElement userName;
    @FindBy(xpath = "//input[contains(@id, 'userEmail')]")
    private WebElement userEmail;
    @FindBy(xpath = "//textarea[contains(@id, 'currentAddress')]")
    private WebElement currentAddress;
    @FindBy(xpath = "//textarea[contains(@id, 'permanentAddress')]")
    private WebElement permanentAddress;
    @FindBy(xpath = "//button[contains(@id, 'submit')]")
    private WebElement submit;


    @FindBy(xpath = "//p[contains(@id, 'name')]")
    public WebElement resultName;
    @FindBy(xpath = "//p[contains(@id, 'email')]")
    public WebElement resultEmail;
    @FindBy(xpath = "//p[contains(@id, 'currentAddress')]")
    public WebElement resultCurrentAddress;
    @FindBy(xpath = "//p[contains(@id, 'permanentAddress')]")
    public WebElement resultPermanentAddress;

    @FindBy(xpath = "//li[contains(., 'Check Box')]")
    private WebElement checkBox;
    @FindBy(xpath = "//button[contains(@title, 'Expand all')]")
    private WebElement expandAll;

    @FindBy(xpath = "//div[contains(@class, 'display-result mt-4')]")
    public List<WebElement> displayResultCheckBox;

    @FindBy(xpath = "//li[contains(., 'Radio Button')]")
    private WebElement radioButton;
    @FindBy(xpath = "//label[contains(@for, 'yesRadio')]")
    private WebElement yesRadio;
    @FindBy(xpath = "//label[contains(@for, 'impressiveRadio')]")
    private WebElement impressiveRadio;
    @FindBy(xpath = "//input[@id = 'noRadio']")
    public WebElement noRadio;
    @FindBy(xpath = "//p[contains(@class, 'mt-3')]")
    public WebElement displayResultRadioButton;

    @FindBy(xpath = "//li[contains(., 'Web Tables')]")
    private WebElement webTables;
    @FindBy(xpath = "//button[@id = 'addNewRecordButton']")
    private WebElement addButton;
    @FindBy(xpath = "//input[@id  = 'firstName']")
    private WebElement userTablesFirstName;
    @FindBy(xpath = "//input[@id  = 'lastName']")
    private WebElement userTablesLastName;
    @FindBy(xpath = "//input[@id  = 'userEmail']")
    private WebElement userTablesEmail;
    @FindBy(xpath = "//input[@id  = 'age']")
    private WebElement userTablesAge;
    @FindBy(xpath = "//input[@id  = 'salary']")
    private WebElement userTablesSalary;
    @FindBy(xpath = "//input[@id  = 'department']")
    private WebElement userTablesDepartment;
    @FindBy(xpath = "//button[@id  = 'submit']")
    private WebElement submitForm;

    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchBoxForm;

    @FindBy(xpath = "//li[contains(., 'Buttons')]")
    private WebElement buttons;
    @FindBy(xpath = "//button[@id = 'doubleClickBtn']")
    public WebElement doubleClickBtn;
    @FindBy(xpath = "//button[@id = 'rightClickBtn']")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//button[@class = 'btn btn-primary' and .='Click Me']")
    private WebElement clickMeBtn;
    @FindBy(xpath = "//p[@id ='doubleClickMessage']")
    public WebElement doubleClickMessage;
    @FindBy(xpath = "//p[@id ='rightClickMessage']")
    public WebElement rightClickMessage;
    @FindBy(xpath = "//p[@id ='dynamicClickMessage']")
    public WebElement dynamicClickMessage;

    @FindBy(xpath = "//li[contains(., 'Links')]")
    private WebElement links;
    @FindBy(xpath = "//a[@id = 'dynamicLink']")
    private WebElement dynamicLink;
    @FindBy(xpath = "//a[@id = 'simpleLink']")
    private WebElement simpleLink;
    @FindBy(xpath = "//a[@id = 'created']")
    private WebElement created;
    @FindBy(xpath = "//a[@id = 'no-content']")
    private WebElement noContent;
    @FindBy(xpath = "//a[@id = 'moved']")
    private WebElement moved;
    @FindBy(xpath = "//a[@id = 'bad-request']")
    private WebElement badRequest;
    @FindBy(xpath = "//a[@id = 'unauthorized']")
    private WebElement unauthorized;
    @FindBy(xpath = "//a[@id = 'forbidden']")
    private WebElement forbidden;
    @FindBy(xpath = "//a[@id = 'invalid-url']")
    private WebElement invalidUrl;
    @FindBy(xpath = "//div[@class ='body-height']")
    public WebElement bodyHeight;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Created')] ")
    public WebElement statusTextCreated;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'No Content')] ")
    public WebElement statusTextNoContent;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Moved Permanently')] ")
    public WebElement statusTextMovedPermanently;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Bad Request')] ")
    public WebElement statusTextBadRequest;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Unauthorized')] ")
    public WebElement statusTextUnauthorized;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Forbidden')] ")
    public WebElement statusTextForbidden;
    @FindBy(xpath = "//p[@id = 'linkResponse' and contains(.,'Not Found')] ")
    public WebElement statusTextNotFound;

    private WebElement getCheckBox(String name) {
        return driver.findElement(By.xpath("//label[contains(@for, 'tree-node-" + name + "')]"));
    }

    public void clickCheckBox(String checkBoxName) {
        getCheckBox(checkBoxName).click();
    }

    private WebDriver driver;

    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickMenuTextBox() {
        textBox.click();
    }

    public void clickButtonSubmit() {
        submit.click();
    }

    public void fillForm(String name, String email, String current, String permanent) {
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        currentAddress.sendKeys(current);
        permanentAddress.sendKeys(permanent);
    }

    public void clickMenuCheckBox() {
        checkBox.click();
    }

    public void clickCheckBoxExpandAll() {
        expandAll.click();
    }

    public void clickMenuRadioButton() {
        radioButton.click();
    }

    public void clickYesRadioButton() {
        yesRadio.click();
    }

    public void clickImpressiveRadioButton() {
        impressiveRadio.click();
    }

    public void clickMenuWebTables() {
        webTables.click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void fillTablesForm(User user) {
        sendText(userTablesFirstName, user.getFirstName());
        sendText(userTablesLastName, user.getLastName());
        sendText(userTablesEmail, user.getEmail());
        sendText(userTablesAge, user.getAge());
        sendText(userTablesSalary, user.getSalary());
        sendText(userTablesDepartment, user.getDepartment());
    }

    public void clickTablesButtonSubmit() {
        submitForm.click();
    }

    public void clickMenuButtons() {
        buttons.click();
    }

    public void clickMeButton() {
        clickMeBtn.click();
    }

    public void clickMenuLinks() {
        links.click();
    }

    public void clickSimpleLink() {
        simpleLink.click();
    }

    public void clickDynamicLink() {
        dynamicLink.click();
    }

    public void clickCreatedLinks() {
        created.click();
    }

    public void clickNoContentLink() {
        noContent.click();
    }

    public void clickMovedLink() {
        moved.click();
    }

    public void clickBadRequestLink() {
        badRequest.click();
    }

    public void clickUnauthorizedLink() {
        unauthorized.click();
    }

    public void clickForbiddenLink() {
        forbidden.click();
    }

    public void clickInvalidUrlLink() {
        invalidUrl.click();
    }

}