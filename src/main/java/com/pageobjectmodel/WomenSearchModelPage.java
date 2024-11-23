package com.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.baseclass.Base_Class;
import com.interfaceelements.WomenSearchElementsInterface;
import com.src.main.resource.LumaFIleReaderManager;

public class WomenSearchModelPage extends Base_Class implements WomenSearchElementsInterface {
@FindBy(xpath = womendropdown_xpath)
private WebElement womenDropDown;
@FindBy(xpath = womentop_xpath)
private WebElement womentop;
@FindBy(xpath = womenJacket_xpath)
private WebElement womenJacket;
@FindBy(xpath = womenJacketimage_xpath)
private WebElement womenJacketimage;
@FindBy(xpath =  womenJacketsize_xpath)
private WebElement womenJacketsize;
@FindBy(xpath = womenJacketcolor_xpath)
private WebElement womenJacketcolor;
@FindBy(xpath = womenaddtocart_xpath)
private WebElement womenaddtocart;
@FindBy(xpath = womenaddtocart_xpath)
private WebElement womenvalitation;

public WomenSearchModelPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void womenSearchpage() {
	LumaFIleReaderManager file =new LumaFIleReaderManager();
	
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	hoverTheElement(womenDropDown);
//	hoverTheElement(womentop);
//	moveToTHeElementAndClick(womenJacket);
//	moveToTHeElementAndClick(womenJacketimage);
//	
//	moveToTHeElementAndClick(womenJacketsize);
//	moveToTHeElementAndClick(womenJacketcolor);
//	moveToTHeElementAndClick(womenaddtocart);
//	validation(womenvalitation.getText(),file.getDataProperty("valitation"));
}
public void quite() {
terminateBrowser();
}
}
