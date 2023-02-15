package Tests;

import DataProviders.DataProviders;
import Model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PiapaTest extends BaseTest {

    @Test(dataProvider = "Form Params", dataProviderClass = DataProviders.class)
    public void piapaTest(String name, String email, String current, String permanent) {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        clickJS(elementsPage.textBox);

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
        clickJS(elementsPage.checkBox);

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
        clickJS(elementsPage.radioButton);

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
        clickJS(elementsPage.webTables);

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
        clickJS(elementsPage.buttons);

        doubleClick(elementsPage.doubleClickBtn);
        rightClick(elementsPage.rightClickBtn);
        elementsPage.clickMeButton();

        assertEquals(elementsPage.doubleClickMessage.getText(), "You have done a double click");
        assertEquals(elementsPage.rightClickMessage.getText(), "You have done a right click");
        assertEquals(elementsPage.dynamicClickMessage.getText(), "You have done a dynamic click");
    }

    @Test
    public void linksTest() {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        clickJS(elementsPage.links);

        elementsPage.clickSimpleLink();
        opensTabById(1);
        assertTrue(landingPage.elements.isDisplayed());
        opensTabById(0);

        elementsPage.clickDynamicLink();
        opensTabById(2);
        assertTrue(landingPage.elements.isDisplayed());
        opensTabById(0);

        elementsPage.clickCreatedLinks();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 201 and status text Created"));

        elementsPage.clickNoContentLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 204 and status text No Content"));

        elementsPage.clickMovedLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 301 and status text Moved Permanently"));

        elementsPage.clickBadRequestLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 400 and status text Bad Request"));

        elementsPage.clickUnauthorizedLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 401 and status text Unauthorized"));

        elementsPage.clickForbiddenLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 403 and status text Forbidden"));

        elementsPage.clickInvalidUrlLink();
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.responseMessage,
                "Link has responded with staus 404 and status text Not Found"));
    }

    @Test
    public void uploadAndDownload() throws InterruptedException {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        clickJS(elementsPage.uploadAndDownload);

        elementsPage.clickDownloadButton();
        String filePicture = System.getProperty("user.dir") + "\\src\\test\\java\\downloads\\sampleFile.jpeg";
        Thread.sleep(2000);
        elementsPage.fileInput.sendKeys(filePicture);
        wait.until(ExpectedConditions.textToBePresentInElement(elementsPage.uploadedFilePath,
                "C:\\fakepath\\sampleFile.jpeg"));

        deleteFilePicture(filePicture);
    }

    @Test
    public void dynamicPropertiesTest() throws InterruptedException {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        clickJS(elementsPage.dynamicProperties);

        String titleColor = null;
        for (int i = 0; i <= 3; i++) {
            titleColor = elementsPage.colorChange.getCssValue("color");
            if (titleColor != "rgba(255, 255, 255, 1)") {
                return;
            }
            Thread.sleep(2000);
        }
        titleColor = elementsPage.colorChange.getCssValue("color");
        assertEquals(titleColor, "rgba(220, 53, 69, 1)");

        wait.until(ExpectedConditions.visibilityOf(elementsPage.visibleAfter));
    }
}