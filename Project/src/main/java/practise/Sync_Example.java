package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Sync_Example {

	public static void main(String[] args) {
		String userDir,baseUrl;
		WebDriver driver;
		WebDriverWait wait;
		
		userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		baseUrl = "https://www.makemytrip.com/";
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.id("header_tab_hotels")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='header_tab_hotels'][@class='hdr_item_link active']")));
			System.out.println("PASS");
		} catch(ElementNotFoundException e){
			System.out.println("Fail");
		}
		
		driver.quit();

	}

}
