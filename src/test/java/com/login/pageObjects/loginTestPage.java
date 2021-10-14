package com.login.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginTestPage {
	      WebDriver ldriver;
	
		public loginTestPage(WebDriver rdriver){
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(name="user-name")
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(name="login-button")
		@CacheLookup
		WebElement btnLogin;
		
		public void setUserName(String uName) {
			
			txtUserName.sendKeys(uName);
			
			}
		public void setPassword(String pwd) {
			
			txtPassword.sendKeys(pwd);
			
		}
		
		public void clickSubmit() {
			btnLogin.click();
			
		}
		

}
