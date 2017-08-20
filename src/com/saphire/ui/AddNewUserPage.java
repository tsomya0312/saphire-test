package com.saphire.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewUserPage 
{

	WebDriver driver;
	public AddNewUserPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForAddNewUserPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
			visibilityOfAllElementsLocatedBy(By.id("container")));
	}
	public WebElement getUserNameTextbox()
	{
		return driver.findElement(By.name("username"));
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("passwordText"));
	}
	public WebElement getRetypePasswordTextbox()
	{
		return driver.findElement(By.name("passwordTextRetype"));
	}
	public WebElement getFirstNameTextbox()
	{
		return driver.findElement(By.name("firstName"));
	}
	public WebElement getLastNameTextbox()
	{
		return driver.findElement(By.name("lastName"));
	}
	public WebElement getCreateUserButton()
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
}
