package com.yourstore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.yourstore.actiondriver.Action;
import com.yourstore.base.BaseClass;

public class RegisterPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(how=How.XPATH,using="//*[@id=\"top-links\"]/ul/li[2]/a")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement register;

	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/h1")
	@CacheLookup
	WebElement registerMsg;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-firstname\"]")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-email\"]")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-telephone\"]")
	@CacheLookup
	WebElement telephone;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-password\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-confirm\"]")
	@CacheLookup
	WebElement passwordConfirm;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/form/fieldset[3]/div/label")
	@CacheLookup
	WebElement subscribe;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() throws Throwable {
		action.click(driver,myAccount );
		
	}
	
	public void clickRegister() throws Throwable{
		action.click(driver, register);
	}

}
