import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Test
public class WindowHandle {
    public static void windowHandle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(By.id("newWindowBtn")).click();
        String parentHandle=driver.getWindowHandle();
        System.out.println("parent window"+parentHandle);
        Set<String> windowHandles=driver.getWindowHandles();
        for(String handle:windowHandles){
            System.out.println(handle);
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                driver.findElement(By.id("firstName")).sendKeys("Pooja Dhane");
                Thread.sleep(1000);
                driver.close();
            }

        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("ok pooja");
        Thread.sleep(1000);
        driver.quit();
    }

}
