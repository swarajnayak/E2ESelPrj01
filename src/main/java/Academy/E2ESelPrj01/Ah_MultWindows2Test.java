package Academy.E2ESelPrj01;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ah_MultWindows2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://the-internet.herokuapp.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();	
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		String ChildWindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println(ChildWindowText);
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		String parentWindowText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		System.out.println(parentWindowText);
		
		//driver.findElement(By.tagName("iframe"))
		
	}

}
