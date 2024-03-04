package BaseComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Maventest.WVMD.pageobjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage loginpage;
	public WebDriver initializeBrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Maventest\\Resources\\configuration.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Initiated");
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser Initiated");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println("Ms-Edge Browser Initiated");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	
	}
	
		@BeforeMethod
		public LoginPage launchApp() throws IOException
		{
		driver = initializeBrowser();
		loginpage =new LoginPage(driver);
		loginpage.goToURL();
		return loginpage;
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
		
}
