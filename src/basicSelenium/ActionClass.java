package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//ul[@id='sortable']//li[@name='K']"));
		WebElement destination = driver.findElement(By.xpath("//ul[@id='sortable']//li[8]"));
		
		//ClickAndHold, dragAndDrop, release(), build(), perform()
		action.clickAndHold(source).dragAndDrop(source, destination).release().build().perform();
		
		//contextClick
		action.contextClick(driver.findElement(By.xpath("//a[contains(text(),'Selenium')]/parent::h1"))).build().perform();
		
		//doubleClick
		driver.findElement(By.xpath("//h3[contains(text(),'Click and Hold in Selenium')]")).click();
		action.doubleClick(driver.findElement(By.xpath("//h3[contains(text(),'Click and Hold in Selenium')]"))).build().perform();
		
		//dragAndDropBy
		action.clickAndHold(source).dragAndDropBy(source, 70, 50).release().build().perform();
		
		Thread.sleep(20000);
		driver.quit();
		driver.quit();

	}

}
