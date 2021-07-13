package Academy.E2ESelPrj01;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ao_FileUploadUsingAutoIT {

	@Test
	void handlingWindowAuthPopUps() throws InterruptedException, IOException {
		
		String downloadPath=System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		String chromeDriverPath=System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath+"/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String URL = "https://altoconvertpdftoword.com/";
		driver.get(URL);
		driver.findElement(By.className("g-form-group-title--desktop")).click();
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\Sel Jav Shetty\\AutoIT\\fileUpload.exe");
		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Convert Now!')]")));		
		driver.findElement(By.xpath("//button[contains(text(),'Convert Now!')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Download")).click();
		
		Thread.sleep(5000);
		File f=new File(downloadPath+"/Bills Vaccination.docx");

		Assert.assertTrue(f.exists());
		System.out.println("file present");
		if(f.delete()){
			System.out.println("file deleted");
		}


		//driver.close();
	}

}
