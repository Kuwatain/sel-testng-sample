package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {
    @FindBy(xpath = "//li[contains(., 'Accordian')]")
    public WebElement accordian;
    @FindBy(xpath = "//div[@id = 'section1Heading']")
    private WebElement section1Heading;
    @FindBy(xpath = "//div[@id = 'section2Heading']")
    private WebElement section2Heading;
    @FindBy(xpath = "//div[@id = 'section3Heading']")
    private WebElement section3Heading;

    @FindBy(xpath = "//div[@class = 'collapse show']")
    public WebElement collapseShow;
    @FindBy(xpath = "//div[@class = 'collapse']")
    public WebElement collapse;

    public void clickSection1Heading() {
        section1Heading.click();
    }

    public void clickSection2Heading() {
        section2Heading.click();
    }

    public void clickSection3Heading() {
        section3Heading.click();
    }

    private WebDriver driver;

    public WidgetsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
