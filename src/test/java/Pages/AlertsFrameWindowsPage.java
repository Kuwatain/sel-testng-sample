package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsPage {
    @FindBy(xpath = "//li[contains(., 'Browser Windows')]")
    public WebElement browserWindows;

    @FindBy(xpath = "//button[@id = 'tabButton']")
    private WebElement tabButton;
    @FindBy(xpath = "//button[@id = 'windowButton']")
    private WebElement windowButton;
    @FindBy(xpath = "//button[@id = 'messageWindowButton']")
    private WebElement messageWindowButton;

    @FindBy(xpath = "//h1[@id = 'sampleHeading']")
    public WebElement sampleHeading;

    public void clickTabButton() {
        tabButton.click();
    }

    public void clickWindowButton() {
        windowButton.click();
    }

    private WebDriver driver;

    public AlertsFrameWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}