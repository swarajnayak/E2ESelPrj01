package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ai_LinksCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		int linksInFooter = driver.findElements(By.xpath("//li[@class='gf-li']/a")).size();
		System.out.println(linksInFooter);
	}

}
