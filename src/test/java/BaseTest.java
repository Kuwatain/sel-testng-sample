import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public ElementsPage elementsPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
        elementsPage = new ElementsPage(driver);

    }

//    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
