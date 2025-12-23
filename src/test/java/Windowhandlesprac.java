import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;
@Test
public class Windowhandlesprac {
    public static void  windowHandle() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.findElement(By.id("newTabBtn")).click();
       String parentHandle= driver.getWindowHandle();
       System.out.println(parentHandle);
       Set<String> windowHandles=driver.getWindowHandles();
       for(String handle:windowHandles){
           System.out.println("all handles"+windowHandles);
           if(!windowHandles.equals(parentHandle)){
               driver.switchTo().window(handle);
               driver.findElement(By.id("promptBox")).click();
               Alert Promptbox=driver.switchTo().alert();
               System.out.println(Promptbox.getText());
               Thread.sleep(1000);
               Promptbox.sendKeys("Pooja Dhane");
               driver.close();

           }
       }
       driver.switchTo().window(parentHandle);
       Thread.sleep(1000);
       driver.findElement(By.id("name")).sendKeys("Pooja kadam");
    }
}
