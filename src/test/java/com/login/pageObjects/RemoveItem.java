package com.login.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveItem {
	
	      WebDriver ldriver;
	
		public RemoveItem(WebDriver rdriver){
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
		@CacheLookup
		WebElement filterOption;
		
		@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
		@CacheLookup
		WebElement LowToHighOption;
		

		@FindBy(name="add-to-cart-sauce-labs-onesie")
		@CacheLookup
		WebElement SelectedItem1;
		
		@FindBy(name="add-to-cart-sauce-labs-bike-light")
		@CacheLookup
		WebElement SelectedItem2;
		
		@FindBy(name="add-to-cart-sauce-labs-bolt-t-shirt")
		@CacheLookup
		WebElement SelectedItem3;
		
		@FindBy(xpath="//*[@id=\'shopping_cart_container\']/a/span")
		@CacheLookup
		WebElement Basket;
		
		
				
		public void filterOptionClick() {
			filterOption.click();
			
		}
		
		public void LowToHighOptionClick() {
			LowToHighOption.click();
			
		}
		
		public void AddFirstItemClick() {
			SelectedItem1.click();
			
		}
		public void AddSecondItemClick() {
			SelectedItem2.click();
			
		}
		public void AddThirdItemClick() {
			SelectedItem3.click();
			
		}
		public void AddItemBasket() {
		Basket.click();
		
			
		}
		
		@FindBy(name="remove-sauce-labs-bike-light")
		@CacheLookup
		WebElement RemoveItem;
		
		public void RemoveItemClick() {
			RemoveItem.click();
			
		}
}


