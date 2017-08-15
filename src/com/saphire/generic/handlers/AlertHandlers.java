package com.saphire.generic.handlers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandlers
{
	public static void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static void enterTextToAlert(WebDriver driver, 
			String text)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
		acceptAlert(driver);
	}
	public static String getAlertText(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String alertText = alt.getText();
		return alertText;
	}
}
