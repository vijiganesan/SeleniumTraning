package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
				
		driver.get("http://www.leafground.com/pages/table.html");
		Thread.sleep(1000);
		driver.manage().window().maximize();		
		List<WebElement> tableElements = driver.findElementsById("table_id");
		
		List<WebElement> rowElements = driver.findElementsByXPath("//table[@id='table_id']//tr");
		int rowCount = rowElements.size();
		System.out.println("The no of rows in the table are : "+rowCount);
		
		List<WebElement> columnElements = driver.findElementsByXPath("//table[@id='table_id']//tr/td");
		int colCount = columnElements.size();
		System.out.println("The no of columns in the table are : " +colCount);
		
		String text = driver.findElementByXPath("//tr[@class='even']/td[2]").getText();
		System.out.println("The progress value of 'Learn to interact with Elements' is : " +text);
		
		List<Integer> listProgVal = new ArrayList<Integer>();
	    int maxNumber = 100;
	    int index = 0;
		
		//Find the vital task for the least completed progress and check the box
		for (int i = 2; i <= rowCount; i++) {
			
			String strValue = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]//td[2]").getText();
			int progValue = Integer.parseInt(strValue.replaceAll("%", ""));
			listProgVal.add(progValue);
			
			if (maxNumber >= progValue) {
				maxNumber = progValue;
			}
			if (maxNumber == progValue) {
				index = i;
			}
			
			
		}
		
		driver.findElementByXPath("(//input[@type='checkbox' and @name='vital'])["+(index-1)+"]").click();
		System.out.println("The least progressed vital task is checked");	
		
		Thread.sleep(3000);
		
		driver.close();
	
	}
	

}
