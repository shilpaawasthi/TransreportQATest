package com.login.testCases;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.login.pageObjects.HomeTestPage;
import com.login.pageObjects.loginTestPage;


public class TC_HomePageTest extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void HomePageTest(String uname, String pwd) throws InterruptedException  {
		
		
		logger.info("Url is opened");
		
		loginTestPage lp = new loginTestPage(driver);
		
		lp.setUserName(uname);
		logger.info(uname);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info(pwd);
		logger.info("Entered password");
		 
		lp.clickSubmit();
		Thread.sleep(2000);
						
		List<WebElement> lstElements = driver.findElements(By.className("inventory_item"));
				
		if(lstElements.size() == 6)  {
			Assert.assertTrue(true);
			logger.info("Item Count Test case passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Item Count Test case failed");
		}
		
		
		HomeTestPage homePage = new HomeTestPage(driver);
		homePage.filterOptionClick();
		homePage.LowToHighOptionClick();
		Thread.sleep(3000);
		
		List<WebElement> lstFilterElements = driver.findElements(By.className("inventory_item_price"));
		
		float lowestPrice = 0;
		boolean testCase = true;
		for(int i = 0; i< lstFilterElements.size(); i++)
		{
			WebElement element = lstFilterElements.get(i);
			float elementPrice = Float.parseFloat(element.getText().replace("$", ""));
			if(elementPrice > lowestPrice)
			{
				lowestPrice = elementPrice;
			}
			else
			{
				testCase = false;
				break;
			}
		}
		
		if(testCase)  {
			Assert.assertTrue(true);
			logger.info("Item sorted correctly");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Item not sorted correctly");
		}
		
	}
	
	
			
	}
	


