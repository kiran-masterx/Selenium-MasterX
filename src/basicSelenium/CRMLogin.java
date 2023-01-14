package basicSelenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CRMLogin {
	static WebDriver driver;
	static String user;
	static String pass;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		
		email.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		//Fluent Wait: 
		  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			        .withTimeout(Duration.ofSeconds(30))
			        .pollingEvery(Duration.ofSeconds(5))
			        .ignoring(NoSuchElementException.class);
			WebElement email1 = driver.findElement(By.xpath("//input[@name='email']"));
			WebElement password1 = driver.findElement(By.xpath("//input[@name='password']"));
			WebElement loginButton1 = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
			
			email.sendKeys(user);
			password.sendKeys(pass);
			loginButton.click();
		  
		  WebElement logo = fluentWait.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		      return driver.findElement(By.xpath("//div[@class='header item']"));
		      }
		  });
			WebElement emai1l1 = driver.findElement(By.xpath("//input[@name='email']"));
			WebElement password11 = driver.findElement(By.xpath("//input[@name='password']"));
			WebElement loginButton11 = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
			
			email.sendKeys(user);
			password.sendKeys(pass);
			loginButton.click();
		  logo.click();
		  System.out.println("Done");
			WebElement email111 = driver.findElement(By.xpath("//input[@name='emailadd']"));
			WebElement password111 = driver.findElement(By.xpath("//input[@name='password']"));
			WebElement loginButton111 = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
			
			email.sendKeys(user);
			password.sendKeys(pass);
			loginButton.click();

	}
	
	public static void login(String user, String pass) {
		WebElement email = driver.findElement(By.xpath("//input[@name='emailadd']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		
		email.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

}
