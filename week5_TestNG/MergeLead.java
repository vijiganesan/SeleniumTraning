package testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MergeLead extends BaseClass{
	
	@Test
	public void runMergeLead() throws InterruptedException {
		
		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();	
		Thread.sleep(1000);	
		
		//click on Merge Leads
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		
		//click on 1st image lookup
		driver.findElementByXPath("//table[@class='twoColumnForm']//a").click();
		
		String handle = driver.getWindowHandle();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		//selecting 1st Lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		//switch to parent window
		driver.switchTo().window(handle);
		
		//click on 2nd image lookup
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
		
		
		//accept the confirmation alert
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		//Verify the title as 'View Lead'
		String strViewTitle = driver.getTitle();
		System.out.println(strViewTitle);
		
		if (strViewTitle.contains("View"))
			System.out.println("Merged Leads Successfully");
		else
			System.out.println("Leads NOT merged successfully");

	}

}
