package Tests;

import Helpers.CalendarHelper;
import Helpers.TableHelper;
import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public ElementsPage elementsPage;
    public FormsPage formsPage;
    public AlertsFrameWindowsPage alertsFrameWindowsPage;
    public WidgetsPage widgetsPage;
    public InteractionsPage interactionsPage;
    TableHelper tableHelper;
    public static Actions actions;
    public static WebDriverWait wait;
    CalendarHelper calendarHelper;

    @BeforeMethod
    public void beforeMethod() {
        String downloadDirVersion2 = System.getProperty("user.dir") + "\\src\\test\\java\\downloads";

        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDirVersion2);
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        opts.setExperimentalOption("prefs", prefs);
//        opts.addArguments("--headless");


        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        elementsPage = new ElementsPage(driver);
        formsPage = new FormsPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        widgetsPage = new WidgetsPage(driver);
        interactionsPage = new InteractionsPage(driver);
        tableHelper = new TableHelper(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        calendarHelper = new CalendarHelper(driver);
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

    public void deleteFilePicture(String filePath) {
        File file = new File(filePath);
        assert file.delete();
    }

    public void clickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
