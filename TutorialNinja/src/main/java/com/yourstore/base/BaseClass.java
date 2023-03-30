package com.yourstore.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.yourstore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop= new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver : "+ driver);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
	
//		else if (browserName.contains("FireFox")){
//			driver= new FirefoxDriver();
//		}
		
				//Maximize the screen
				driver.manage().window().maximize();
				
				//Delete all the cookies
				driver.manage().deleteAllCookies();
				
				//Implicit TimeOuts
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//PageLoad TimeOuts
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
				//Launching the URL
				driver.get(prop.getProperty("url"));
			}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}
