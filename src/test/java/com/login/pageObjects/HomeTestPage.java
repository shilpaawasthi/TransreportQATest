package com.login.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeTestPage {
	      WebDriver ldriver;
	
		public HomeTestPage(WebDriver rdriver){
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		
		@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
		@CacheLookup
		WebElement filterOption;
		
		@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
		@CacheLookup
		WebElement LowToHighOption;
				
		public void filterOptionClick() {
			filterOption.click();
			
		}
		
		public void LowToHighOptionClick() {
			LowToHighOption.click();
			
		}

}
