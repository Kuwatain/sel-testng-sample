package Helpers;

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
        return driver.findElements(By.xpath("//div[@role='row'] [descendant::div[text()='" + email + "']]"));
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

    public void clickEditRecord(WebElement row) {
        row.findElement(By.xpath("div[7]//span[@title='Edit']")).click();
    }

    public void clickDeleteRecord(WebElement row) {
        row.findElement(By.xpath("div[7]//span[@title='Delete']")).click();
    }

    public String getStudentName() {
        return driver.findElement(By.xpath("//tr[contains(., 'Student Name')] // td[2]")).getText();
    }

    public String getStudentEmail() {
        return driver.findElement(By.xpath("//tr[contains(., 'Student Email')] // td[2]")).getText();
    }

    public String getGender() {
        return driver.findElement(By.xpath("//tr[contains(., 'Gender')] // td[2]")).getText();
    }

    public String getMobile() {
        return driver.findElement(By.xpath("//tr[contains(., 'Mobile')] // td[2]")).getText();
    }

    public String getDateOfBirth() {
        return driver.findElement(By.xpath("//tr[contains(., 'Date of Birth')] // td[2]")).getText();
    }

    public String getSubjects() {
        return driver.findElement(By.xpath("//tr[contains(., 'Subjects')] // td[2]")).getText();
    }

    public String getHobbies() {
        return driver.findElement(By.xpath("//tr[contains(., 'Hobbies')] // td[2]")).getText();
    }

    public String getPicture() {
        return driver.findElement(By.xpath("//tr[contains(., 'Picture')] // td[2]")).getText();
    }

    public String getAddress() {
        return driver.findElement(By.xpath("//tr[contains(., 'Address')] // td[2]")).getText();
    }

    public String getStateAndCity() {
        return driver.findElement(By.xpath("//tr[contains(., 'State and City')] // td[2]")).getText();
    }
}
