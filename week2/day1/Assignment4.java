package week2.day1;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//chrome driver path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		
		//get/navigate url
		//driver.get("http://www.leafground.com/pages/Link.html");
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		//click on 'Go to Home Page' URL
		driver.findElementByLinkText("Go to Home Page").click();
		//navigate back to the previous screen/page
		driver.navigate().back();
		
		//click on 'Find where am supposed to go without clicking me?' URL
		String strValue = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println(strValue);
		
		//click on 'Verify am I broken?' URL
		driver.findElementByLinkText("Verify am I broken?").click();
		String errorPage = driver.getTitle();
		if (errorPage.contains("Not Found"))
			System.out.println(errorPage);
		else	System.out.println("This is NOT an Error Page");
		
		driver.navigate().back();
		
		//click on 'Go to Home Page' URL (Interact with same link name)
		String homePage1 = driver.findElementByLinkText("Go to Home Page").getText();
		String homePage2 = driver.findElementByXPath("(//a[text()='Go to Home Page'])[2]").getText();
		if (homePage1.equalsIgnoreCase(homePage2)) {
			System.out.println("Opening the 1st home page link");
			driver.findElementByLinkText("Go to Home Page").click();
			Thread.sleep(2000);
			driver.navigate().back();
		} 
		else 
			System.out.println("Not opening the home page link as both are differnt links");
	
		//How many links are available in this page?
		int size = driver.findElementsByTagName("a").size();
		
		System.out.println("The number of links available in this page are "+size);
				
		driver.close();
	}

}
