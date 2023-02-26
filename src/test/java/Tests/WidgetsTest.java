package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class WidgetsTest extends BaseTest {
    @Test
    public void accordianTest() throws InterruptedException {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.accordian);

        widgetsPage.clickSection1Heading();
        assertNotNull(widgetsPage.getSectionCollapse("What is Lorem Ipsum?"));

        widgetsPage.clickSection1Heading();
        assertNotNull(widgetsPage.getSectionCollapseShow("What is Lorem Ipsum?"));

        widgetsPage.clickSection2Heading();
        assertNotNull(widgetsPage.getSectionCollapseShow("Where does it come from?"));

        widgetsPage.clickSection2Heading();
        assertNotNull(widgetsPage.getSectionCollapse("Where does it come from?"));

        widgetsPage.clickSection3Heading();
        assertNotNull(widgetsPage.getSectionCollapseShow("Why do we use it?"));

        widgetsPage.clickSection3Heading();
        assertNotNull(widgetsPage.getSectionCollapse("Why do we use it?"));
    }
}
