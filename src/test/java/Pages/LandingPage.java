package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(xpath = "//div[contains(@class, 'card mt-4 top-card') and .='Elements']")
    public WebElement elements;
    @FindBy(xpath = "//div[contains(@class, 'card mt-4 top-card') and .='Forms']")
    public WebElement forms;
    @FindBy(xpath = "//div[contains(@class, 'card mt-4 top-card') and .='Alerts, Frame & Windows']")
    public WebElement alertsFrameWindows;
    @FindBy(xpath = "//div[contains(@class, 'card mt-4 top-card') and .='Widgets']")
    public WebElement widgets;

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickCategoryCardsElements() {
        elements.click();
    }

    public void clickCategoryCardsForms() {
        forms.click();
    }

    public void clickCategoryCardsAlertsFrameWindows() {
        alertsFrameWindows.click();
    }

    public void clickCategoryCardsWidgets() {
        widgets.click();
    }
}
