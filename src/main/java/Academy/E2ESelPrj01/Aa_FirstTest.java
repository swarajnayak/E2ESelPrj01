package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Verify;

public class Aa_FirstTest 
{
    public static void main( String[] args )
    {
        
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\swaranay\\\\Documents\\\\Personal documents\\Udemy\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("http://google.com");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//        String home = driver.getCurrentUrl();
//        driver.get("http://yahoo.com");
//        System.out.println(driver.getTitle());
//        driver.get(home);
//        System.out.println(driver.getTitle());
//        driver.close();
        
        String URL = "http://facebook.com";
        String URL2 = "http://google.com";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("userName");
        driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("Pwd");
        //driver.findElement(By.linkText("Forgotten password?")).click();
        //driver.findElement(By.xpath("//*[@id=\"u_0_a_9f\"]/div[3]/a")).click();
        
        driver.navigate().to(URL2);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//input[@title=\'Search\']"))).sendKeys("dummy").sendKeys(Keys.ENTER).build().perform();    
        //driver.quit();
        
        
    }
}
