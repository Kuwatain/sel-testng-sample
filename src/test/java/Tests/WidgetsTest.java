package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

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

        widgetsPage.getTextElement("Red");
        widgetsPage.getTextElement("Aqua");
        widgetsPage.getTextElement("White");

        widgetsPage.clickRemoveElement("White");
        widgetsPage.clickRemoveElement("Red");
        widgetsPage.getTextElement("Aqua");

        widgetsPage.clickClearIndicator();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'multi-value__label')]")));

        widgetsPage.sendKeysAndClickMultipleInput("t", "Magenta");
        widgetsPage.sendKeysAndClickMultipleInput("o", "Indigo");
        widgetsPage.getTextElement("Magenta");
        widgetsPage.getTextElement("Indigo");

        widgetsPage.sendKeysAndClickSingleInput("b", "Black");
        assertTrue(widgetsPage.containerIsSingle.getText().contains("Black"));

        widgetsPage.sendKeysAndClickSingleInput("h", "White");
        assertTrue(widgetsPage.containerIsSingle.getText().contains("White"));
    }

    @Test
    public void datePickerTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.datePicker);

        widgetsPage.enterDatePickerMonthYearInput("03/08/1998");
        wait.until(ExpectedConditions.attributeContains(widgetsPage.datePickerMonthYearInput, "value", "03/08/1998"));

        widgetsPage.enterDateAndTimePickerInput("March 8, 1998 2:30 PM");
        wait.until(ExpectedConditions.attributeContains(widgetsPage.dateAndTimePickerInput, "value", "March 8, 1998 2:30 PM"));
    }

    @Test
    public void sliderTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.slider);

        var width = widgetsPage.sliderElement.getSize().getWidth();
        actions.clickAndHold(widgetsPage.sliderElement).moveByOffset(-(width / 2), 0).perform();
        for (int i = 0; i < 77; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.perform();

        wait.until(ExpectedConditions.attributeContains(widgetsPage.sliderValue, "value", "77"));
    }
}