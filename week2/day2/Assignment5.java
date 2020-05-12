package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		
		//adding the key for the chromedriver along with the path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");				
		ChromeDriver driver = new ChromeDriver();
		
		//wait 30 Seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//to open the urls
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Attribute value base XPATH ---- id Attribute
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		
		//Attribute value base XPATH ---- Name Attribute
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		
		//Attribute value base XPATH ---- class Attribute
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		
		//with Partial text XPATH ---- partial text value
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		//with Partial text XPATH ---- partial text value
		driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
		Thread.sleep(1000);
		
		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();	
		Thread.sleep(1000);
		
		//Click on Email
		driver.findElementByXPath("//span[@class='x-tab-strip-inner']/span[text()='Email']").click();
		Thread.sleep(1000);
		
		//Enter phone number 99
		driver.findElementByName("emailAddress").sendKeys("viji");
		
		//Click find leads button
		driver.findElementByXPath("//td[@class='x-panel-btn-td']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);		
		
		//Capture lead ID of First Resulting lead
		WebElement resultLead = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']");
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
		
		//Close the browser (Do not log out)
		driver.close();		
		
	}

}
