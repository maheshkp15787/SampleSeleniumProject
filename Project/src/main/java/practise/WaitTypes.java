package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	/**
	 * This method returns an element when ready
	 * @param driver
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement getElementWhenReady(WebDriver driver,By locator,int timeOut){
		WebElement ele = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return ele;
	}
	
	/**
	 * This Method returns the object when able to click
	 * @param driver
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement getElementWhenClickable(WebDriver driver,By locator,int timeOut) {
		WebElement ele = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		ele = wait.until(ExpectedConditions.
				elementToBeClickable(locator));
		return ele;
	}
	
	public static boolean getElementToBeInvisible(WebDriver driver,By locator,int timeOut){
		boolean eleInVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		eleInVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return eleInVisible;
	}
	
}

