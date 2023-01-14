package basicSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("windowButton")).click();
		
		String parentWindow = driver.getWindowHandle(); //p1
		
		Set <String> childWindows = driver.getWindowHandles();
		
		Iterator <String> it = childWindows.iterator();
		
		while (it.hasNext()) {
			  String ChildWindow1 = it.next(); //c1
			 	if (!parentWindow.equalsIgnoreCase(ChildWindow1)) {
			 		//p1 != c1
			 		//not parentWindow equals childWindow1 by ignoring upper case
			          	driver.switchTo().window(ChildWindow1);
			    		String title = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
			    		System.out.println(title);
			 	}
		}
		
		driver.switchTo().window(parentWindow);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
