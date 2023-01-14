package basicSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//SelectByVisibleText()
		Select s = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		s.selectByVisibleText("Aug");
		
		//selectByValue()
		Select s1 = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		s1.selectByValue("31");
		
		//selectByIndex
		Select s2 = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		s2.selectByIndex(20);
		
		//getOptions()
		List <WebElement> options = s2.getOptions();
//		System.out.println(options);
		System.out.println(options.size());
	}
}
