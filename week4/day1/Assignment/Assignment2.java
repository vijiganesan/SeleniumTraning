package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();

//2) Mouse over on WOMEN 		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElementByXPath("//div[@class='desktop-navLink']/a[text()='Women']")).perform();
		
//3) Click Jackets & Coats

		driver.findElementByXPath("//li/a[text()='Jackets & Coats']").click();

//4) Find the total count of item 
		String text = driver.findElementByXPath("//div[@class='title-container']/span[@class='title-count']").getText();
		int totalCount = Integer.parseInt(text.replaceAll("[^0-9?!\\.]",""));
		System.out.println("the total count of items are "+totalCount);
		
		List<WebElement> categoryList = driver.findElementsByXPath("//ul[@class='categories-list']/li");
		int noOfCategory = categoryList.size();

//5) Validate the sum of categories count matches	
		int sum = 0;		
		for (int i = 1; i <= noOfCategory; i++) {
			
			String category = driver.findElementByXPath("(//ul[@class='categories-list']//label)["+i+"]").getText();
			String catText = driver.findElementByXPath("(//ul[@class='categories-list']//span)["+i+"]").getText();
			
			sum += Integer.parseInt(catText.replaceAll("[\\D]",""));
			//System.out.println("The count of category "+catText+ " is "+Integer.parseInt(catText.replaceAll("[\\D]","")));
		}
		
		if (totalCount==sum)
			System.out.println("The total items count and sum of categories count matches to "+totalCount);
		else
			System.out.println("The total items count and sum of categories count is NOT matching");
		
//6) Check Coats in CATEGORIES 		
		driver.findElementByXPath("//label[text()='Coats']/div[@class='common-checkboxIndicator']").click();
		
//7) Click + More option under BRAND		
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
//8) Type MANGO and click checkbox		
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("MANGO");
		driver.findElementByXPath("(//input[@value='MANGO']/following-sibling::div)[2]").click();
		
//9) Close the pop-up x
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(2000);
//10) Confirm all the Coats are of brand MANGO
		
		List<WebElement> brandNames = driver.findElementsByXPath("//h3[@class='product-brand']");
		int totalProd = brandNames.size();
		int count = 0;
		for (WebElement eachBrand : brandNames) {
			
			String eachBrandName = eachBrand.getText();
			
			if (eachBrandName.equalsIgnoreCase("MANGO"))
				count++;
			
		}
		
		if (count==totalProd)
			System.out.println("The products displayed all are 'Mango' brand");
		else
			System.out.println("The products displayed all are NOT 'Mango' brand ");

//11) Sort by Better Discount
		
		builder.moveToElement(driver.findElementByXPath("//div[@class='sort-sortBy']")).perform();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//label[@class='sort-label ' and text()='Better Discount']").click();
		
//12) Find the price of first displayed item 		
		Thread.sleep(1000);
		String priceFirstProd = driver.findElementByXPath("//li[@class='product-base']//span[@class='product-discountedPrice']").getText();

		int price = Integer.parseInt(priceFirstProd.replaceAll("[\\D]",""));

		System.out.println("The 'Mango' Coat with 'Better Discount' price is "+price);
		
//13) Mouse over on size of the first item
//14) Click on WishList Now
		builder.moveToElement(driver.findElementByXPath("//div[@class='product-imageSliderContainer']")).perform();
		
		driver.findElementByXPath("//div[@class='product-actions ']/span[text()='wishlist']").click();
		System.out.println("adding to the wishlist");
		
		Thread.sleep(2000);
		
//15) Close Browser		
		driver.close();
		
	}

}
