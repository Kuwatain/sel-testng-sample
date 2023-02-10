import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PiapaTest extends BaseTest {

    @Test(dataProvider = "Form params", dataProviderClass = DataProviders.class)
    public void piapaTest(String name, String email, String current, String permanent) {

        LandingPage landingPage = new LandingPage(getDriver());
        ElementsPage elementsPage = new ElementsPage(getDriver());

        getDriver().get("https://demoqa.com/");

        landingPage.clickCategoryCards();

        elementsPage.clickMenuTextBox();
        elementsPage.fillForm(name, email, current, permanent);
        elementsPage.clickButtonSubmit();

        assertEquals(elementsPage.resultName.getText(), "Name:" + name);
        assertEquals(elementsPage.resultEmail.getText(), "Email:" + email);
        assertEquals(elementsPage.resultCurrentAddress.getText(), "Current Address :" + current);
        assertEquals(elementsPage.resultPermanentAddress.getText(), "Permananet Address :" + permanent);
    }

    @Test(dataProvider = "checkboxParam", dataProviderClass = DataProviders.class)
    public void checkBoxTest(ArrayList<String> checkBox) {
        LandingPage landingPage = new LandingPage(getDriver());
        ElementsPage elementsPage = new ElementsPage(getDriver());

        getDriver().get("https://demoqa.com/");
        landingPage.clickCategoryCards();
        elementsPage.clickMenuCheckBox();
        elementsPage.clickCheckBoxExpandAll();

        checkBox.forEach(cbox -> {
            elementsPage.clickCheckBox(cbox);
            assertTrue(elementsPage.displayResult.get(0).getText().contains(cbox));

            elementsPage.clickCheckBox(cbox);
            assertEquals(elementsPage.displayResult.size(), 0);
        });
    }


    @Test
    public void radioButtonTest() {
        LandingPage landingPage = new LandingPage(getDriver());
        ElementsPage elementsPage = new ElementsPage(getDriver());

        getDriver().get("https://demoqa.com/");
        landingPage.clickCategoryCards();
        elementsPage.clickMenuRadioButton();

        elementsPage.clickYesRadioButton();
        assertEquals(elementsPage.displayResultRadioButton.getText(), "You have selected Yes");

        elementsPage.clickImpressiveRadioButton();
        assertEquals(elementsPage.displayResultRadioButton.getText(), "You have selected Impressive");

        assertFalse(elementsPage.noRadio.isEnabled());
    }

    @Test(dataProvider = "Web Tables param", dataProviderClass = DataProviders.class)
    public void webTablesTest(
            String firstName,
            String lastName,
            String email,
            String age,
            String salary,
            String department
    ) {
        LandingPage landingPage = new LandingPage(getDriver());
        ElementsPage elementsPage = new ElementsPage(getDriver());

        getDriver().get("https://demoqa.com/");

        landingPage.clickCategoryCards();
        elementsPage.clickMenuWebTables();
        elementsPage.clickAddButton();
        elementsPage.fillTablesForm(
                firstName,
                lastName,
                email,
                age,
                salary,
                department
        );
        elementsPage.clickTablesButtonSubmit();

    }

}