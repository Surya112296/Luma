package com.runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.Base_Class;
import com.interfaceelements.WomenSearchElementsInterface;
import com.pageobjectmanager.LumaPageObjectManager;
import com.utility.ExcelUtility;

public class LumaTestRunner extends Base_Class  {
	
	LumaPageObjectManager pageObjectManger = new LumaPageObjectManager ();
	@BeforeTest
	public void setteUp() {
		browserLaunch(pageObjectManger.getLumaFIleReaderManager().getDataProperty("browser"));
		launchUrl(" https://demo.openmrs.org/openmrs/login.htm");
		
	}
@Test(priority = 1)

public void womenSearchModel () {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebElement women = driver.findElement(By.id("username"));	
	passInput(women,ExcelUtility.getCellValue("Sheet1", "USER NAME", "USER NAME"));
	
}

@AfterTest
private void close() {

}
}
