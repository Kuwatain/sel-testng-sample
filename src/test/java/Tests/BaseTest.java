package Tests;

import Helpers.TableHelper;
import Pages.ElementsPage;
import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public ElementsPage elementsPage;
    TableHelper tableHelper;
    Actions actions;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);
        elementsPage = new ElementsPage(driver);
        tableHelper = new TableHelper(driver);

        actions = new Actions(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }
}
