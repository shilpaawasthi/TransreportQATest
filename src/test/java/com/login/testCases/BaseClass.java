package com.login.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.login.utilities.ReadConfig;
import com.login.utilities.XLUtils;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		logger = Logger.getLogger("eCommerce");
		PropertyConfigurator.configure("log4j.properties");
        
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver= new ChromeDriver();
			
		}
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver= new FirefoxDriver();
	}
        driver.get(baseURL);
	}
	
	@DataProvider(name ="LoginData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/login/testData/LoginData.xlsx";
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
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
              
}
