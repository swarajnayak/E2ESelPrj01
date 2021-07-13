package Academy.E2ESelPrj01;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ab_SecondTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement sel = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		
		//Static dropdowns using Select class
		Select s = new Select(sel);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByIndex(3);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("AED");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		
		
		driver.findElement(By.xpath("//label[contains(text(),'PASSENGERS')]/parent::div/div[2]")).click();
		//Thread.sleep(1000);
		
		String adults = driver.findElement(By.id("spanAudlt")).getText();
		System.out.println(adults);
		
		while(!adults.equalsIgnoreCase("5")) {
			driver.findElement(By.id("hrefIncAdt")).click();
			adults = driver.findElement(By.id("spanAudlt")).getText();
		}
		driver.findElement(By.xpath("//*[@id=\"btnclosepaxoption\"]")).click();
		System.out.println(adults);
		
		
		//dynamic drop down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'AMD')]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'PNQ')])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[contains(text(),'PNQ')])[2]")).getText());
		
		//Auto suggestive dropdown
		
		driver.findElement(By.id("autosuggest")).sendKeys("be");
		//Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement option : options) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("Belgium")) {
				option.click();
				break;
			}
			
		}
		
		//Thread.sleep(1000);
		//System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		System.out.println("Start with checkboxes");
		int checkBoxCount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("checkBoxCount is "+checkBoxCount);
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		//Thread.sleep(1000);
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=1;i<checkBoxCount;i++) {
			checkBoxes.get(i).click();
		}
		
		
		driver.quit();
		
		
	}

}
