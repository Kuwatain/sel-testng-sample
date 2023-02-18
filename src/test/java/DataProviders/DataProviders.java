package DataProviders;

import Model.User;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Form Params")
    public static Object[][] formParams() {
        return new Object[][]{
                {"Stepan", "stepan@gmail.com", "city", "adress"},
//                {"Nikita", "nikita@gmail.com", "city", "adress"}
        };
    }

    @DataProvider(name = "Check Box Params")
    public static Object[][] checkBoxParams() {
        String[] checkBox = new String[]
                {
                        "notes",
                        "commands",
                        "react",
                        "angular",
                        "veu",
                        "public",
                        "private",
                        "classified",
                        "general",
                        "wordFile",
                        "excelFile"
                };
        return new Object[][]{checkBox};
    }

    @DataProvider(name = "Web Tables Params")
    public static Object[][] webTablesParams() {
        return new Object[][]{
                {
                        new User("Nikita", "Rachkov", "nikita@gmail.com", "24", "0", "Kazan"),
                        new User("Stepan", "Igolkin", "stepan@gmail.com", "24", "500000", "Yerevan")
                },
        };
    }

    @DataProvider(name = "Forms Params")
    public static Object[][] fromsParams() {
        return new Object[][]{
                {
                        new User("Nikita", "Rachkov", "nikita@gmail.com", "9655857796", "Kazan")
                },
        };
    }
}