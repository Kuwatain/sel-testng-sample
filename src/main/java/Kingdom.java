import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kingdom {
    public String name;
    public Integer countyCount;
    public Integer countVladenie;
    public String religion;
    public WebDriver driver;

    public Kingdom(WebDriver driver){
        this.driver = driver;
        this.
        name = "Nikitino Korolovestvo";
        countyCount = 3;
        countVladenie = 6;
        religion = "Katolik";
    }

    public Kingdom(String name, Integer countyCount, Integer countVladenie, String religion){
        this.name = name;
        this.religion = religion;
        this.countyCount = countyCount;
        this.countVladenie = countVladenie;
    }
}
