package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(xpath = "//div[contains(@class, 'card mt-4 top-card') and .='Elements']")
    public WebElement elements;

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public  void clickCategoryCards() {
        elements.click();
    }
}
