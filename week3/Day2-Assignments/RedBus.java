package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.redbus.in/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		WebElement SrcText = driver.findElementById("src");
		SrcText.sendKeys("Chennai");
		Thread.sleep(2000);
		SrcText.sendKeys(Keys.ENTER);
		
		WebElement destText = driver.findElementById("dest");
		destText.sendKeys("Trichy");
		Thread.sleep(2000);
		destText.sendKeys(Keys.ENTER, Keys.TAB);
		
		//to select the current date
		driver.findElementByXPath("//div[@class='rb-calendar']//td[@class='current day']").click();
		Thread.sleep(1000);

		driver.findElementByXPath("//div[@class='fl search-box date-box gtm-returnCalendar']").click();
		Thread.sleep(1000);
		
		//to select the return date in august
		driver.findElementByXPath("//div[@id='rb-calendar_return_cal']//tbody/tr[1]/td[3]/button").click();
		driver.findElementByXPath("//div[@id='rb-calendar_return_cal']//tbody/tr[1]/td[3]/button").click();
		driver.findElementByXPath("//div[@id='rb-calendar_return_cal']//tbody/tr[1]/td[3]/button").click();
		
		d
		
		
		
		driver.findElementByXPath("//div[@id='rb-calendar_return_cal']//following::tr[5]/td[6]").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//button[text()='Search Buses']").click();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
