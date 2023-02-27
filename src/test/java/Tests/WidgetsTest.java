package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class WidgetsTest extends BaseTest {
    @Test
    public void accordianTest() {

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

    @Test
    public void autoCompleteTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.autoComplete);

        widgetsPage.sendKeysAndClickMultipleInput("e", "Red");
        widgetsPage.sendKeysAndClickMultipleInput("q", "Aqua");
        widgetsPage.sendKeysAndClickMultipleInput("w", "White");
        assertEquals(widgetsPage.containerIsMulti.getText(),
                "Red\n" +
                        "Aqua\n" +
                        "White");

        widgetsPage.clickRemoveElement("White");
        widgetsPage.clickRemoveElement("Red");
        assertEquals(widgetsPage.containerIsMulti.getText(), "Aqua");


        widgetsPage.clickClearIndicator();
        assertEquals(widgetsPage.containerIsMulti.getText(), "");

        widgetsPage.sendKeysAndClickMultipleInput("t", "Magenta");
        widgetsPage.sendKeysAndClickMultipleInput("o", "Indigo");
        assertEquals(widgetsPage.containerIsMulti.getText(),
                "Magenta\n" +
                        "Indigo");

        widgetsPage.sendKeysAndClickSingleInput("b", "Black");
        assertEquals(widgetsPage.containerIsSingle.getText(), "Black");

        widgetsPage.sendKeysAndClickSingleInput("h", "White");
        assertEquals(widgetsPage.containerIsSingle.getText(), "White");
    }
}