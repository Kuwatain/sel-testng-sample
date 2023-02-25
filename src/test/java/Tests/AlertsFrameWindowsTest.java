package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

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

    @Test
    public void alertsTest() throws InterruptedException {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsAlertsFrameWindows();

        clickJS(alertsFrameWindowsPage.alerts);

        alertsFrameWindowsPage.clickAlertButton();
        Alert simpleAlert = driver.switchTo().alert();
        assertEquals(simpleAlert.getText(), "You clicked a button");
        simpleAlert.accept();

        alertsFrameWindowsPage.clickTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        assertEquals(timerAlert.getText(), "This alert appeared after 5 seconds");
        timerAlert.accept();

        alertsFrameWindowsPage.clickConfirmButton();
        Alert confirmationAlert = driver.switchTo().alert();
        assertEquals(confirmationAlert.getText(), "Do you confirm action?");
        confirmationAlert.accept();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.confirmResult, "Ok"));

        alertsFrameWindowsPage.clickConfirmButton();
        confirmationAlert.dismiss();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.confirmResult, "Cancel"));

        alertsFrameWindowsPage.clickPromptButton();
        Alert promptAlert = driver.switchTo().alert();
        assertEquals(promptAlert.getText(), "Please enter your name");
        promptAlert.sendKeys("Nikita");
        promptAlert.accept();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.promptResult, "Nikita"));
    }

    @Test
    public void framesTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsAlertsFrameWindows();

        clickJS(alertsFrameWindowsPage.frames);

        driver.switchTo().frame("frame1");
        assertEquals(alertsFrameWindowsPage.sampleHeading.getText(), "This is a sample page");

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");
        assertEquals(alertsFrameWindowsPage.sampleHeading.getText(), "This is a sample page");
    }

    @Test
    public void nestedFramesTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsAlertsFrameWindows();

        clickJS(alertsFrameWindowsPage.nestedFrames);

        driver.switchTo().frame("frame1");
        assertEquals(alertsFrameWindowsPage.parentFrameText.getText(), "Parent frame");

        driver.switchTo().frame(alertsFrameWindowsPage.childIframe);
        assertEquals(alertsFrameWindowsPage.childIframeText.getText(), "Child Iframe");

        driver.switchTo().defaultContent();
        assertEquals(alertsFrameWindowsPage.framesWrapper.getText(),
                "Sample Nested Iframe page. There are nested iframes in this page." +
                        " Use browser inspecter or firebug to check out the HTML source." +
                        " In total you can switch between the parent frame and the nested child frame.");

    }
}
