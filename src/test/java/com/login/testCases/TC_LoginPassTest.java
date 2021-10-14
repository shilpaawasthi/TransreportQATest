package com.login.testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.login.pageObjects.loginTestPage;

public class TC_LoginPassTest extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginPassTest(String uname, String pwd) throws InterruptedException  {
		
		
		logger.info("Url is opened");
		
		loginTestPage lp = new loginTestPage(driver);
		
		lp.setUserName(uname);
		logger.info(uname);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info(pwd);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.className("title"));
		logger.info(element);
		
		if(element == null)  {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		Thread.sleep(2000);
		
	}
	
	
	

}
