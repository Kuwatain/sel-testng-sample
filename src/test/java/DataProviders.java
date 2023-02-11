import org.testng.annotations.DataProvider;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class DataProviders {

    @DataProvider(name = "Form params")
    public static Object[][] formParams() {
        return new Object[][]{
                {"Stepan", "stepan@gmail.com", "city", "adress"},
//                {"Nikita", "nikita@gmail.com", "city", "adress"}
        };
    }

    @DataProvider(name = "Check Box params")
    public static Object[][] checkBoxParams() {
        String[] checkBox = new String[]{"notes", "commands", "react", "angular", "veu", "public", "private", "classified", "general", "wordFile", "excelFile"};
        return new Object[][]{checkBox};
    }

    @DataProvider(name = "Web Tables params1")
    public static Object[][] webTablesParamNikita() {
        return new Object[][]{
                {"Nikita", "Rachkov", "nikita@gmail.com", "24", "0", "Kazan"},
        };
    }
    @DataProvider(name = "Web Tables params2")
    public static Object[][] webTablesParamNStepan() {
        return new Object[][]{
                {"Stepan", "Igolkin", "stepan@gmail.com", "24", "500000", "Yerevan"}
        };
    }
}