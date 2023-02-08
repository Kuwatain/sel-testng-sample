import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    protected ElementsPage elementsPage;
    protected LandingPage landingPage;

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        driverThread.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        elementsPage = new ElementsPage(getDriver());
        landingPage = new LandingPage(getDriver());
    }

    @AfterMethod
    public void afterMethod() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
        }
    }
}
