import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driverThread.set(driver);
    }

    @AfterMethod
    public void afterMethod() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
        }
        driverThread.remove();
    }
}
