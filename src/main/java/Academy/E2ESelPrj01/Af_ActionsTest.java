package Academy.E2ESelPrj01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Af_ActionsTest {

	public static void main(String[] args) throws InterruptedException {


		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String url = "https://www.amazon.in/";
		driver.get(url);
		WebElement helloSignIn = driver.findElement(By.xpath("//a[@data-nav-role='signin']/div/span[text()='Hello, Sign in']"));
		WebElement searchBox = driver.findElement(By.xpath("//div[@class='nav-search-field ']/input"));
		
		Actions act = new Actions(driver);
		act.moveToElement(helloSignIn).build().perform();
		act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		act.moveToElement(helloSignIn).contextClick().build().perform();
		
		

	}

}
