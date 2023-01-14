package basicSelenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//to()
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("Software Testing");
		driver.findElement(By.xpath("(//span[text()='software testing'])[1]")).click();
		driver.findElement(By.xpath("(//a[@href='https://www.ibm.com/in-en/topics/software-testing'])[1]")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
}
