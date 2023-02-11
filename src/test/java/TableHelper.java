import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHelper {
    WebDriver driver;

    public TableHelper(WebDriver driver) {
        this.driver = driver;
    }



    public List<WebElement> findRow(String email) {
        return driver.findElements(By.xpath("//div[@role='row'] [descendant::div[text()='" + email +"']]"));
    }

    public String getFirstName(WebElement row) {
        return row.findElement(By.xpath("div[1]")).getText();
    }

    public String getLastName(WebElement row) {
        return row.findElement(By.xpath("div[2]")).getText();
    }

    public String getAge(WebElement row) {
        return row.findElement(By.xpath("div[3]")).getText();
    }

    public String getEmail(WebElement row) {
        return row.findElement(By.xpath("div[4]")).getText();
    }

    public String getSalary(WebElement row) {
        return row.findElement(By.xpath("div[5]")).getText();
    }

    public String getDepartment(WebElement row) {
        return row.findElement(By.xpath("div[6]")).getText();
    }

    public void clickEditRecord(WebElement row) {row.findElement(By.xpath("div[7]//span[1]")).click(); }

    public void clickDeleteRecord(WebElement row) {row.findElement(By.xpath("div[7]//span[2]")).click(); }

}
