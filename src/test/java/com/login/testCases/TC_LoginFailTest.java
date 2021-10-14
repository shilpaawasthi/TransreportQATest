package com.login.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.login.utilities.XLUtils;
import com.login.pageObjects.loginTestPage;

public class TC_LoginFailTest extends BaseClass {
	 
	@Test(dataProvider="LoginFailData")
	public void loginFailTest(String uname, String pwd) throws InterruptedException  {
			
		
		logger.info("Url is opened");
		
		loginTestPage lp = new loginTestPage(driver);
		
		lp.setUserName(uname);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.id("login-button"));
		
		if(element != null) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	
	@DataProvider(name ="LoginFailData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/login/testData/LoginFailData.xlsx";
 		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		String logindata[][]= new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0; j<colcount;j++) {
				 
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
				
			
		}
		return logindata;
			
	}
	

}
