package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarHelper {
    WebDriver driver;

    public CalendarHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void getCalendarYear(String year, String month, String day) {
        driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select'] / option[@value = '" + year + "']"));

        driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select'] / option[@value = '" + month + "']"));

        if (day != "1st") driver.findElement(By.xpath("//div[contains(@aria-label, '" + day + "')"));
    }

}

