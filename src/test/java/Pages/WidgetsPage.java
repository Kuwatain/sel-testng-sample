package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Tests.BaseTest.wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class WidgetsPage {
    @FindBy(xpath = "//li[contains(., 'Accordian')]")
    public WebElement accordian;
    @FindBy(xpath = "//li[contains(., 'Auto Complete')]")
    public WebElement autoComplete;
    @FindBy(xpath = "//li[contains(., 'Date Picker')]")
    public WebElement datePicker;

    @FindBy(xpath = "//div[@id = 'section1Heading']")
    private WebElement section1Heading;
    @FindBy(xpath = "//div[@id = 'section2Heading']")
    private WebElement section2Heading;
    @FindBy(xpath = "//div[@id = 'section3Heading']")
    private WebElement section3Heading;

    @FindBy(xpath = "//input[@id = 'autoCompleteMultipleInput']")
    private WebElement autoCompleteMultipleInput;
    @FindBy(xpath = "//input[@id = 'autoCompleteSingleInput']")
    private WebElement autoCompleteSingleInput;
    @FindBy(xpath = "//div[contains(@class, 'clear-indicator')]")
    private WebElement clearIndicator;
    @FindBy(xpath = "//div[@id = 'autoCompleteSingleContainer']")
    public WebElement containerIsSingle;

    @FindBy(xpath = "//input[@id = 'datePickerMonthYearInput']")
    public WebElement datePickerMonthYearInput;
    @FindBy(xpath = "//input[@id = 'dateAndTimePickerInput']")
    public WebElement dateAndTimePickerInput;

    public WebElement getSectionCollapseShow(String name) {
        return wait.until(presenceOfElementLocated(
                By.xpath("//div[@class = 'card-header' and text() = '" + name + "']//following-sibling::div[@class= 'collapse show']")
        ));
    }

    public WebElement getSectionCollapse(String name) {
        return wait.until(presenceOfElementLocated(
                By.xpath("//div[@class = 'card-header' and text() = '" + name + "']//following-sibling::div[@class= 'collapse']")
        ));
    }

    public void clickSection1Heading() {
        section1Heading.click();
    }

    public void clickSection2Heading() {
        section2Heading.click();
    }

    public void clickSection3Heading() {
        section3Heading.click();
    }

    private WebElement getElementDropDownMenu(String name) {
        return wait.until(presenceOfElementLocated(
                By.xpath("//div[contains(@id, 'react-select') and .='" + name + "']")
        ));
    }

    public void sendKeysAndClickMultipleInput(String send, String completeOption) {
        autoCompleteMultipleInput.sendKeys(send);
        getElementDropDownMenu(completeOption).click();
    }

    public void sendKeysAndClickSingleInput(String send, String completeOption) {
        autoCompleteSingleInput.sendKeys(send);
        getElementDropDownMenu(completeOption).click();
    }

    private WebElement getRemoveElement(String name) {
        return wait.until(presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'label') and (text() = '" + name + "')]//following-sibling::div[contains(@class, 'remove')]")
        ));
    }

    public void clickRemoveElement(String removeElement) {
        getRemoveElement(removeElement).click();
    }

    public void clickClearIndicator() {
        clearIndicator.click();
    }

    private WebElement getElement(String getElement) {
        return driver.findElement(By.xpath("//div[contains(@class, 'multi-value__label') and (text()= '" + getElement + "')]"));
    }

    public String getTextElement(String text) {
        return getElement(text).getText();
    }

    public void enterDatePickerMonthYearInput(String datePicker) {
        datePickerMonthYearInput.sendKeys(Keys.CONTROL + "A");
        datePickerMonthYearInput.sendKeys(Keys.BACK_SPACE);
        datePickerMonthYearInput.sendKeys(datePicker);
        datePickerMonthYearInput.sendKeys(Keys.ENTER);
    }

    public void enterDateAndTimePickerInput(String dateAndTimePicker) {
        dateAndTimePickerInput.sendKeys(Keys.CONTROL + "A");
        dateAndTimePickerInput.sendKeys(Keys.BACK_SPACE);
        dateAndTimePickerInput.sendKeys(dateAndTimePicker);
        dateAndTimePickerInput.sendKeys(Keys.ENTER);
    }

    private WebDriver driver;

    public WidgetsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}