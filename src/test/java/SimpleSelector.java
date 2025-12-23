import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSelector {
    static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Pooja");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Dhane");
    }
}

