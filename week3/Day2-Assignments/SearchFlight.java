package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SearchFlight {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		driver.findElementById("RoundTrip").click();
		
		driver.findElementById("FromTag").sendKeys(Keys.ENTER,"Chennai",Keys.DOWN,Keys.ENTER);
		driver.findElementById("ToTag").sendKeys(Keys.ENTER,"New York",Keys.DOWN,Keys.ENTER);
		driver.findElementById("DepartDate").sendKeys("Wed, 20 May, 2020",Keys.ENTER);
		//fromDateElement.sendKeys("Tue, 19 May, 2020",Keys.ENTER);
		driver.findElementById("ReturnDate").click();
		driver.findElementByLinkText("10").click();
		
		driver.findElementById("Adults").sendKeys("2");
		driver.findElementById("Childrens").sendKeys("1");
		driver.findElementById("Infants").sendKeys("1");
		
		driver.findElementById("MoreOptionsLink").click();
		driver.findElementById("Class").sendKeys("Economy");
		driver.findElementById("AirlineAutocomplete").sendKeys("Emirates");
		Thread.sleep(1000);
		driver.findElementById("SearchBtn").click();
		
		driver.close();

	}

}
