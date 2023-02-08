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
}