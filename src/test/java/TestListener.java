import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    String filePath = "src/test/java/screenshots/";

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");
        System.out.println("Failure Thread Id:" + Thread.currentThread().getId());
        System.out.println("Failure WebDriver" + BaseTest.getDriver().toString());

        String methodName = result.getName().trim();
        WebDriver driver = BaseTest.getDriver();


        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
            System.out.println("***Placed screen shot in " + filePath + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}