package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.flipkartBaseclass;
import com.flipkart.utility.flipUtil;

public class Homepage extends flipkartBaseclass {

	@FindBy(className = "_2xm1JU")
	WebElement logo;

	@FindBy(className = "xtXmba")
	WebElement Fashion;

	@FindBy(className = "xtXmba")
	WebElement Electronics;

//  -------------------------------------------------------------------------------------------------------------------

	public Homepage() throws Exception {

		PageFactory.initElements(driver, this);
	}

//  -------------------------------------------------------------------------------------------------------------------

	public String HomePageTittle() {

		return driver.getTitle();
	}

	public boolean HomePageLogo() {

		return logo.isDisplayed();
	}

	public void FashionBtn() throws Exception {

		flipUtil.MouseMovement(Fashion);
	}

	public EarbudsPage ElectronicsBtn() throws Exception {

		flipUtil.MouseMovement(Electronics);
		Thread.sleep(5000);

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='_1psGvi SLyWEo']//a"));

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getText());

				if (list.get(i).getText().contains("True Wireless Earbuds")) {
					list.get(i).click();
				}
			}

			return new EarbudsPage();
		}
	
	

	}


