package Maventest.WVMD.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.Commonutilities;

public class Dashboard extends Commonutilities {

	WebDriver driver;
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@id='navbarText']/ul/li[1]")
	WebElement dashboard;
	
	@FindBy(xpath="//div[@class='d-flex']/button[1]")
	WebElement statelicensetab;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[3]/div[2]/div[2]/div[2]/app-dashboard-sections[1]/div[2]/ngx-slick-carousel[1]/div[1]/div[1]/div[1]/div[2]/button[1]")
	WebElement View_Details;
	
	@FindBy(xpath = "(//div[@class='outer-section'])[1]")
	WebElement Remaining_Task;
	
	
	
	public void goToDashboard() throws InterruptedException
	{
		dashboard.click();
		Thread.sleep(5000);
		statelicensetab.click();
		Thread.sleep(2000);
		View_Details.click();
		Thread.sleep(4000);
		Remaining_Task.click();
		System.out.println("Displaying remaining task count:");
		
		
		
	}
	
	

}
