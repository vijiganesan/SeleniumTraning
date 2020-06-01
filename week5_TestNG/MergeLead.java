package testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MergeLead extends BaseClass{
	
	@Test
	public void runMergeLead() throws InterruptedException {
		
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
