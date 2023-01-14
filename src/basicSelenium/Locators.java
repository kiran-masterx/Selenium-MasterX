package basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.id("email")).sendKeys("email@12345678");
		//findElement(): method to use the locators
		//By: class in which all the methods related to locators are stored
		//.id(): it is a method from By class, which is used with id locator
		//sendKeys(): It is used to send some text to webelements input box
		
		driver.findElement(By.id("pass")).sendKeys("password@123");
//		driver.findElement(By.id("u_0_5_dT")).click();
		//click(): it is used to click on any of the button on web page
		
		driver.findElement(By.name("login")).click();
		
		//tagName
		driver.findElement(By.tagName("a")).click();

		//className
		driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("username");
		
		//linkText
		driver.findElement(By.linkText("Forgotten password?")).click();
		
		//partialLinkText
		driver.findElement(By.partialLinkText("Forgot")).click();
		driver.findElement(By.cssSelector("#email"));

	}

}
