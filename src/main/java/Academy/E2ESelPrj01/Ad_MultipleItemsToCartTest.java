package Academy.E2ESelPrj01;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ad_MultipleItemsToCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();


		String[] itemsToBuy = { "Cauliflower - 1 Kg", "Brocolli - 1 Kg", "Beans - 1 Kg" };
		List<String> listOfItemsToBuy = Arrays.asList(itemsToBuy);

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		int j=0;
		for (int i = 0; i < productList.size(); i++) {
			String product = productList.get(i).getText();
			if (listOfItemsToBuy.contains(product)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				j++; // To stop the for loop once all the necessary items are added
				if(itemsToBuy.length==j) {
					break;
				}
			}

		}

	}

}
