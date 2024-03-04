package Maventest.WVMD.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.Commonutilities;

public class Filecabinet extends Commonutilities{

	WebDriver driver;
	public Filecabinet(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(xpath="//div/ul/li[2]/a[text()='File Cabinet']")
	WebElement filecabinet;
	
	@FindBy(css="#sl_static")
	WebElement StateLicensefolder;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary btn-basic\"]")
	WebElement AddStateLicense;
	
	@FindBy(xpath="//*[@id=\"state\"]/div/div/div[2]/input")
	WebElement state;
	
	@FindBy(css="#license_number")
	WebElement LicenseNumber;
	
	@FindBy(css="#expiry_date")
	WebElement expirydate;
	
	@FindBy(xpath="//div[@class='flag-spacing']/span[1]/label/input[@id='radio0']")
	WebElement imlc;
	
	@FindBy(css="#license_type")
	WebElement licensetype;
	
	@FindBy(id="initial_date")
	WebElement initialdate;
	
	@FindBy(xpath="//button[contains(text(),' Save State License ')]")
	WebElement savestatelicense;
	
	By datepickerbody=By.xpath("//div[@class='bs-datepicker-body']");
	
	public void filecabistate(String statename, String licensenumber, String license_type) throws InterruptedException
	{
		filecabinet.click();
		Thread.sleep(5000);
		StateLicensefolder.click();
		Thread.sleep(5000);
		AddStateLicense.click();
		Thread.sleep(4000);
		state.click();
		Thread.sleep(10000);
		state.sendKeys(statename);
		Thread.sleep(6000);
		state.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		LicenseNumber.sendKeys(licensenumber);
		Thread.sleep(4000);
		expirydate.click();
		Thread.sleep(4000);
		
		String Month = driver.findElement(By.xpath("//div/bs-datepicker-navigation-view/button[2]")).getText();
		String Year = driver.findElement(By.xpath("//div/bs-datepicker-navigation-view/button[3]")).getText();
		while(!(Month.equals("June") && Year.equals("2024")))
		{
			driver.findElement(By.className("next")).click();
			Month = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
			Year = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")).getText();
		}
		
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[6]/td[1]/span")).click();
		
		Thread.sleep(2000);
		imlc.click();
		Thread.sleep(2000);
		licensetype.sendKeys(license_type);
		Thread.sleep(2000);
		initialdate.click();
		waitForElementToAppear(datepickerbody);
		
		String Month1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
		String Year1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")).getText();
				
		while(!(Month1.equals("May") && Year1.equals("2022")))
		{
		driver.findElement(By.className("previous")).click();
		Month1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
		Year1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")).getText();
		}
				
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[4]/td[2]/span")).click();
		Thread.sleep(2000);
		savestatelicense.click();
		System.out.println("State license saved successfully");
		Thread.sleep(4000);
		
	}
	
	
	
	
	
	
	
}
