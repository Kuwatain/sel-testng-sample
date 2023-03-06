package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteractionsPage {
    @FindBy(xpath = "//li[contains(., 'Sortable')]")
    public WebElement sortable;
    @FindBy(xpath = "//a[@id = 'demo-tab-list']")
    private WebElement demoTabList;
    @FindBy(xpath = "//a[@id = 'demo-tab-grid']")
    private WebElement demoTabGrid;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-list']")
    public WebElement demoTabpaneList;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-grid']")
    public WebElement demoTabpaneGrid;


    public void clickDemoTabList() {
        demoTabList.click();
    }

    public void clickDemoTabGrid() {
        demoTabGrid.click();
    }

    public WebElement getVerticalListItem(String item) {
        return driver.findElement(By.xpath("//div[contains(@class, 'vertical-list-container')]/div[contains(@class, 'list-group-item') and (text() = '" + item + "')]"));
    }

    public WebElement getVerticalNumberListItem(String number) {
        return driver.findElement(By.xpath("//div[contains(@class, 'vertical-list-container')]/div[contains(@class, 'list-group-item')][" + number + "]"));
    }

    public WebElement getCreateGridListItem(String item) {
        return driver.findElement(By.xpath("//div[@class = 'create-grid']/div[contains(@class, 'list-group-item') and (text() = '" + item + "')]"));
    }

    public WebElement getCreateGridNumberListItem(String number) {
        return driver.findElement(By.xpath("//div[@class = 'create-grid']/div[contains(@class, 'list-group-item')][" + number + "]"));
    }

    private WebDriver driver;

    public InteractionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
