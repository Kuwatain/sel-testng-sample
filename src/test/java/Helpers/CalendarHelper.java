package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarHelper {
    WebDriver driver;

    public CalendarHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getCalendarYear(String calendarYear) {
        return driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select'] / option[contains(., '" + calendarYear + "')]"));
    }

    private WebElement getCalendarMonth(String calendarMonth) {
        return driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select'] / option[contains(., '" + calendarMonth + "')]"));
    }

    private WebElement getCalendarDay(String month, String calendarDay) {
        if (calendarDay == "1")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "st')]"));

         if (calendarDay == "2")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "nd')]"));

         if (calendarDay == "3")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "rd')]"));

         return driver.findElement(By.xpath("//div[contains(@aria-label, '" + month + " " + calendarDay + "')]"));
    }

    public void clickDatePicker(String year, String month, String day) {
        getCalendarYear(year).click();
        getCalendarMonth(month).click();
        getCalendarDay(month, day).click();
    }
}
