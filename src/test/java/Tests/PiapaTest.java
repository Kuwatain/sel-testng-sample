package Tests;

import DataProviders.DataProviders;
import Model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class PiapaTest extends BaseTest {

    @Test(dataProvider = "Form Params", dataProviderClass = DataProviders.class)
    public void piapaTest(String name, String email, String current, String permanent) {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuTextBox();
        elementsPage.fillForm(name, email, current, permanent);
        elementsPage.clickButtonSubmit();

        assertEquals(elementsPage.resultName.getText(), "Name:" + name);
        assertEquals(elementsPage.resultEmail.getText(), "Email:" + email);
        assertEquals(elementsPage.resultCurrentAddress.getText(), "Current Address :" + current);
        assertEquals(elementsPage.resultPermanentAddress.getText(), "Permananet Address :" + permanent);
    }

    @Test(dataProvider = "Check Box Params", dataProviderClass = DataProviders.class)
    public void checkBoxTest(String[] checkBox) {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuCheckBox();
        elementsPage.clickCheckBoxExpandAll();

        for (int i = 0; i < checkBox.length; i++) {
            elementsPage.clickCheckBox(checkBox[i]);
            assertTrue(elementsPage.displayResultCheckBox.get(0).getText().contains(checkBox[i]));
            elementsPage.clickCheckBox(checkBox[i]);
            assertEquals(elementsPage.displayResultCheckBox.size(), 0);
        }
    }

    @Test
    public void radioButtonTest() {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuRadioButton();

        elementsPage.clickYesRadioButton();
        assertEquals(elementsPage.displayResultRadioButton.getText(), "You have selected Yes");
        elementsPage.clickImpressiveRadioButton();
        assertEquals(elementsPage.displayResultRadioButton.getText(), "You have selected Impressive");
        assertFalse(elementsPage.noRadio.isEnabled());
    }

    @Test(dataProvider = "Web Tables Params", dataProviderClass = DataProviders.class)
    public void webTablesTest(User userNikita, User userStepan) {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuWebTables();
        elementsPage.clickAddButton();
        elementsPage.fillTablesForm(userNikita);
        elementsPage.clickTablesButtonSubmit();

        WebElement rowNikita = tableHelper.findRow(userNikita.getEmail()).get(0);
        assertRowUser(userNikita, rowNikita);

        tableHelper.clickEditRecord(rowNikita);

        elementsPage.fillTablesForm(userStepan);
        elementsPage.clickTablesButtonSubmit();

        WebElement rowStepan = tableHelper.findRow(userStepan.getEmail()).get(0);
        assertRowUser(userStepan, rowStepan);

        elementsPage.searchBoxForm.sendKeys(userStepan.getEmail());

        assertNotNull(tableHelper.findRow(userStepan.getEmail()));

        elementsPage.searchBoxForm.sendKeys(Keys.CONTROL + "A");
        elementsPage.searchBoxForm.sendKeys(Keys.BACK_SPACE);
        WebElement rowStepanNow = tableHelper.findRow(userStepan.getEmail()).get(0);
        tableHelper.clickDeleteRecord(rowStepanNow);
        Assert.assertEquals(tableHelper.findRow(userStepan.getEmail()).size(), 0);

        assertEquals(tableHelper.findRow(userStepan.getEmail()).size(), 0);
    }

    private void assertRowUser(User user, WebElement row) {
        Assert.assertEquals(tableHelper.getFirstName(row), user.getFirstName());
        Assert.assertEquals(tableHelper.getLastName(row), user.getLastName());
        Assert.assertEquals(tableHelper.getAge(row), user.getAge());
        Assert.assertEquals(tableHelper.getEmail(row), user.getEmail());
        Assert.assertEquals(tableHelper.getSalary(row), user.getSalary());
        Assert.assertEquals(tableHelper.getDepartment(row), user.getDepartment());
    }

    @Test
    public void buttonsTest() {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        elementsPage.clickMenuButtons();

        doubleClick(elementsPage.doubleClickBtn);
        rightClick(elementsPage.rightClickBtn);
        elementsPage.clickMeButton();

        assertEquals(elementsPage.doubleClickMessage.getText(), "You have done a double click");
        assertEquals(elementsPage.rightClickMessage.getText(), "You have done a right click");
        assertEquals(elementsPage.dynamicClickMessage.getText(), "You have done a dynamic click");
    }

    @Test
    public void linksTest() throws InterruptedException {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        elementsPage.clickMenuLinks();

        elementsPage.clickSimpleLink();

        opensTabById(1);
        assertTrue(landingPage.elements.isDisplayed());
        driver.close();
        opensTabById(0);

        elementsPage.clickDynamicLink();
        opensTabById(1);
        assertTrue(landingPage.elements.isDisplayed());
        driver.close();
        opensTabById(0);

        elementsPage.clickCreatedLinks();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 201 and status text Created");

        elementsPage.clickNoContentLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 204 and status text No Content");

        elementsPage.clickMovedLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 301 and status text Moved Permanently");

        elementsPage.clickBadRequestLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 400 and status text Bad Request");

        elementsPage.clickUnauthorizedLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 401 and status text Unauthorized");

        elementsPage.clickForbiddenLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 403 and status text Forbidden");

        elementsPage.clickInvalidUrlLink();
        Thread.sleep(2000);
        assertEquals(elementsPage.getResponseMessage().getText(),
                "Link has responded with staus 404 and status text Not Found");
    }

    private void opensTabById(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}