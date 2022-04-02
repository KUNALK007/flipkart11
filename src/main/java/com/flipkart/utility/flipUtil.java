package com.flipkart.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.flipkart.base.flipkartBaseclass;

public class flipUtil extends flipkartBaseclass {

	flipUtil() throws Exception {
		// create because we extend the testBasecls
	}

//  -------------------------------------------------------------------------------------------------------------------

	public static long implicit_wait = 20;
	public static long page_load_timeOut = 20;

//  -------------------------------------------------------------------------------------------------------------------

	public static void MouseMovement(WebElement element) throws Exception {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		Thread.sleep(2000);
	}

//  -------------------------------------------------------------------------------------------------------------------

		
//  -------------------------------------------------------------------------------------------------------------------

	
	
	

}
