package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WidgetsTest extends BaseTest {
    @Test
    public void accordianTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.accordian);

        widgetsPage.clickSection1Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapse, "class", "collapse"));

        widgetsPage.clickSection1Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapseShow, "class", "collapse show"));

        widgetsPage.clickSection2Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapseShow, "class", "collapse show"));

        widgetsPage.clickSection2Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapse, "class", "collapse"));

        widgetsPage.clickSection3Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapseShow, "class", "collapse show"));

        widgetsPage.clickSection3Heading();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.collapse, "class", "collapse"));
    }
}
