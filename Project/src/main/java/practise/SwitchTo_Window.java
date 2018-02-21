package practise;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTo_Window {

	public static void main(String[] args) {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://letskodeit.teachable.com/p/practice";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		String cHandle = driver.getWindowHandle();
		WebElement newWindowBtn = driver.findElement(By.id("openwindow"));
		newWindowBtn.click();
		
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			if ( !handle.equalsIgnoreCase(cHandle)) {
				
				try{
					driver.switchTo().window(handle);
					Thread.sleep(5000);
					driver.findElement(By.id("search-courses")).isDisplayed();
					System.out.println("Switched to Window and searched for Course");
					driver.switchTo().window(cHandle);
					break;
				}catch (Exception e) {
					System.out.println("Switched to Window and searched for Course failed");
				}
			}
		}
		
		System.out.println("Navigation back to main window? "+newWindowBtn.isDisplayed());
		
		driver.quit();
	}

}
