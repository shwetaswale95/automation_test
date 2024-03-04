package Maventest.WVMD.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.Commonutilities;

public class LoginPage extends Commonutilities{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),' Log in ')]")
	WebElement loginbutton;
	
	public void loginApp(String uname, String pass) throws InterruptedException
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginbutton.click();
		Thread.sleep(4000);
	}
	
	public void goToURL()
	{
		driver.get("https://s-app.mocingbird.com/");
		
	}
	
	
	
	
	
	
	
}
