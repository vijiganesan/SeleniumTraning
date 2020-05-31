package testcase;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	
	@BeforeTest
	public void sendFileName() {
		
		workBookName = "CreateLead";

	}
	
	
	@Test(dataProvider="fetchData")
	public void runCreateLead(String compName, String fName, String lName) throws InterruptedException {
		
		//Lead Creation
	
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByLinkText("Create Lead").getText();
		driver.findElementById("createLeadForm_companyName").sendKeys(compName);
		
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		
		//Dropdown - source -- SelectbyVisibletext
		driver.findElementById("createLeadForm_dataSourceId").sendKeys("Employee");
		
		//Dropdown - industry -- by SelectbyValue
		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		
		Select dropDown1 = new Select(industry);

		dropDown1.selectByValue("IND_SOFTWARE");
		
		//Dropdown - "Marketing Campaign" -- by SelectbyValue
		WebElement mrkCamp = driver.findElementById("createLeadForm_marketingCampaignId");
				
		Select dropDown2 = new Select(mrkCamp);

		dropDown2.selectByValue("9001");
		
		//Dropdown - ownership -- SelectbyIndex
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
				
		Select dropDown3 = new Select(ownership);

		dropDown3.selectByIndex(5);
		
		//phone number
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9999999999");
		
		//email address
		driver.findElementById("createLeadForm_primaryEmail").sendKeys(fName+lName+"@email.com");
		
		//Dropdown - Country -- SelectbyVisibletext
		driver.findElementById("createLeadForm_generalCountryGeoId").sendKeys("India");
		
		//create Lead Button using name Locator
		driver.findElementByName("submitButton").click();
		
		//get the title of the return page
		System.out.println(driver.getTitle());
		
		System.out.println("Lead Created Successfully");
		
		//java wait 
		Thread.sleep(2000);
		
	}
	
/*	@DataProvider(name="fetchData")
	private String[][] sendData() throws IOException {

		return LearnExcel.readData("CreateLead");

	}*/

}
