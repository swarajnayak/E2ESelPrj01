package Academy.E2ESelPrj01;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ag_MultWindowsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/loginpagePractise/#";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();	
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		String ChildWindowText = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		
		String[] s1 = ChildWindowText.split(" with below ");
		String s2 = s1[0];
		System.out.println("s2 "+s2);
		String[] s3 = s2.split("us at ");
		String s4 = s3[1];
		System.out.println("s4 "+s4);
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys(s4);
		

	}

}
