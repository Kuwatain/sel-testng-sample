import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    public List<WebElement> displayResult;

    private WebElement getCheckBox(String name) {
        return BaseTest.getDriver().findElement(By.xpath("//label[contains(@for, 'tree-node-" + name + "')]"));
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
}