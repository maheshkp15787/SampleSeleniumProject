package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationBetweenPages {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://www.makemytrip.com/";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		WebElement busTab = driver.findElement(By.id("header_tab_bus"));
		
		System.out.println("Page Title on Home page: "+driver.getTitle() +" url is: " +driver.getCurrentUrl());
		busTab.click();
		Thread.sleep(5000);
		System.out.println("Page Title after clicking on Bus Tab: "+driver.getTitle() +" url is: " +driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(5000);
		System.out.println("Page Title after Navigation back: "+driver.getTitle() +" url is: " +driver.getCurrentUrl());
		driver.navigate().forward();
		Thread.sleep(5000);
		System.out.println("Page Title after Navigation forward: "+driver.getTitle() +" url is: " +driver.getCurrentUrl());
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Page Title after Navigation refresh: "+driver.getTitle() +" url is: " +driver.getCurrentUrl());
		
		driver.quit();
	}

}
