package CommonUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseComponents.BaseClass;

public class Commonutilities extends BaseClass {

	WebDriver driver;
	public Commonutilities(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void waitForElementToAppear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
}
