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

        formsPage.fillRegistrationForm(userNikita);
        formsPage.clickRadioMale();

        formsPage.clickDateOfBirth();
        formsPage.clickCalendarYear();
        formsPage.clickCalendarMonth();
        formsPage.clickCalendarDay();

        formsPage.sendKeysAndClickSubjects("a", 3);
        formsPage.sendKeysAndClickSubjects("b", 0);
        formsPage.sendKeysAndClickSubjects("c", 6);
        formsPage.sendKeysAndClickSubjects("d", 0);

        formsPage.clickCheckBoxSports();
        formsPage.clickCheckBoxReading();
        formsPage.clickCheckBoxMusic();

        String file = System.getProperty("user.dir") + "\\src\\test\\java\\Tests\\BaseTest.java";
        formsPage.fileInput.sendKeys(file);

        formsPage.clickAndChoiceState(0);
        formsPage.clickAndChoiceCity(0);

        clickJS(formsPage.submit);

        assertEquals(tableHelper.getStudentName(), "Nikita Rachkov");
        assertEquals(tableHelper.getStudentEmail(), "nikita@gmail.com");
        assertEquals(tableHelper.getGender(), "Male");
        assertEquals(tableHelper.getMobile(), "9655857796");
        assertEquals(tableHelper.getDateOfBirth(), "08 March,1998");
        assertEquals(tableHelper.getSubjects(), "Social Studies, Biology, Civics, Hindi");
        assertEquals(tableHelper.getHobbies(), "Sports, Reading, Music");
        assertEquals(tableHelper.getPicture(), "BaseTest.java");
        assertEquals(tableHelper.getAddress(), "Kazan");
        assertEquals(tableHelper.getStateAndCity(), "NCR Delhi");

        formsPage.clickCloseLargeModal();
    }
}
