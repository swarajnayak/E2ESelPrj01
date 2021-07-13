package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class An_WindowAuthenticationPopUps {

	@Test
	void handlingWindowAuthPopUps() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String URL = "http://admin:admin@the-internet.herokuapp.com/";
		
		long start = System.currentTimeMillis();
		driver.get(URL);
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load in milliSecs - "+totalTime); 
		
		WebDriverWait ww = new WebDriverWait(driver, 5);
		ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Basic Auth"))));
		driver.findElement(By.linkText("Basic Auth")).click();
		

	
		driver.close();
	}

}
