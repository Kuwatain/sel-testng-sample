package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Test
    public void progressBarTest() throws InterruptedException {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.progressBar);

        widgetsPage.clickButtonText("Start");
        Thread.sleep(5000);
        assertEquals(widgetsPage.progressbar.getText(), "50%");
        widgetsPage.clickButtonText("Stop");

        widgetsPage.clickButtonText("Start");
        Thread.sleep(5000);
        assertEquals(widgetsPage.progressbar.getText(), "100%");

        widgetsPage.clickButtonText("Reset");
        Thread.sleep(10000);
        assertEquals(widgetsPage.progressbar.getText(), "100%");
    }

    @Test
    public void tabsTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.tabs);

        widgetsPage.clickTabOrigin();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.tabpaneOrigin, "aria-hidden", "false"));

        widgetsPage.clickTabUse();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.tabpaneUse, "aria-hidden", "false"));

        widgetsPage.clickTabWhat();
        wait.until(ExpectedConditions.attributeToBe(widgetsPage.tabpaneWhat, "aria-hidden", "false"));
    }

    @Test
    public void toolTipsTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.toolTips);

        actions.moveToElement(widgetsPage.toolTipButton).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(widgetsPage.buttonToolTip, "You hovered over the Button"));

        actions.moveToElement(widgetsPage.toolTipTextField).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(widgetsPage.textFieldToolTip, "You hovered over the text field"));

        actions.moveToElement(widgetsPage.toolTipContrary).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(widgetsPage.contraryTexToolTip, "You hovered over the Contrary"));

        actions.moveToElement(widgetsPage.toolTipSection).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(widgetsPage.sectionToolTip, "You hovered over the 1.10.32"));
    }

    @Test
    public void menuTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.menu);

        actions.moveToElement(widgetsPage.getTextMenu("Main Item 2")).build().perform();
        widgetsPage.getTextMenu("Sub Item");

        actions.moveToElement(widgetsPage.getTextMenu("SUB SUB LIST")).build().perform();

        actions.moveToElement(widgetsPage.getTextMenu("Sub Sub Item 1")).build().perform();
        actions.moveToElement(widgetsPage.getTextMenu("Sub Sub Item 2")).build().perform();
    }

    @Test
    public void selectMenuTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsWidgets();

        clickJS(widgetsPage.selectMenu);

        widgetsPage.clickWithOptGroup();
        widgetsPage.clickSelectOption("A root option");
        assertTrue(widgetsPage.getTextWithOptGroup().contains("A root option"));

        widgetsPage.clickSelectOne();
        widgetsPage.clickSelectOption("Mrs.");
        assertTrue(widgetsPage.getTextSelectOne().contains("Mrs"));

        widgetsPage.clickOldSelectMenu();
        widgetsPage.clickOldSelect("Black");
        widgetsPage.getTextOldSelect("Black");

        widgetsPage.clickMultiSelectMenu();
        widgetsPage.clickMultiSelect("Green");
        widgetsPage.clickMultiSelect("Red");
        widgetsPage.clickMultiSelect("Blue");
        widgetsPage.clickRemoveElementMultiSelect("Green");
        widgetsPage.getTextElementMultiSelect("Red");
        widgetsPage.getTextElementMultiSelect("Blue");
        widgetsPage.clickIndicatorContainer();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'multiValue')]")));
        widgetsPage.clickMultiSelectMenu();
        widgetsPage.clickMultiSelect("Black");
        widgetsPage.getTextElementMultiSelect("Black");

        widgetsPage.clickElementStandard("Saab");
        String blue = "rgba(30, 144, 255, 1)";
        String white = "rgba(255, 255, 255, 1)";
        assertEquals(widgetsPage.backgroundColorElementStandard("Saab"), blue);
        assertEquals(widgetsPage.colorElementStandard("Saab"), white);
    }
}