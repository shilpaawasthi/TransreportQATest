package com.login.testCases;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.login.pageObjects.BasketTestPage;
import com.login.pageObjects.RemoveItem;
import com.login.pageObjects.loginTestPage;


public class TC_RemoveItemTest extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void RemoveItemTest(String uname, String pwd) throws InterruptedException  {
		
		
		logger.info("Url is opened");
		
		loginTestPage lp = new loginTestPage(driver);
		
		lp.setUserName(uname);
		logger.info(uname);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info(pwd);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(3000);
						
		
		BasketTestPage basketPage = new BasketTestPage(driver);
		
		basketPage.AddFirstItemClick();
		basketPage.AddSecondItemClick();
		basketPage.AddThirdItemClick();
		basketPage.BasketClick();
		
		Thread.sleep(3000);
		
		RemoveItem remItem = new RemoveItem(driver);
		remItem.RemoveItemClick();
		logger.info("itemremoved");
		
		Thread.sleep(3000);
		
		List<WebElement> Elements = driver.findElements(By.className("cart_quantity"));
		
		if(Elements.size()<=2)  {
			Assert.assertTrue(true);
			logger.info("Item removed successfully");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Item exists");
		}
	}
		
		


	}

