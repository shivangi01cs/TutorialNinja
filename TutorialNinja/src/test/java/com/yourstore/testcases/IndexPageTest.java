package com.yourstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourstore.base.BaseClass;
import com.yourstore.pageObjects.IndexPage;
import com.yourstore.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() throws Throwable{
		Log.startTestCase("Verify the logo started");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Log.info("Logo is showing in index page");
		Assert.assertTrue(result);
		Log.endTestCase("Verifying the logo ended");
	}
	
	@Test
	public void verifyTitle() {
		
		String actTitle = indexPage.getYourStoreTitle();
		Assert.assertEquals(actTitle, "Your Store");
	}
	
	
}

