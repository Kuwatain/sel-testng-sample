package Pages;

import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Tests.BaseTest.sendText;

public class FormsPage {
    @FindBy(xpath = "//li[contains(., 'Practice Form')]")
    public WebElement practiceForm;

    @FindBy(xpath = "//input[@id = 'firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastName;
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

    //TODO написать хелпер у дня должны быть условия 1,2,3
    @FindBy(xpath = "//input[@id = 'dateOfBirthInput']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month-container']")
    public WebElement calendar;
    @FindBy(xpath = "//select[@class = 'react-datepicker__year-select'] / option[@value = '1998']")
    private WebElement calendarYear;
    @FindBy(xpath = "//select[@class = 'react-datepicker__month-select'] / option[@value = '2']")
    private WebElement calendarMonth;
    @FindBy(xpath = "//div[contains(@aria-label, 'March 8th')]")
    private WebElement calendarDay;

    @FindBy(xpath = "//input[@id = 'subjectsInput']")
    private WebElement subjectsInput;
    @FindBy(xpath = "//div[contains(@id, 'react-select')]")
    private List<WebElement> dropDawnMenu;

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

    public void fillRegistrationForm(User user) {
        sendText(firstName, user.getFirstName());
        sendText(lastName, user.getLastName());
        sendText(userEmail, user.getEmail());
        sendText(userNumber, user.getNumber());
        sendText(currentAddress, user.getCurrentAddress());
    }

    public void clickRadioMale() {
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

    public void clickCalendarYear() {
        calendarYear.click();
    }

    public void clickCalendarMonth() {
        calendarMonth.click();
    }

    public void clickCalendarDay() {
        calendarDay.click();
    }

    public void sendKeysAndClickSubjects(String send, int index) {
        subjectsInput.sendKeys(send);
        dropDawnMenu.get(index).click();
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

    public void clickAndChoiceState(int index) {
        dropDawnState.click();
        dropDawnMenu.get(index).click();
    }

    public void clickAndChoiceCity(int index) {
        dropDawnCity.click();
        dropDawnMenu.get(index).click();
    }

    public void clickCloseLargeModal() {
        closeLargeModal.click();
    }
    
    public void assertLargeTable(User user) {
        assertEquals(tableHelper.getStudentName(), "Nikita Rachkov");
        assertEquals(tableHelper.getStudentEmail(), "nikita@gmail.com");
        assertEquals(tableHelper.getGender(), "Male");
        assertEquals(tableHelper.getMobile(), "9655857796");
        assertEquals(tableHelper.getDateOfBirth(), "08 March,1998");
        assertEquals(tableHelper.getSubjects(), "Social Studies, Biology, Civics, Hindi");
        assertEquals(tableHelper.getHobbies(), "Sports, Reading, Music");
        assertEquals(tableHelper.getPicture(), "BaseTest.java");
        assertEquals(tableHelper.getAddress(), "Kazan");
        assertEquals(tableHelper.getStateAndCity(), "NCR Delhi");
    }
}
