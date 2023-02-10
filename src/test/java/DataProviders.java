import org.testng.annotations.DataProvider;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class DataProviders {

    @DataProvider(name = "Form params", parallel = true)
    public static Object[][] formParams() {
        return new Object[][]{
                {"Stepan", "stepan@gmail.com", "city", "adress"},
                {"Nikita", "nikita@gmail.com", "city", "adress"}
        };
    }

    @DataProvider(name = "checkboxParam", parallel = true)
    public static Object[][] checkBoxParam() {
        return new Object[][]{
//                { new ArrayList<>(asList("notes", "commands", "react", "angular", "veu", "public", "private", "classified")) },
                {new ArrayList<>(asList("notes", "public", "private", "classified"))}
        };
    }

    @DataProvider(name = "Web Tables param")
    public static Object[][] webTablesParam() {
        return new Object[][]{
                {"Nikita", "Rachkov", "nikita@gmail.com", "24", "0", "Kazan"}
        };
    }
}