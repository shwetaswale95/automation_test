package test;


import java.io.IOException;

import org.testng.annotations.Test;

import BaseComponents.BaseClass;
import Maventest.WVMD.pageobjects.Dashboard;
import Maventest.WVMD.pageobjects.Filecabinet;

public class WV_MDmaintest extends BaseClass{

	
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\Driver\\chromedriver-win64\\chromedriver.exe"); ChromeOptions options =
		 * new ChromeOptions(); options.addArguments("--remote-allow-origins=*");
		 * ChromeDriver driver= new ChromeDriver(options);
		 */
		
		@Test
		public void stateLicenseFlow() throws IOException, InterruptedException
		{
		launchApp();	
		loginpage.loginApp("shivani.katkar131", "mind@123");
		
		Filecabinet fc= new Filecabinet(driver);
		Thread.sleep(5000);
		fc.filecabistate("West Virginia","WV123", "Test12345");
		
		Dashboard db = new Dashboard(driver);
		db.goToDashboard();
	
		}
		
	

		

	

}
