package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aj_CalendarUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\swaranay\\\\Documents\\\\Personal documents\\\\Udemy\\\\chromedriver_win32\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		String url = "https://www.path2usa.com/travel-companions";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
		driver.findElement(By.xpath("//*[@id=\"travel_date\"]")).click();
		//month selection
		
		String SelMonth = driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).getText();
		
		while(!SelMonth.contains("June")){
			
			driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='next']")).click();
			break;
		}
		
		
		//Date Selection
		
		
		

}
}