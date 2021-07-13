package Academy.E2ESelPrj01;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Al_Identify_Broken_LinksTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		String testPage = "https://www.rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(testPage);
		
		SoftAssert sa = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));		
		for (WebElement link : links) {
			String footerURL = link.getAttribute("href");
			System.out.println(footerURL);
			
	        HttpURLConnection  conn= (HttpURLConnection)new URL(footerURL).openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        int respCode = conn.getResponseCode();
	        
	        //sa.assertEquals(respCode<400, true);
	        sa.assertTrue(respCode<400, "The link with Text: "+link.getText()+" is broken with code" +respCode);
		}
		
		sa.assertAll();
		
	}

}
