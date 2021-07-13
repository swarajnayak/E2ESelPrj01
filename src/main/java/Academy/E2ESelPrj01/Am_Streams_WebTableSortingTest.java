package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Am_Streams_WebTableSortingTest {

	@Test
	void sortWebTableUsingStreams() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		String testPageURL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(testPageURL);
		driver.close();
	
		
	}

}
