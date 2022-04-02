package com.flipkart.testCase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.flipkartBaseclass;
import com.flipkart.pages.Homepage;

public class HomepageTest extends flipkartBaseclass{

	Homepage Homepage ;
	
	public HomepageTest() throws Exception {
		super();
	}
	
//  -------------------------------------------------------------------------------------------------------------------

	
	@BeforeMethod
	private void setUp() throws Exception {
		initialization();
		Homepage = new Homepage();
		driver.findElement(By.xpath("//div[@class='_2QfC02']//button[@class='_2KpZ6l _2doB4z']")).click();

	}
	
//  -------------------------------------------------------------------------------------------------------------------

	
	@Test
	public void HomePageTittleTest() {

		String tittle = Homepage.HomePageTittle();
		System.out.println(tittle);
		Assert.assertEquals(tittle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","tittle not match");
	}
	
	@Test
	public void HomePageLogoTest() {
		boolean b = Homepage.HomePageLogo();
//		Assert.assertEquals(b, true);
		assertTrue(b);
	}
	
	@Test
	public void FashionBtnTest() throws Exception {
		Homepage.FashionBtn();
		Thread.sleep(5000);
	}
	
	@Test
	public void ElectronicsBtnTest() throws Exception {
		Homepage.ElectronicsBtn();
		
	}
	
//  -------------------------------------------------------------------------------------------------------------------

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
