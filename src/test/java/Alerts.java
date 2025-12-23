
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Alerts{
    public void handleAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html#");
        driver.manage().window().maximize();

        //simple alert
        driver.findElement(By.id("alertBox")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        //confirmation alerts
        driver.findElement(By.id("confirmBox")).click();
        Alert confirmAlert=driver.switchTo().alert();
        System.out.println(confirmAlert.getText());
        Thread.sleep(2000);
        confirmAlert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());

        //Prompt Alert
        driver.findElement(By.id("promptBox")).click();
        Alert PromptAlert=driver.switchTo().alert();
        System.out.println(PromptAlert.getText());
        Thread.sleep(2000);
        PromptAlert.sendKeys("pooja dhane");
        PromptAlert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());




    }
}
