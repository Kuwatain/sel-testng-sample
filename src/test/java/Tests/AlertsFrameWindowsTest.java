package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AlertsFrameWindowsTest extends BaseTest {
    @Test
    public void browserWindowsTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsAlertsFrameWindows();

        clickJS(alertsFrameWindowsPage.browserWindows);

        alertsFrameWindowsPage.clickTabButton();
        opensTabById(1);
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.sampleHeading,
                "This is a sample page"));

        opensTabById(0);
        alertsFrameWindowsPage.clickWindowButton();

        opensTabById(2);
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.sampleHeading,
                "This is a sample page"));
    }
}
