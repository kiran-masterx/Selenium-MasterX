package basicSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaticWebtable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://softwaretestingo.blogspot.com/2020/09/static-table.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Static WebTable Handling
		// 1. Printing all the headers
		List <WebElement> headers = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr//th"));
		System.out.println(headers.size());
		
		System.out.println("using for each loop");
		
		for(WebElement h : headers) {
			System.out.println(h.getText());
		}
		
		System.out.println("With for loop");
		
		for(int i = 0; i<headers.size(); i++) {
			System.out.println(headers.get(i).getText());
		}
		
		// 2. Retrieve all the books with author Mukesh
		//Steps: a. Created a list and store all the rows
		List <WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr"));
		
			//b. Iterating through the rows stored
		for(int i = 2; i<=rows.size(); i++) {
			
			//c.Created a variable, "author" and storing a author names in it for all rows (From Author Column)
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+ i +"]//td[2]")).getText();
			
			//d. Condition: If author name is equals Mukesh then go inside if condition
			if(author.equalsIgnoreCase("Mukesh")) {
				
				//e. Storing the bookName with Author Mukesh
				WebElement bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+ i +"]//td[1]"));
				
				//f. printing the bookName stored for the Author Mukesh
				System.out.println("The book with Author Mukesh is : " + bookName.getText());
			}
		}

		driver.quit();
		
	}

}
