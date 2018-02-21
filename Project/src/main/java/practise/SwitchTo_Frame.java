package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTo_Frame {

	public static void main(String[] args) {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://letskodeit.teachable.com/p/practice";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		WebElement newWindowBtn = driver.findElement(By.id("openwindow"));
		try{
			driver.switchTo().frame("courses-iframe");
			driver.findElement(By.id("search-courses")).isDisplayed();
			System.out.println("Navigation To frame is | PASS");
			driver.switchTo().defaultContent();
		} catch(NoSuchFrameException e) {
			System.out.println("No frame with specified details present");
		}
		
		if (newWindowBtn.isDisplayed()) {
			System.out.println("Navigation back to Mainwindow | PASS");
		} else {
			System.out.println("Navigation back to Mainwindow | FAIL");
		}
		
		driver.quit();
	}

}
