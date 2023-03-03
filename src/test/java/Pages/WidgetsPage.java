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
    @FindBy(xpath = "//li[contains(., 'Slider')]")
    public WebElement slider;
    @FindBy(xpath = "//li[contains(., 'Progress Bar')]")
    public WebElement progressBar;
    @FindBy(xpath = "//li[contains(., 'Tabs')]")
    public WebElement tabs;
    @FindBy(xpath = "//li[contains(., 'Tool Tips')]")
    public WebElement toolTips;

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

    @FindBy(xpath = "//input[@type = 'range']")
    public WebElement sliderElement;
    @FindBy(xpath = "//input[@id= 'sliderValue']")
    public WebElement sliderValue;

    @FindBy(xpath = "//div[@role = 'progressbar']")
    public WebElement progressbar;

    @FindBy(xpath = "//a[@id = 'demo-tab-what']")
    private WebElement tabWhat;
    @FindBy(xpath = "//a[@id = 'demo-tab-origin']")
    private WebElement tabOrigin;
    @FindBy(xpath = "//a[@id = 'demo-tab-use']")
    private WebElement tabUse;

    @FindBy(xpath = "//div[@id = 'demo-tabpane-what']")
    public WebElement tabpaneWhat;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-origin']")
    public WebElement tabpaneOrigin;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-use']")
    public WebElement tabpaneUse;

    @FindBy(xpath = "//button[@id = 'toolTipButton']")
    public WebElement toolTipButton;
    @FindBy(xpath = "//input[@id = 'toolTipTextField']")
    public WebElement toolTipTextField;
    @FindBy(xpath = "//a[text() = 'Contrary']")
    public WebElement toolTipContrary;
    @FindBy(xpath = "//a[text() = '1.10.32']")
    public WebElement toolTipSection;

    @FindBy(xpath = "//div[@id = 'buttonToolTip']/div[@class = 'tooltip-inner']")
    public WebElement buttonToolTip;
    @FindBy(xpath = "//div[@id = 'textFieldToolTip']/div[@class = 'tooltip-inner']")
    public WebElement textFieldToolTip;
    @FindBy(xpath = "//div[@id = 'contraryTexToolTip']/div[@class = 'tooltip-inner']")
    public WebElement contraryTexToolTip;
    @FindBy(xpath = "//div[@id = 'sectionToolTip']/div[@class = 'tooltip-inner']")
    public WebElement sectionToolTip;

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

    public WebElement getTextButton(String name) {
        return wait.until(presenceOfElementLocated(
                By.xpath("//button[@type= 'button' and text() ='" + name + "']")
        ));
    }

    public void clickButtonText(String text) {
        getTextButton(text).click();
    }

    public void clickTabWhat() {
        tabWhat.click();
    }

    public void clickTabOrigin() {
        tabOrigin.click();
    }

    public void clickTabUse() {
        tabUse.click();
    }

    private WebDriver driver;

    public WidgetsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}