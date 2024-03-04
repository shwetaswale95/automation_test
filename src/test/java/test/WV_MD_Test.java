package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WV_MD_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://s-app.mocingbird.com/");
		driver.findElement(By.id("username")).sendKeys("michel");
		driver.findElement(By.id("password")).sendKeys("mind@123");
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.cssSelector(".btn.btn-primary"));
		act.click().keyDown(login, Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//File cabinet
	WebElement filecabinet=	driver.findElement(By.xpath("//div/ul/li[2]/a[text()='File Cabinet']"));
	filecabinet.click();
		Thread.sleep(5000);
		//State license
	WebElement statelicensefolder=	driver.findElement(By.cssSelector("#sl_static"));
	statelicensefolder.click();
		Thread.sleep(5000);
		//Add state license
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-basic\"]")).click();
		Thread.sleep(4000);
		WebElement state=	driver.findElement(By.xpath("//*[@id=\"state\"]/div/div/div[2]/input"));
		Thread.sleep(6000);
		state.click();
		Thread.sleep(10000);
		state.sendKeys("West Virginia");
		Thread.sleep(6000);
		state.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		//License number
		driver.findElement(By.cssSelector("#license_number")).sendKeys("WV123");
		Thread.sleep(4000);
		//Expiry date
		driver.findElement(By.cssSelector("#expiry_date")).click();
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
		
		//IMLC radio select
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='flag-spacing']/span[1]/label/input[@id='radio0']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#license_type")).sendKeys("Test12345");
		Thread.sleep(2000);
		//Calendar handling for Initial date
		driver.findElement(By.id("initial_date")).click();
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bs-datepicker-body']")));
				
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
		//Save state license
		driver.findElement(By.xpath("//button[contains(text(),' Save State License ')]")).click();
		System.out.println("State license saved successfully");
		Thread.sleep(4000);
		//Move to dashboard
		driver.findElement(By.xpath("//div[@id='navbarText']/ul/li[1]")).click();
		Thread.sleep(5000);
		//Click the state license button on dashboard
		driver.findElement(By.xpath("//div[@class='d-flex']/button[1]")).click();
		Thread.sleep(2000);
		//Click on view details 
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[3]/div[2]/div[2]/div[2]/app-dashboard-sections[1]/div[2]/ngx-slick-carousel[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Remaining task
		String taskcount =driver.findElement(By.xpath("//div[@class='outer-section'][1]")).getText();
		System.out.println("Number of task for WV state:"+taskcount);
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".col-md-1 .back-button")).click();
		Thread.sleep(5000);
		filecabinet.click();
		Thread.sleep(5000);
		statelicensefolder.click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("select_all_checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Delete ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"batchDeleteCertificate\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(4000);
		driver.close();
		

	}

}
