package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
    @FindBy(xpath = "//li[contains(., 'Practice Form')]")
    public WebElement practiceForm;

    @FindBy(xpath = "//input[@id = 'firstName']")
    private WebElement userFirstName;
    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement userLastName;
    @FindBy(xpath = "//input[@id = 'userEmail']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@id = 'userNumber']")
    private WebElement userNumber;
    @FindBy(xpath = "//textarea[@id = 'currentAddress']")
    private WebElement currentAddress;

    @FindBy(xpath = "//label[@for = 'gender-radio-1']")
    private WebElement radioMale;
    @FindBy(xpath = "//label[@for = 'gender-radio-2']")
    private WebElement radioFemale;
    @FindBy(xpath = "//label[@for = 'gender-radio-3']")
    private WebElement radioOther;

    @FindBy(xpath = "//input[@id = 'dateOfBirthInput']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id = 'subjectsInput']")
    private WebElement subjectsInput;
    @FindBy(xpath = "//div[contains(@class, 'subjects-auto-complete__clear')]")
    private WebElement clearSubjects;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-1']")
    private WebElement checkBoxSports;
    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-2']")
    private WebElement checkBoxReading;
    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-3']")
    private WebElement checkBoxMusic;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//div[@id = 'state']")
    private WebElement dropDawnState;
    @FindBy(xpath = "//div[@id = 'city']")
    private WebElement dropDawnCity;

    @FindBy(xpath = "//button[@id = 'submit']")
    public WebElement submit;

    @FindBy(xpath = "//button[@id ='closeLargeModal']")
    private WebElement closeLargeModal;

    private WebDriver driver;

    public FormsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        userFirstName.clear();
        userFirstName.sendKeys(firstName);
    }

    public void enterKeysLastName(String lastName) {
        userLastName.clear();
        userLastName.sendKeys(lastName);
    }

    public void enterKeysUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public void sendKeysUserNumber(String number) {
        userNumber.clear();
        userNumber.sendKeys(number);
    }

    public void sendKeysCurrentAddress(String address) {
        currentAddress.clear();
        currentAddress.sendKeys(address);
    }

    public void clickRadioButtonMale() {
        radioMale.click();
    }

    public void clickRadioFemale() {
        radioFemale.click();
    }

    public void clickRadioOther() {
        radioOther.click();
    }

    public void clickDateOfBirth() {
        dateOfBirth.click();
    }

    private WebElement getElementDropDownMenu(String name) {
        return driver.findElement(By.xpath("//div[contains(@id, 'react-select') and .='" + name + "']"));
    }

    public void sendKeysAndClickSubjects(String send, String subjectsName) {
        subjectsInput.sendKeys(send);
        getElementDropDownMenu(subjectsName).click();
    }

    private WebElement getRemoveSubjectElement(String name) {
        return driver.findElement(By.xpath("//div[contains(@ class, 'multi-value__label') and (text() = '" + name + "')]//following-sibling::div[contains(@ class, 'remove')]"));
    }

    public void clickRemoveSubjectsElement(String subjectsRemove) {
        getRemoveSubjectElement(subjectsRemove).click();
    }

    public void clickClearAllSubjects() {
        clearSubjects.click();
    }

    public void clickCheckBoxSports() {
        checkBoxSports.click();
    }

    public void clickCheckBoxReading() {
        checkBoxReading.click();
    }

    public void clickCheckBoxMusic() {
        checkBoxMusic.click();
    }

    public void clickAndChoiceState(String stateName) {
        dropDawnState.click();
        getElementDropDownMenu(stateName).click();
    }

    public void clickAndChoiceCity(String cityName) {
        dropDawnCity.click();
        getElementDropDownMenu(cityName).click();
    }

    public void clickCloseLargeModal() {
        closeLargeModal.click();
    }

    public String getStudentName() {
        return driver.findElement(By.xpath("//tr[contains(., 'Student Name')] // td[2]")).getText();
    }

    public String getStudentEmail() {
        return driver.findElement(By.xpath("//tr[contains(., 'Student Email')] // td[2]")).getText();
    }

    public String getGender() {
        return driver.findElement(By.xpath("//tr[contains(., 'Gender')] // td[2]")).getText();
    }

    public String getMobile() {
        return driver.findElement(By.xpath("//tr[contains(., 'Mobile')] // td[2]")).getText();
    }

    public String getDateOfBirth() {
        return driver.findElement(By.xpath("//tr[contains(., 'Date of Birth')] // td[2]")).getText();
    }

    public String getSubjects() {
        return driver.findElement(By.xpath("//tr[contains(., 'Subjects')] // td[2]")).getText();
    }

    public String getHobbies() {
        return driver.findElement(By.xpath("//tr[contains(., 'Hobbies')] // td[2]")).getText();
    }

    public String getPicture() {
        return driver.findElement(By.xpath("//tr[contains(., 'Picture')] // td[2]")).getText();
    }

    public String getAddress() {
        return driver.findElement(By.xpath("//tr[contains(., 'Address')] // td[2]")).getText();
    }

    public String getStateAndCity() {
        return driver.findElement(By.xpath("//tr[contains(., 'State and City')] // td[2]")).getText();
    }

    public String borderColorFirstName() {
        return userFirstName.getCssValue("border-color");
    }

    public String borderColorLastName() {
        return userLastName.getCssValue("border-color");
    }

    public String borderColorEmail() {
        return userEmail.getCssValue("border-color");
    }

    public String borderColorNumber() {
        return userNumber.getCssValue("border-color");
    }

    public String borderColorCurrentAddress() {
        return currentAddress.getCssValue("border-color");
    }

    public String borderColorRadioMale() {
        return radioMale.getCssValue("border-color");
    }

    public String borderColorRadioFemale() {
        return radioFemale.getCssValue("border-color");
    }

    public String borderColorRadioOther() {
        return radioOther.getCssValue("border-color");
    }

    public String borderColorDateOfBirth() {
        return dateOfBirth.getCssValue("border-color");
    }

    public String borderColorCheckBoxSports() {
        return checkBoxSports.getCssValue("border-color");
    }

    public String borderColorCheckBoxMusic() {
        return checkBoxMusic.getCssValue("border-color");
    }

    public String borderColorCheckBoxReading() {
        return checkBoxReading.getCssValue("border-color");
    }
}