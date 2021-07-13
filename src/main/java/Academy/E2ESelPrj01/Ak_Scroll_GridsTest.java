package Academy.E2ESelPrj01;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Ak_Scroll_GridsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		int sum =0;
		
		
		List<WebElement> lastRow = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		
		for(int i=0;i<lastRow.size();i++) {
			String value = lastRow.get(i).getText();
			sum = sum + Integer.parseInt(value);
		}
		
		System.out.println("sum "+sum);
		String v1 = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		
		System.out.println("v1 "+v1);
		
		//System.out.println(v1.contains(Integer.toString(sum)));
		
		
		Assert.assertEquals(Integer.parseInt(v1), sum);
		
	}

}
