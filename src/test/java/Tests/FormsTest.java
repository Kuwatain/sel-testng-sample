package Tests;

import DataProviders.DataProviders;
import Model.User;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FormsTest extends BaseTest {
    @Test(dataProvider = "Forms Params", dataProviderClass = DataProviders.class)
    public void correctFillingOfTheForm(User userNikita) {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsForms();
        clickJS(formsPage.practiceForm);

        formsPage.enterFirstName("Nikita");
        formsPage.enterKeysLastName("Rachkov");
        formsPage.enterKeysUserEmail("nikita@gmail.com");

        formsPage.clickRadioButtonMale();

        formsPage.sendKeysUserNumber("9655857796");

        formsPage.clickDateOfBirth();
        calendarHelper.clickDatePicker
                (
                        "1998",
                        "March",
                        "8"
                );

        formsPage.sendKeysAndClickSubjects("a", "Accounting");
        formsPage.sendKeysAndClickSubjects("b", "Biology");
        formsPage.clickRemoveSubjectsElement("Biology");
        formsPage.clickClearAllSubjects();
        formsPage.sendKeysAndClickSubjects("c", "Civics");
        formsPage.sendKeysAndClickSubjects("d", "Hindi");

        formsPage.clickCheckBoxSports();
        formsPage.clickCheckBoxReading();
        formsPage.clickCheckBoxMusic();

        String file = System.getProperty("user.dir") + "\\src\\test\\java\\Tests\\BaseTest.java";
        formsPage.fileInput.sendKeys(file);

        formsPage.sendKeysCurrentAddress("Kazan");

        formsPage.clickAndChoiceState("NCR");
        formsPage.clickAndChoiceCity("Delhi");

        clickJS(formsPage.submit);

        assertLargeTable(userNikita);

        formsPage.clickCloseLargeModal();
    }

    private void assertLargeTable(User user) {
        assertEquals(formsPage.getStudentName(), user.getFirstName() + " " + user.getLastName());
        assertEquals(formsPage.getStudentEmail(), user.getEmail());
        assertEquals(formsPage.getGender(), user.getGender());
        assertEquals(formsPage.getMobile(), user.getNumber());
        assertEquals(formsPage.getDateOfBirth(), user.getDateOfBirth());
        assertEquals(formsPage.getSubjects(), user.getSubjects());
        assertEquals(formsPage.getHobbies(), user.getHobbies());
        assertEquals(formsPage.getPicture(), user.getPicture());
        assertEquals(formsPage.getAddress(), user.getCurrentAddress());
        assertEquals(formsPage.getStateAndCity(), user.getStateAndCity());
    }
}
