import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PiapaTest extends BaseTest {

    @Test(dataProvider = "Form params", dataProviderClass = DataProviders.class)
    public void piapaTest(String name, String email, String current, String permanent) {

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


}