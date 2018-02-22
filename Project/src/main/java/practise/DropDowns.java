package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://letskodeit.teachable.com/p/practice";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		try {
			WebElement carSelection = driver.findElement(By.id("carselect"));
			Select ele = new Select(carSelection);
			
			ele.selectByIndex(0);
			System.out.println(ele.getAllSelectedOptions().get(0).getText());
			Thread.sleep(1000);
			
			ele.selectByValue("benz");
			System.out.println(ele.getAllSelectedOptions().get(0).getText());
			Thread.sleep(1000);
			
			ele.selectByVisibleText("Honda");
			System.out.println(ele.getAllSelectedOptions().get(0).getText());
			Thread.sleep(1000);
		} catch (ElementNotSelectableException e) {
			System.out.println("Fail | Element not selectable");
		}
		
		try{
			WebElement multiSelect = driver.findElement(By.name("multiple-select-example"));
			Select ele = new Select(multiSelect);
			
			ele.selectByIndex(0);
			List<WebElement> allSelOptions = ele.getAllSelectedOptions();
			for (WebElement ele1:allSelOptions) {
				System.out.println(ele1.getText());
			}
			Thread.sleep(1000);
			
			ele.selectByValue("orange");
			List<WebElement> allSelOptions1 = ele.getAllSelectedOptions();
			for (WebElement ele1:allSelOptions1) {
				System.out.println(ele1.getText());
			}
			Thread.sleep(1000);
			
			ele.selectByVisibleText("Peach");
			List<WebElement> allSelOptions2 = ele.getAllSelectedOptions();
			for (WebElement ele1:allSelOptions2) {
				System.out.println(ele1.getText());
			}
			Thread.sleep(1000);
			
			ele.deselectAll();
			System.out.println(multiSelect.isSelected());
			
		} catch (ElementNotSelectableException e) {
			System.out.println("Fail | Element not selectable");
		}
		
		driver.quit();
	}

}
