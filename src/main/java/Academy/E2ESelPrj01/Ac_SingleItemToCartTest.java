package Academy.E2ESelPrj01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ac_SingleItemToCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\swaranay\\Documents\\Personal documents\\Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();

		String itemToBuy = "Cauliflower";

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < productList.size(); i++) {

			if (productList.get(i).getText().contains(itemToBuy)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				break;
			}

		}
		

	}

}
