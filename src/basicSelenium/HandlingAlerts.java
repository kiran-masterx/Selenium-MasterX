package basicSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Simple Alert
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert al = driver.switchTo().alert();
		String s  = al.getText();
		System.out.println(s);
		al.accept();
		
		//Confirmation Alert
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Alert a2 = driver.switchTo().alert();
		String s1 = a2.getText();
		System.out.println(s1);
		a2.dismiss();
		Thread.sleep(3000);
		
		//Prompt Alert
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		Alert a3 = driver.switchTo().alert();
		String s2 = a3.getText();
		System.out.println(s2);
		a3.sendKeys("Ram");
		Thread.sleep(10000);
		a3.accept();
		driver.close();
	}

}
