package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

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
		
		//Click on Phone
		driver.findElementByXPath("//span[@class='x-tab-strip-inner']/span[text()='Phone']").click();
		Thread.sleep(1000);
		
		//Enter phone number 99
		driver.findElementByName("phoneNumber").sendKeys("99");
		
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
		
		//Close the browser (Do not log out)
		driver.close();		

	}

}
