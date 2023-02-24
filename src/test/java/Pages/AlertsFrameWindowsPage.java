package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsPage {
    @FindBy(xpath = "//li[contains(., 'Browser Windows')]")
    public WebElement browserWindows;
    @FindBy(xpath = "//li[contains(., 'Alerts')]")
    public WebElement alerts;
    @FindBy(xpath = "//li[contains(., 'Frames')]")
    public WebElement frames;

    @FindBy(xpath = "//button[@id = 'tabButton']")
    private WebElement tabButton;
    @FindBy(xpath = "//button[@id = 'windowButton']")
    private WebElement windowButton;
    @FindBy(xpath = "//button[@id = 'messageWindowButton']")
    private WebElement messageWindowButton;

    @FindBy(xpath = "//h1[@id = 'sampleHeading']")
    public WebElement sampleHeading;

    @FindBy(xpath = "//button[@id = 'alertButton']")
    private WebElement alertButton;
    @FindBy(xpath = "//button[@id = 'timerAlertButton']")
    private WebElement timerAlertButton;
    @FindBy(xpath = "//button[@id = 'confirmButton']")
    private WebElement confirmButton;
    @FindBy(xpath = "//button[@id = 'promtButton']")
    private WebElement promptButton;

    @FindBy(xpath = "//span[@id = 'confirmResult']")
    public WebElement confirmResult;
    @FindBy(xpath = "//span[@id = 'promptResult']")
    public WebElement promptResult;

    public void clickTabButton() {
        tabButton.click();
    }

    public void clickWindowButton() {
        windowButton.click();
    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public void clickTimerAlertButton() {
        timerAlertButton.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void clickPromptButton() {
        promptButton.click();
    }

    private WebDriver driver;

    public AlertsFrameWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}