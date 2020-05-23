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

		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		
		
		builder.moveToElement(driver.findElementByXPath("//div[@class='desktop-navLink']/a[text()='Women']")).perform();
		
	//explicit wait
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//li/a[text()='Jackets & Waistcoats']")));
		
	//with implicit wait
		driver.findElementByXPath("//li/a[text()='Jackets & Coats']").click();
		////ul[@class='results-base']/li[@class='product-base']
		
		String text = driver.findElementByXPath("//div[@class='title-container']/span[@class='title-count']").getText();
		int totalCount = Integer.parseInt(text.replaceAll("[^0-9?!\\.]",""));
		System.out.println("the total count of items are "+totalCount);
		
		List<WebElement> categoryList = driver.findElementsByXPath("//ul[@class='categories-list']/li");
		int noOfCategory = categoryList.size();
		//System.out.println(noOfCategory);
		
		int sum = 0;		
		for (int i = 1; i <= noOfCategory; i++) {
			
			String category = driver.findElementByXPath("(//ul[@class='categories-list']//label)["+i+"]").getText();
			String catText = driver.findElementByXPath("(//ul[@class='categories-list']//span)["+i+"]").getText();
			
			sum += Integer.parseInt(catText.replaceAll("[\\D]",""));
			//System.out.println("The count of category "+catText+ " is "+Integer.parseInt(catText.replaceAll("[\\D]","")));
			
		}
		
		if (totalCount==sum)
			System.out.println("The total items count and sum of categories count matches");
		else
			System.out.println("The total items count and sum of categories count is NOT matching");
		
		
		driver.findElementByXPath("//label[text()='Coats']/div[@class='common-checkboxIndicator']").click();
		
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("MANGO");
		//Thread.sleep(1000);
		
		driver.findElementByXPath("(//input[@value='MANGO']/following-sibling::div)[2]").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

		builder.moveToElement(driver.findElementByXPath("//div[@class='sort-sortBy']")).perform();

		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='sort-sortBy']")));
		driver.findElementByXPath("//label[@class='sort-label ' and text()='Better Discount']").click();
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='product-productMetaInfo']/h3[text()='MANGO']")));
		Thread.sleep(1000);
		String priceFirstProd = driver.findElementByXPath("//li[@class='product-base']//span[@class='product-discountedPrice']").getText();

		int price = Integer.parseInt(priceFirstProd.replaceAll("[\\D]",""));

		System.out.println("The 'Mango' Coat with 'Better Discount' price is "+price);

		builder.moveToElement(driver.findElementByXPath("//div[@class='product-imageSliderContainer']")).perform();
		
		driver.findElementByXPath("//div[@class='product-actions ']/span[text()='wishlist']").click();
		System.out.println("adding to the wishlist");
		
		Thread.sleep(2000);
		
		//System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
