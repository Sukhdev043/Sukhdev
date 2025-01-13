package com.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FISAutomationTesting {
	
	WebDriver driver;
	String SearchElement= "//input[@class='gh-tb ui-autocomplete-input']";
	String SerachButton="input#gh-btn";
	//"s-item__wrapper clearfix";
	String AddTocart="//span[text()='Add to cart']";
	String CountItem="i#gh-cart-n";
	String Cart="//a[contains(@aria-label,'Your shopping cart')]";
	             
	String ItemText="//div[@class='grid-item-title']//h3";
	
			public WebElement SearchElementByUsingXpath(String ele)
			{
			 	WebElement el= driver.findElement(By.xpath(ele));
			 	return el;
		
			}
			public WebElement SearchElementByUsingCssSelector(String ele)
			{
			 	WebElement el= driver.findElement(By.cssSelector(ele));
			 	return el;
		
			}
			public WebElement SearchElementByUsingId(String ele)
			{
			 	WebElement el= driver.findElement(By.id(ele));
			 	return el;
		
			}
			
			
	@Test
	public void AddToCart() throws Throwable
	{
		
		// 1.Open browser
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		//driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2.Navigate to ebay.com
		driver.get("https://www.ebay.com/");
		
		//3.Search for ‘book’
		WebElement InputFirstBook= SearchElementByUsingXpath(SearchElement);
		InputFirstBook.sendKeys("book");
		WebElement EnterButton= SearchElementByUsingCssSelector(SerachButton);
		EnterButton.click();
		// 4.Click on the first book in the list
		//List<WebElement> books= driver.findElements(By.xpath("//div[@class='s-item__wrapper clearfix']"));
		//List<WebElement> books= driver.findElements(By.xpath("//div[@class='s-item__title']"));
		 
		
		//String st1= books.get(1).getText();
		WebElement books= driver.findElement(By.xpath("(//div[@class='s-item__title'])[3]"));
		String st1= books.getText();
		
		System.out.println(st1);
		
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", books);
		
		String parent=driver.getWindowHandle();
		Set<String> strWindowhandle= driver.getWindowHandles();
		
		Iterator<String> it = strWindowhandle.iterator();	
		while(it.hasNext())
		{
			String childWindow= it.next();
			if(!parent.equals(childWindow))
		{
				driver.switchTo().window(childWindow);

				System.out.println(driver.switchTo().window(childWindow).getTitle());
				//Add to cart
				
				WebElement ele= SearchElementByUsingXpath(AddTocart);
				ele.click();
				
				// go to Cart
				SearchElementByUsingXpath(Cart).click();
				// checking how many item has added
				String count= SearchElementByUsingCssSelector(CountItem).getText();
				Assert.assertEquals(Integer.parseInt(count), 1, "Total numbers of item are showing");
				
				// checking as same book is available which we are added.
				
				List<WebElement> listEle= driver.findElements(By.xpath(ItemText));
				
				for(WebElement li: listEle)
				{
					String BookName= li.getText();
					//System.out.println("BookName is="+BookName);
					if(BookName.contains(st1))
					{
						System.out.println("Passed the test case");
					}
					
				}
				//close child browser
				driver.close();
		}
		}
		//close all the browser
		driver.quit();
		
		
	}

}
