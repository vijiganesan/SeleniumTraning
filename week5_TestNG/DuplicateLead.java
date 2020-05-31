package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	
	@BeforeTest
	public void sendFileName() {
		
		workBookName = "DuplicateLead";

	}
	
	
	@Test(dataProvider="fetchData")
	public void runDuplicateLead(String emailAdd) throws InterruptedException {
		//creation of duplicate lead

		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();	
		Thread.sleep(1000);
		
		//Click on Email
		driver.findElementByXPath("//span[@class='x-tab-strip-inner']/span[text()='Email']").click();
		Thread.sleep(1000);
		
		//Enter the email address
		driver.findElementByName("emailAddress").sendKeys(emailAdd);
		
		//Click find leads button
		driver.findElementByXPath("//td[@class='x-panel-btn-td']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);		
		
		//Capture lead ID of First Resulting lead
		WebElement resultLead = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']");
		                                                   //table[@class= 'x-grid3-row-table']//a
		String resultLeadValue = resultLead.getText();
		System.out.println(resultLeadValue);
		
		//Capture the name of the First Resulting lead
		WebElement resultLeadName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[@class='linktext']");
		String strResultLeadName = resultLeadName.getText();
		System.out.println(strResultLeadName);
		
		//click on the Lead ID of First Resulting Lead
		resultLead.click();

		Thread.sleep(2000);
		
		//Click Duplicate Lead
		driver.findElementByLinkText("Duplicate Lead").click();
		Thread.sleep(1000);
		
		//Verify the title as 'Duplicate Lead'
		String strDuplicateTitle = driver.getTitle();
		System.out.println(strDuplicateTitle);
		
		if (strDuplicateTitle.contains("Duplicate"))
			System.out.println("This is Duplicate Lead Page");
		else
			System.out.println("This is NOT Duplicate Lead Page");
		
		//Click Create Lead
		driver.findElementByName("submitButton").click();
		Thread.sleep(1000);
		
		//Confirm the duplicated lead name is same as captured name
		String strResultText = driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(strResultText);
		
	
		if (strResultText.equals(strResultLeadName))
			System.out.println("The duplicate Lead with same name "+strResultText+" is created successfully");
		else
			System.out.println("The duplicate Lead with same name is not created");
		
	}
	
/*	@DataProvider(name="fetchData")
	private String[][] sendData() throws IOException {

		return LearnExcel.readData("DuplicateLead");

	}*/

}
