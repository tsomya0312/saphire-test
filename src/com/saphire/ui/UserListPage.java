package com.saphire.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserListPage 
{
	WebDriver driver;
	public UserListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForUserListPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
			visibilityOfAllElementsLocatedBy(By.id("container")));
	}
	public WebElement getAddNewUserButton()
	{
		return driver.findElement(By.xpath("//input[@value='Add New User']"));
	}
	public WebElement getUser(String firstName, String lastName,
			String userName)
	{
		String text = lastName + ", " + firstName + " ("+ userName +")";
		return driver.findElement(By.partialLinkText(text));
	}
}
