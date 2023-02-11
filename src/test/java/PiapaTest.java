import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PiapaTest extends BaseTest {

    @Test(dataProvider = "Form params", dataProviderClass = DataProviders.class)
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

    @Test(dataProvider = "Check Box params", dataProviderClass = DataProviders.class)
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

    @Test(dataProvider = "webTablesParam", dataProviderClass = DataProviders.class)
    public void webTablesTest(User userNikita, User userStepan) {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuWebTables();
        elementsPage.clickAddButton();
        elementsPage.fillTablesForm(userNikita);
        elementsPage.clickTablesButtonSubmit();

        WebElement rowNikita = tableHelper.findRow(userNikita.getEmail());
        assertRowUser(userNikita, rowNikita);

        tableHelper.clickEditRecord(rowNikita);

        elementsPage.fillTablesForm(userStepan);
        elementsPage.clickTablesButtonSubmit();

        WebElement rowStepan = tableHelper.findRow(userStepan.getEmail());
        assertRowUser(userStepan, rowStepan);

        elementsPage.searchBoxForm.sendKeys(userStepan.getEmail());

        assertNotNull(tableHelper.findRow(userStepan.getEmail()));
    }

    private void assertRowUser(User user, WebElement row) {
        assertEquals(tableHelper.getFirstName(row), user.getFirstName());
        assertEquals(tableHelper.getLastName(row), user.getLastName());
        assertEquals(tableHelper.getAge(row), user.getAge());
        assertEquals(tableHelper.getEmail(row), user.getEmail());
        assertEquals(tableHelper.getSalary(row), user.getSalary());
        assertEquals(tableHelper.getDepartment(row), user.getDepartment());
    }
}
