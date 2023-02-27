package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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

        assertEquals(widgetsPage.getTextElement("Red"),"Red");
        assertEquals(widgetsPage.getTextElement("Aqua"),"Aqua");
        assertEquals(widgetsPage.getTextElement("White"),"White");

        widgetsPage.clickRemoveElement("White");
        widgetsPage.clickRemoveElement("Red");
        assertEquals(widgetsPage.getTextElement("Aqua"),"Aqua");

        widgetsPage.clickClearIndicator();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'multi-value__label')]")));

        widgetsPage.sendKeysAndClickMultipleInput("t", "Magenta");
        widgetsPage.sendKeysAndClickMultipleInput("o", "Indigo");
        assertEquals(widgetsPage.getTextElement("Magenta"),"Magenta");
        assertEquals(widgetsPage.getTextElement("Indigo"),"Indigo");

        widgetsPage.sendKeysAndClickSingleInput("b", "Black");
        assertTrue(widgetsPage.containerIsSingle.getText().contains("Black"));

        widgetsPage.sendKeysAndClickSingleInput("h", "White");
        assertTrue(widgetsPage.containerIsSingle.getText().contains("White"));
    }
}