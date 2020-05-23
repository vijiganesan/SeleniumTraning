package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://acme-test.uipath.com/account/login");
		
		driver.manage().window().maximize();
		
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElementByXPath("(//div[@class='dropdown']/button[@class='btn btn-default btn-lg'])[3]")).perform();
		Thread.sleep(500);
		//System.out.println("1");
		driver.findElementByXPath("(//ul[@class='dropdown-menu dropdown-content rightMenu'])[4]//a").click();
		Thread.sleep(500);
		//System.out.println("2");
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		driver.findElementByXPath("//button[@class='btn btn-primary']").click();
		
		
		List<WebElement> rows = driver.findElementsByXPath("//table//tr");
		int rowCount = rows.size();
		//System.out.println(rowCount);
		//System.out.println(rows.get(0).getText());
		
		List<WebElement> cols = driver.findElementsByXPath("//table//tr/td");
		int colCount = cols.size();
		//System.out.println(colCount);

		if((driver.findElementByXPath("//table//th[1]").getText()).equalsIgnoreCase("Vendor"))
			
			if((driver.findElementByXPath("//table//th[5]").getText()).equalsIgnoreCase("Country")) {
		
				for (int i = 2; i <= rowCount; i++) {
					
					String vendor = driver.findElementByXPath("//table//tr["+i+"]/td[1]").getText();
					if (vendor.equalsIgnoreCase("Blue Lagoon")) {
						String country = driver.findElementByXPath("//table//tr["+i+"]/td[5]").getText();
						System.out.println("The '"+vendor+"' Vendor Country is '"+country+"'");
					}
				}
		}
		
		Thread.sleep(1000);
		
		driver.close();
	}
	
}
