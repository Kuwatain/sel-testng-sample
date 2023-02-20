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

    private WebElement getCalendarDay(String calendarDay) {
        if (calendarDay == "1" || calendarDay == "21" || calendarDay == "31")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "st')]"));
        else if (calendarDay == "2" || calendarDay == "22")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "nd')]"));
        else if (calendarDay == "3" || calendarDay == "23")
            return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "rd')]"));
        else return driver.findElement(By.xpath("//div[contains(@aria-label, '" + calendarDay + "th')]"));
    }

    public void clickDatePicker(String year, String month, String day) {
        getCalendarYear(year).click();
        getCalendarMonth(month).click();
        getCalendarDay(day).click();
    }
}
