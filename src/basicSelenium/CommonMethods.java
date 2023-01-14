package basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kiran.masterx@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		WebElement loginButton = driver.findElement(By.xpath("//div[text()='Login']"));
		loginButton.click();
		
		//isDisplayed()
		Thread.sleep(5000);
		boolean logo = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		System.out.println("isDispalyed method result: " + logo);
		
		//isEnabled()
		boolean calenderIcon = driver.findElement(By.xpath("//i[@class='calendar icon']")).isEnabled();
		System.out.println("isEnabled method result: " + calenderIcon);
		
		//isSelected()
		driver.findElement(By.xpath("//i[@class='users icon']")).click();
		Thread.sleep(3000);
		boolean checkBox = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		System.out.println("isSelected method result: " + checkBox);
		
		driver.findElement(By.xpath("//i[@class='calendar icon']")).click();
		Thread.sleep(3000);
		boolean calenderCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		System.out.println("isSelected method result for calender: " + calenderCheckBox);
		
	}

}
