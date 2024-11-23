package com.baseclass;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {
	public static WebDriver driver;
	

	// lauching browser
	protected static WebDriver browserLaunch(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH ");
		}
		driver.manage().window().maximize();
		return driver;
	}

	// launching url
	protected static WebDriver launchUrl(String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING URL LAUNCH ");
		}
		return driver;

	}

	// close browser
	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLOSING BROWSER");
		}
	}

	// quit browser
	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {

			Assert.fail("ERROR : OCCUR DURING TERMINATE  BROWSER");
		}

	}

	// send keys - passing input
	protected static WebElement passInput(WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING PASSING INPUT");
		}
		return element;
	}
	
	//passing element for date
	protected static WebElement passDate(WebElement elem, String date) {
		try {
			elem.clear();
			elem.sendKeys(date);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING PASSING INPUT");
		}
		return elem;
	}

	// click - to click the element
	protected static void elementCLick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ELEMENT CLICK");
		}
	}

	// clear --> clear the value
	protected static void elementClear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING CLEAR THE ELEMENT");
		}
	}

	// navigate to another URL
	protected static void navigationPage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATE PAGE");
		}
	}

	// navigate back
	protected static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIAGATE BACK");
		}
	}

	// navigate forward
	protected static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIAGATE FORWARD");
		}

	}

	// navigate refresh
	protected static void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR : OCUURS DURING REFRESH ");
		}

	}

	// select class object to drop down
	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	// select values using selectByVisibleText
	protected static void selectbyVisibleText(WebElement element, String text) {
			dropDownObject(element).selectByVisibleText(text);

	}

	// select values using selectByValue
	protected static void selectedByValue(WebElement element, String value) {
		try {
			dropDownObject(element).selectByValue(value);
		} catch (Exception e) {
		}
		{
			Assert.fail("ERROR : OCCUR DURING SELECT BY VALUE");
		}
	}

	// select values using selectByIndex
	protected static void selectByIndex(WebElement element, int num) {
		try {
			dropDownObject(element).selectByIndex(num);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECT BY INDEX");
		}
	}

	// get title (doubt)
	protected static String title(String titleOfTheurl) {
		try {
			String titleOfTheUrl = driver.getTitle();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING GET TITLE");
		}
		return titleOfTheurl;
	}

	// window handle --> shifting the windows using index
	protected static void windowhandles(int num) {
		List<String> allWindow = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(allWindow.get(num));

	}

	// AlertObject
	protected static Alert switchingAlert(WebElement element) {

		Alert alert = driver.switchTo().alert();

		return alert;

	}

	// is enable
	protected static boolean isEnable(WebElement element) {
		return element.isEnabled();
	}

	// is displayed
	protected static boolean isDisplayed(WebElement element) {

		return element.isDisplayed();

	}

	// is selected
	protected static boolean isSelected(WebElement element) {

		return element.isSelected();
	}

	// implicit wait
	protected static void implicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
		}
	}

	// Explicit wait
	protected static void explicitWait(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
		}
	}
	
	protected static void explicitWaitCLicable(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
		}
	}

	// action
	protected static Actions actionObject() {
		Actions action = new Actions(driver);
		return action;
	}

	// drag and drop element
	protected static void dragAndDrop(WebElement a, WebElement b) {
		try {
			actionObject().dragAndDrop(a, b);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING A DRAG AND DROP");
		}
	}

	// move curser on the element
	protected static void hoverTheElement(WebElement element) {
		try {
			actionObject().moveToElement(element).perform();
			;
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING MOVE TO ELEMENT");
		}
	}

	// right click
	protected static void rightClick(WebElement element) {
		try {
			actionObject().contextClick().perform();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING RIGHT CLICK");
		}
	}

	// double click
	protected static void doubleClick(WebElement element) {
		try {
			actionObject().doubleClick().perform();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING DOUBLE CLICK");
		}
	}

	// move to the element and click
	protected static void moveToTHeElementAndClick(WebElement element) {
		try {
			actionObject().moveToElement(element).click().build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING MOVE TO ELEMENT AND CLICK");
		}
	}

	// screen shot
	protected static void takeScreenShot(String filePath) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;

		try {
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			File destination = new File(filePath);
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING TAKING SCREENSHOT");
		}
	}

	// frames --> switch frame by the use of elements
	protected static void switchFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING SWITCHING THE FRAME");
		}
	}
	
	//javaScrpt executer to scroll down
	protected static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");			
			
}
	
	protected static void validation(String actual , String expected) {
		try {
			Assert.assertEquals(actual,expected);
			
		}catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING VALODATION");
		}
	}
}
