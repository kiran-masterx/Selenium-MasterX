package basicSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicWebtablr {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. Fetch all the rows from dynamic webtable and print on the console
		List <WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		System.out.println("Total rows of the webtable is: " + rows.size());
		
		List <WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td[1]"));
		for(WebElement companies: companyNames) {
			System.out.println(companies.getText());
		}
		
		//2. Get the companies whose current price is above 750
		for(int i =1; i<=rows.size(); i++) {
			WebElement currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+ i +"]//td[4]"));
			String p = currentPrice.getText();
			double price = Double.parseDouble(p);
//			System.out.println(price);
			if(price>=750) {
				WebElement co = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+ i +"]//td//a"));
				
				System.out.println("The compnayName whose price is greater than 750 is : " + co.getText() + "& Actual price is: " + price);
			}
		}

	}

}
