package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.utility.flipUtil;

public class flipkartBaseclass {
	
//  -------------------------------------------------------------------------------------------------------------------
// set the object reposetory ( property file )
	
	public static Properties prop;
		
	public flipkartBaseclass() throws Exception{
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\acer\\eclipse-workspace"
				+ "\\FlipkartTest\\src\\main\\java\\com\\flipkart\\config\\flipConfig.properties");
		prop.load(ip);
	}
	
//  -------------------------------------------------------------------------------------------------------------------
//  set the initialization method ( browser lounching, maximize , delete cookies and tmieouts
	
	
	public static WebDriver driver;

	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().window().maximize(); // maximize the window
//		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(flipUtil.page_load_timeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(flipUtil.implicit_wait, TimeUnit.SECONDS);
		
		
	}
	

}
