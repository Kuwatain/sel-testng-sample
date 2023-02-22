package Tests;

import DataProviders.DataProviders;
import Model.User;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FormsTest extends BaseTest {
    @Test(dataProvider = "Forms Params", dataProviderClass = DataProviders.class)
    public void correctFillingOfTheFormTest(User userNikita) {

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

    @Test
    public void validationOfRequiredFieldsTest() throws InterruptedException {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsForms();
        clickJS(formsPage.practiceForm);

        clickJS(formsPage.submit);

        Thread.sleep(2000);
        String red = "rgb(220, 53, 69)";
        assertEquals(formsPage.borderColorFirstName(), red);
        assertEquals(formsPage.borderColorLastName(), red);
        assertEquals(formsPage.borderColorNumber(), red);
        assertEquals(formsPage.borderColorRadioMale(), red);
        assertEquals(formsPage.borderColorRadioFemale(), red);
        assertEquals(formsPage.borderColorRadioOther(), red);

        formsPage.enterFirstName("Lina");
        formsPage.enterKeysLastName("Inverse");

        formsPage.enterKeysUserEmail("Лина@gmagic.com");
        Thread.sleep(2000);
        assertEquals(formsPage.borderColorEmail(), red);

        formsPage.enterKeysUserEmail("Linagmagic.com");
        Thread.sleep(2000);
        assertEquals(formsPage.borderColorEmail(), red);

        formsPage.enterKeysUserEmail("lina@gmagic.com");

        formsPage.clickRadioFemale();

        formsPage.sendKeysUserNumber("QWERTYUIOP");
        assertEquals(formsPage.borderColorNumber(), red);

        formsPage.sendKeysUserNumber("123456789");
        assertEquals(formsPage.borderColorNumber(), red);

        formsPage.sendKeysUserNumber("0000000000");

        formsPage.clickDateOfBirth();
        calendarHelper.clickDatePicker
                (
                        "1900",
                        "October",
                        "21"
                );

        String green = "rgb(40, 167, 69)";
        assertEquals(formsPage.borderColorFirstName(), green);
        assertEquals(formsPage.borderColorLastName(), green);
        assertEquals(formsPage.borderColorEmail(), green);
        assertEquals(formsPage.borderColorNumber(), green);
        assertEquals(formsPage.borderColorCurrentAddress(), green);
        assertEquals(formsPage.borderColorRadioMale(), green);
        assertEquals(formsPage.borderColorRadioFemale(), green);
        assertEquals(formsPage.borderColorRadioOther(), green);
        assertEquals(formsPage.borderColorDateOfBirth(), green);
        assertEquals(formsPage.borderColorCheckBoxSports(), green);
        assertEquals(formsPage.borderColorCheckBoxMusic(), green);
        assertEquals(formsPage.borderColorCheckBoxReading(), green);
    }
}