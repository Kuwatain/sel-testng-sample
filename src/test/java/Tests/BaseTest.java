package Tests;

import Helpers.TableHelper;
import Pages.ElementsPage;
import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public ElementsPage elementsPage;
    TableHelper tableHelper;
    Actions actions;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);
        elementsPage = new ElementsPage(driver);
        tableHelper = new TableHelper(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void opensTabById(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public static void deleteFilePicture(String args) {
        File file = new File("C:/Users/Nikita/Downloads/sampleFile.jpeg");
        if (file.delete()) {
            System.out.println("C:/Users/Nikita/Downloads/sampleFile.jpeg file deleted");
        } else
            System.out.println("File C:/Users/Nikita/Downloads/sampleFile.jpeg  not found");
    }
}
