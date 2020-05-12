package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

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
		
		//navigate to Find leads 
		driver.findElementByLinkText("Find Leads").click();
		
		//Enter first name
		driver.findElementByXPath("(//div[@class='x-form-item x-tab-item']//input[@type='text'])[2]").sendKeys(Keys.CLEAR,"viji");
		Thread.sleep(2000);
		
		//Click Find leads button
		driver.findElementByXPath("//div[@class='x-panel-btns x-panel-btns-center']//following::button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Click on first resulting lead
		driver.findElementByXPath("//table[contains(@class,'row-table')]//a").click();
		Thread.sleep(2000);
		
		//Verify title of the page
		String strTitle = driver.getTitle();
		System.out.println(strTitle);
		
		//Click Edit
		driver.findElementByLinkText("Edit").click();
		Thread.sleep(2000);
		
		//Change the company name
		WebElement editCompName = driver.findElementById("updateLeadForm_companyName");
		editCompName.clear();
		editCompName.sendKeys("TestLeaf");
		
		//Click Update
		driver.findElementByXPath("//div[@class='fieldgroup-body']//following::input[@value='Update']").click();
		Thread.sleep(2000);
		
		//Confirm the changed name appears
		String strText = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(strText);
		String[] compName = strText.split(" ");
		
		Thread.sleep(1000);
		
		if (compName[0].equals("TestLeaf"))
			System.out.println("The updated Company Name value matches");
		else
			System.out.println("The updated Company Name value is NOT matching");
		
		Thread.sleep(2000);
		
		//Close the browser (Do not log out)
		driver.close();
		
	}
}
