package com.saphire.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForHomePage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
			visibilityOfAllElementsLocatedBy(By.id("container")));
	}
	public WebElement getLogoutButton()
	{
		return driver.findElement(By.xpath("//img[@alt='Logout']"));
	}
	public WebElement getUsersTab()
	{
		return driver.findElement(By.linkText("Users"));
	}
}
