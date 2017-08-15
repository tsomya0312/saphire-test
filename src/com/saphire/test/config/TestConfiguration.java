package com.saphire.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saphire.utils.GetData;

public class TestConfiguration 
{
	public static WebDriver createDriverInstance()
	{
		WebDriver driver = null;
		String browser = GetData.fromProperties("configuration", 
				"browser");
		String url = GetData.fromProperties("configuration", 
				"url");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", 
					"./browser-server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./browser-server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("Invalid Browser Option");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
