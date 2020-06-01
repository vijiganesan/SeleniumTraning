package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
		////------------to edit a lead -----------------------------------------------	
	
	@BeforeTest
	public void sendFileName() {
		
		workBookName = "EditLead";

	}
	
	@Test (dependsOnMethods = {"testcase.CreateLead.runCreateLead"}, dataProvider="fetchData")
	public void runEditLead(String fName, String companyName) throws InterruptedException {
		
		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();
		
		//Enter first name
		driver.findElementByXPath("(//div[@class='x-form-item x-tab-item']//input[@type='text'])[2]").sendKeys(Keys.CLEAR,fName);
		Thread.sleep(2000);
		
		//Click Find leads button
		driver.findElementByXPath("//div[@class='x-panel-btns x-panel-btns-center']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Click on first resulting lead
		driver.findElementByXPath("//table[contains(@class,'row-table')]//a").click();
		Thread.sleep(2000);
		
		//Verify title of the page
		System.out.println(driver.getTitle());
		
		//Click Edit
		driver.findElementByLinkText("Edit").click();
		Thread.sleep(2000);
		
		//Change the company name
		WebElement editCompName = driver.findElementById("updateLeadForm_companyName");
		editCompName.clear();
		editCompName.sendKeys(companyName);
		
		//Click Update
		driver.findElementByXPath("//div[@class='fieldgroup-body']//following::input[@value='Update']").click();
		Thread.sleep(2000);
		
		//Confirm the changed name appears
		String strText = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(strText);
		String[] compName = strText.split(" ");
		
		Thread.sleep(1000);
		
		if (compName[0].equals(companyName))
			System.out.println("The updated Company Name value matches");
		else
			System.out.println("The updated Company Name value is NOT matching");
		
		Thread.sleep(2000);

		
	}
}
