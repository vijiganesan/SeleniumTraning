package week2.day1;

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Setting path for the Chrome driver 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		
		//open the url
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		//to maximize the browser opened
		 driver.manage().window().maximize();	
		
		//get the emailaddress value
		driver.findElementById("email").sendKeys("vijig.84@gmail.com");
	
		//append the text value
		driver.findElementByXPath("(//div/input)[2]").sendKeys("Viji Appended");
				
		//get the value in the input WebElement
		String strValue = driver.findElementByName("username").getAttribute("value");
		System.out.println(strValue);
		//driver.findElementByXPath("//input[@name='username' and @type='text']").sendKeys(Keys.TAB);
		
		//clear the value of the webElement
		driver.findElementByXPath("(//input[@name='username' and @type='text'])[2]").clear();
		
		//Confirm that edit field is disabled
		boolean enabled = driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled();
		System.out.println("The edit field is "+enabled);
		
		Thread.sleep(1000);
		driver.close();

	}

}
