package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		
		//adding the key for the chromedriver along with the path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");				
		ChromeDriver driver = new ChromeDriver();
								
		//to open the urls
		driver.get("http://leafground.com/pages/checkbox.html");
		
		//Select the languages that you know?
		driver.findElementByXPath("//div[@class='example']//input[@type='checkbox']").click();
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[4]").click();
		int count=0;
		List<WebElement> langCheckBox = driver.findElementsByXPath("(//div[@class='example'])[1]//input[@type='checkbox']");
		int checkedCount=0;
		int unCheckedCount=0;
		
		for (WebElement langWebEle : langCheckBox) {
			if (langWebEle.isSelected())
				checkedCount++;
			else if (!langWebEle.isSelected())
				unCheckedCount++;
		}
		
		System.out.println("Selected languages count are "+checkedCount);
		System.out.println("NOT Selected languages count are "+unCheckedCount);
		
		//Confirm Selenium is checked
		boolean confSelselection = driver.findElementByXPath("//div[text()='Selenium']/input[@type='checkbox']").isSelected();
		if (confSelselection==true)
			System.out.println("Selenium is selected");
		else
			System.out.println("Selenium is not selected");

		//DeSelect only checked
		boolean chkSelection1 = driver.findElementByXPath("//div[text()='Not Selected']/input[@type='checkbox']").isSelected();
		boolean chkSelection2 = driver.findElementByXPath("//div[text()='I am Selected']/input[@type='checkbox']").isSelected();

		if(chkSelection1==true)
		{
			driver.findElementByXPath("//div[text()='Not Selected']/input[@type='checkbox']").click();
			System.out.println("deselected the checkbox");
		}
		else if (chkSelection2==true)
		{
			driver.findElementByXPath("//div[text()='I am Selected']/input[@type='checkbox']").click();
			System.out.println("deselected the checkboxs");
		}
		else if ((chkSelection1==false) && (chkSelection2==false))
			System.out.println("checkboxes are not selected");
		
		//Select all below checkboxes --
		//driver.findElementByXPath("(//div[@class='example'])[4]//input[@type='checkbox']").click();
		List<WebElement> selAllChkBoxes = driver.findElementsByXPath("(//div[@class='example'])[4]//input[@type='checkbox']");
		//System.out.println(selAllChkBoxes.size());
		
		for (WebElement webElement : selAllChkBoxes) {
			if (!webElement.isSelected())
				webElement.click();
		}
				
		System.out.println("All Check boxes are selected");
		
	}

}
