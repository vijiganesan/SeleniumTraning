package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Lead Creation
		
		//adding the key for the chromedriver along with the path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");		
		ChromeDriver driver = new ChromeDriver();
		
		//to open the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//to maximize the browser opened
		driver.manage().window().maximize();	
		
		WebElement username = driver.findElementById("username");
		username.sendKeys("demosalesmanager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByLinkText("Create Lead").getText();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		
		driver.findElementById("createLeadForm_firstName").sendKeys("Viji");
		driver.findElementById("createLeadForm_lastName").sendKeys("Ganesan");
		
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
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("viji.ganesan@email.com");
		
		//Dropdown - Country -- SelectbyVisibletext
		driver.findElementById("createLeadForm_generalCountryGeoId").sendKeys("India");
		
		//create Lead Button using name Locator
		driver.findElementByName("submitButton").click();
		
		//get the title of the return page
		System.out.println(driver.getTitle());
		
		System.out.println("Lead Created Successfully");
		
		//java wait 
		Thread.sleep(2000);
		
		//to close the above opened url
		driver.close();
		
	}

}
