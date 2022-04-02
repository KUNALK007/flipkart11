package com.flipkart.testCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.utility.flipUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReportsConcept {
	
	public static WebDriver driver ;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output/extentReport.html", true);
		extent.addSystemInfo("host name", "kunal window");
		extent.addSystemInfo("user name", "kunal automation");
		extent.addSystemInfo("env name", "QA automation");
		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
		
		
	}
	
	public static String getScreenshot(WebDriver driver , String ssName) throws IOException {
		
		String DateName = new SimpleDateFormat("yyymmddmmss").format(new Date());
		
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+ "/FailTestScreenShots/" + ssName + DateName + ".png";
		File finaldestination = new File(destination);
		
		FileUtils.copyFile(ss, finaldestination);
		return destination;
	}
	
	
	
	
	@BeforeMethod
	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().window().maximize(); // maximize the window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.get("https://www.w3schools.com/");
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void w3Tittle() {
		extentTest = extent.startTest("extentReportsConcept");
		String tittle = driver.getTitle();
		Assert.assertEquals(tittle, "W3Schools Online Web Tutorials123");
	}
	
	
	
	@AfterMethod
	public void TearDown(ITestResult result) throws IOException {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case fail  is " + result.getName()); // add name in extent report
			extentTest.log(LogStatus.FAIL, "Test case fail  is " + result.getThrowable()); // exception in extent report 
			
			String SsPath = extentReportsConcept.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(SsPath)); //add screenshot in extent report 
			extentTest.log(LogStatus.FAIL, extentTest.addScreencast(SsPath)); //add cast video in extent report 
			
		} else if(result.getStatus()==ITestResult.SKIP) {
			
			extentTest.log(LogStatus.SKIP, "test case skip is  " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			
			extentTest.log(LogStatus.PASS, "test case pass is  " +result.getName());

		}
		
		extent.endTest(extentTest); // end the test and prepare  to creat HTML report
		
		driver.quit();
	}
	
	
	

}
