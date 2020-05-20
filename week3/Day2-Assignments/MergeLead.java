package week3.day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");				
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps/control/main");
		Thread.sleep(1000);
		driver.manage().window().maximize();
			
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
		driver.findElementByXPath("//table[@class='twoColumnForm']//a").click();
		
		System.out.println(driver.getTitle());
		
		String handle = driver.getWindowHandle();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//selecting 1st contact
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//switch to parent window
		driver.switchTo().window(handle);
		//click on 2nd widget
		driver.findElementByXPath("(//table[@class='twoColumnForm']//a)[2]").click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//selecting 2nd contact
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
		//switch to parent window
		driver.switchTo().window(handle);
		//merge button
		driver.findElementByXPath("(//table[@class='twoColumnForm']//a)[3]").click();
		//Thread.sleep(1000);
		
		//accept the confirmation alert
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		

	}

}
