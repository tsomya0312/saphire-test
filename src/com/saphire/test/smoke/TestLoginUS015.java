package com.saphire.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saphire.test.config.TestConfiguration;
import com.saphire.ui.LoginPage;

public class TestLoginUS015
{
	WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void preTest()
	{
		driver = TestConfiguration.createDriverInstance();
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginErrorTC101()
	{
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("gdgdg");
		login.getLoginButton().click();
		String actualErronMsg = login.getErrorMsg().getText();
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErronMsg, expectedErrorMsg);
	}
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
}
