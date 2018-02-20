package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic_cssSelectors {

	public static void main(String[] args) {
		WebDriver driver;
		String baseurl = "https://www.makemytrip.com/";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		/*1.TagName.ClassName */
		WebElement logo1 = driver.findElement(By.cssSelector("img.mmt_header_logo"));
		System.out.println("Logo displayed? "+logo1.isDisplayed());
		
		/*2.TagName.class1.class2 */
		
		
		/*3. TagName#id */
		WebElement flightsTab = driver.findElement(By.cssSelector("a#header_tab_flights"));
		System.out.println("Flights Tab displayed? "+flightsTab.isDisplayed());
		
		/*4. TagName[prop^='value'] */
		WebElement logo2 = driver.findElement(By.cssSelector("img[class^='mmt_header']"));
		System.out.println("Logo displayed? "+logo2.isDisplayed());
		
		/*5. TagName[prop$='value'] */
		WebElement flightsTab2 = driver.findElement(By.cssSelector("a[id$='flights']"));
		System.out.println("Flights Tab displayed? "+flightsTab2.isDisplayed());
		
		/*6. TagNamep[prop*='value'] */
		WebElement flightsTab3 = driver.findElement(By.cssSelector("a[id*='flights']"));
		System.out.println("Flights Tab displayed? "+flightsTab3.isDisplayed());
		
		driver.quit();
		
	}

}
