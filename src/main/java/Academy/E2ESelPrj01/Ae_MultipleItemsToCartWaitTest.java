package Academy.E2ESelPrj01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ae_MultipleItemsToCartWaitTest {
	
	public static void addItemsToCart(String[] itemsToBuy, WebDriver driver) {
		List<String> listOfItemsToBuy = Arrays.asList(itemsToBuy);

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		int j=0;
		for (int i = 0; i < productList.size(); i++) {
			String product = productList.get(i).getText();
			
			String[] productSplit = product.split(" - "); 
			
			//product returns 'Brocolli - 1 Kg' but we only need 'Brocolli'
			
			if (listOfItemsToBuy.contains(productSplit[0])) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				j++; // To stop the for loop once all the necessary items are added
				if(itemsToBuy.length==j) {
					break;
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String[] itemsToBuy = { "Cauliflower", "Brocolli", "Beans" };
		
		Ae_MultipleItemsToCartWaitTest.addItemsToCart(itemsToBuy, driver);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		System.out.println("Pass");
		driver.close();
		

	}

}
