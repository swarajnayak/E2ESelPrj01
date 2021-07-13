package Academy.E2ESelPrj01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ap_FecthingXpathsFromPropFIle {

	@Test
	void FecthingXpathsFromPropFIle() throws IOException, InterruptedException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\xPaths01.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//String URL = "http://admin:admin@the-internet.herokuapp.com/";
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		
		WebDriverWait ww = new WebDriverWait(driver, 5);
		ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Basic Auth"))));
		driver.findElement(By.linkText(prop.getProperty("basicAuthLinkText"))).click();
		
		driver.navigate().to(prop.getProperty("url"));
		System.out.println(driver.findElement(By.xpath(prop.getProperty("pageHeadingXpath"))).getText());
		
		//driver.close();
	}

}
