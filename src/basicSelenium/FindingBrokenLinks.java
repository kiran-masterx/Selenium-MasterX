package basicSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindingBrokenLinks {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The total links are: " + links.size());
		
		for(int i = 0; i<links.size(); i++) {
			WebElement ele =links.get(i);
			String url = ele.getAttribute("href");
			//getAttribute() --> Is used to get an attribute of the element located
			findBrokenLinks(url);
		}
		driver.quit();

	}
	
	// findBrokenLinks(url)--> findBrokenLinks(String linkUrl) 
	public static void findBrokenLinks(String linkUrl) throws IOException {
		try {
			URL url = new URL (linkUrl);
			HttpURLConnection httpURL = (HttpURLConnection)url.openConnection();
			httpURL.setConnectTimeout(5000);
			httpURL.connect();
			
			if(httpURL.getResponseCode() ==200) {
				System.out.println("Link is valid");
			}else if(httpURL.getResponseCode()!= 200) {
				System.out.println("following link is not working: " + linkUrl);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
