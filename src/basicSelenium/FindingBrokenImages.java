package basicSelenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenImages {
	static int validImageCount = 0;
	static int invalidImageCount = 0;
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List <WebElement> images = driver.findElements(By.xpath("//img"));
		System.out.println("Total images on web page are: " + images.size());
		

		for(int i =0; i<images.size(); i++) {
			WebElement imageAtThatPoint = images.get(i);
			String getAttributeOfCurrentImage = imageAtThatPoint.getAttribute("src");
			validateImages(getAttributeOfCurrentImage);
		}
		
		System.out.println("the validImageCount is: " + validImageCount);
		System.out.println("the invalidImageCount is: " + invalidImageCount);
		driver.quit();
		
	}

	public static void validateImages(String img) throws ClientProtocolException, IOException {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(img);
			HttpResponse response = client.execute(request);

			if(response.getStatusLine().getStatusCode()== 200) {
				validImageCount ++;
//				System.out.println("image is valid");
			}else {
				System.out.println("image is invalid with url: " + img);
				invalidImageCount ++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
