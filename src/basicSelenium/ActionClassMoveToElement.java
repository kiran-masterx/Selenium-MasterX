package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMoveToElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		
		email.sendKeys("kiran.masterx@gmail.com");
		password.sendKeys("Test@123");
		loginButton.click();
		
		Actions action = new Actions(driver);
		WebElement calenderIcon = driver.findElement(By.xpath("//i[@class='calendar icon']"));
		Thread.sleep(3000);
		//moveToElement(source)
		action.moveToElement(calenderIcon).build().perform();
		
		//moveToElement(source, x-offset, y-offset)
		WebElement panel = driver.findElement(By.xpath("//div[@id='main-nav']"));
		action.moveToElement(panel, 5, 50).build().perform();
		
		//moveByOffset()
		action.moveByOffset(50, 50).build().perform();
		
		
		Thread.sleep(30000);
		driver.quit();

	}

}
