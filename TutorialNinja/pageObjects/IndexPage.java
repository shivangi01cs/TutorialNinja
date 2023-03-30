package com.yourstore.pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.yourstore.actiondriver.Action;
import com.yourstore.base.BaseClass;

public class IndexPage extends BaseClass{
	Action action = new Action();

	@FindBy(how=How.XPATH,using="//*[@id=\"logo\"]/h1/a")
	@CacheLookup
	WebElement yourStoreLogo;
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(driver, yourStoreLogo);
	}
	
	public String getYourStoreTitle() {
		String yourStoreTitle=driver.getTitle();
		return yourStoreTitle;
	}
}
