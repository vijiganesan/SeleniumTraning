package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{
	
	@BeforeTest
	public void sendFileName() {
		
		workBookName = "DeleteLead";

	}
	
	
	@Test(dependsOnMethods = {"testcase.EditLead.runEditLead"}, dataProvider="fetchData")
	public void runDeleteLead(String phNo) throws InterruptedException {
		//deletion of lead

		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();	
		Thread.sleep(1000);
		
		//Click on Phone
		driver.findElementByXPath("//span[@class='x-tab-strip-inner']/span[text()='Phone']").click();
		Thread.sleep(1000);
		
		//Enter phone number 99
		driver.findElementByName("phoneNumber").sendKeys(phNo);
		
		//Click find leads button
		driver.findElementByXPath("//td[@class='x-panel-btn-td']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Capture lead ID of First Resulting lead
		WebElement resultLead = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']");
		String resultLeadValue = resultLead.getText();
		resultLead.click();
		System.out.println(resultLeadValue);
		
		Thread.sleep(2000);
		
		//Click Delete
		driver.findElementByClassName("subMenuButtonDangerous").click();
		Thread.sleep(1000);
		
		System.out.println("deleted");
		
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();	
		Thread.sleep(2000);
		
		//Enter captured lead ID
		driver.findElementByXPath("//div[@class='x-form-item x-tab-item']//input[@type='text']").sendKeys(Keys.CLEAR,resultLeadValue);
		Thread.sleep(2000);
		
		//Click Find leads button
		driver.findElementByXPath("//div[@class='x-panel-btns x-panel-btns-center']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String strNoRecMsg = driver.findElementByClassName("x-paging-info").getText();
		System.out.println(strNoRecMsg);
		
		if (strNoRecMsg.equals("No records to display"))
			System.out.println("The Lead is deleted successfully");
		else
			System.out.println("The Lead is NOT deleted");
		
	}

}
