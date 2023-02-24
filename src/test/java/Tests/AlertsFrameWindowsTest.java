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
        String alertMessageSimple = driver.switchTo().alert().getText();
        assertEquals(alertMessageSimple, "You clicked a button");
        simpleAlert.accept();

        alertsFrameWindowsPage.clickTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        String alertMessageTimer = driver.switchTo().alert().getText();
        assertEquals(alertMessageTimer, "This alert appeared after 5 seconds");
        timerAlert.accept();

        alertsFrameWindowsPage.clickConfirmButton();
        Alert confirmationAlert = driver.switchTo().alert();
        String alertMessageConfirmation = driver.switchTo().alert().getText();
        assertEquals(alertMessageConfirmation, "Do you confirm action?");
        confirmationAlert.accept();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.confirmResult, "Ok"));

        alertsFrameWindowsPage.clickConfirmButton();
        confirmationAlert.dismiss();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.confirmResult, "Cancel"));

        alertsFrameWindowsPage.clickPromptButton();
        Alert promptAlert = driver.switchTo().alert();
        String alertMessagePrompt = driver.switchTo().alert().getText();
        assertEquals(alertMessagePrompt, "Please enter your name");
        promptAlert.sendKeys("Nikita");
        promptAlert.accept();
        wait.until(ExpectedConditions.textToBePresentInElement(alertsFrameWindowsPage.promptResult, "Nikita"));
    }
}
