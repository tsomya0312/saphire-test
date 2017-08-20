package com.saphire.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saphire.test.config.TestConfiguration;
import com.saphire.ui.AddNewUserPage;
import com.saphire.ui.HomePage;
import com.saphire.ui.LoginPage;
import com.saphire.ui.UserListPage;

public class TestCreateUserUS0155
{
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	UserListPage userlist;
	AddNewUserPage addNewUser;
	
	@BeforeMethod
	public void perTest()
	{
		driver = TestConfiguration.createDriverInstance();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		userlist = new UserListPage(driver);
		addNewUser = new  AddNewUserPage(driver);
	}
	@Test
	public void testCreateUSerTC134()
	{
		loginpage.waitForLoginPageToLoad();
		loginpage.getUsernameTextbox().sendKeys("admin");
		loginpage.getPasswordTextbox().sendKeys("manager");
		loginpage.getLoginButton().click();
		
		homepage.waitForHomePage();
		homepage.getUsersTab().click();
		
		userlist.waitForUserListPage();
		userlist.getAddNewUserButton().click();
		
		addNewUser.waitForAddNewUserPage();
		addNewUser.getUserNameTextbox().sendKeys("Sam");
		addNewUser.getPasswordTextbox().sendKeys("admin");
		addNewUser.getRetypePasswordTextbox().sendKeys("admin");
		addNewUser.getFirstNameTextbox().sendKeys("first");
		addNewUser.getLastNameTextbox().sendKeys("last");
		addNewUser.getCreateUserButton().click();
		
		boolean actualStatus = 
			userlist.getUser("first", "last", "Sam").isDisplayed();
		
		Assert.assertEquals(actualStatus, true);
		
		homepage.getLogoutButton().click();
	
	}
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
}
