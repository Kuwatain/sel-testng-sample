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
    @FindBy(xpath = "//li[contains(., 'Nested Frames')]")
    public WebElement nestedFrames;
    @FindBy(xpath = "//li[contains(., 'Modal Dialogs')]")
    public WebElement modalDialogs;


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

    @FindBy(xpath = "//body[text()]")
    public WebElement parentFrameText;
    @FindBy(xpath = "//p[text()]")
    public WebElement childIframeText;
    @FindBy(xpath = "//div[@id='framesWrapper']/div[text()]")
    public WebElement framesWrapper;
    @FindBy(xpath = "//iframe[@srcdoc = '<p>Child Iframe</p>']")
    public WebElement childIframe;

    @FindBy(xpath = "//button[@id = 'showSmallModal']")
    private WebElement showSmallModal;
    @FindBy(xpath = "//button[@id = 'showLargeModal']")
    private WebElement showLargeModal;
    @FindBy(xpath = "//div[@class ='modal-header']")
    public WebElement modalHeader;
    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    private WebElement close;

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

    public void clickShowSmallModal() {
        showSmallModal.click();
    }

    public void clickShowLargeModal() {
        showLargeModal.click();
    }

    public void clickClose() {
        close.click();
    }

    private WebDriver driver;

    public AlertsFrameWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}