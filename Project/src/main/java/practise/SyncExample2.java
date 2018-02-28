package practise;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SyncExample2 {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		String baseUrl = "https://www.makemytrip.com/";
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement hotelTab = WaitTypes.getElementWhenReady(driver, By.id("header_tab_hotels"), 30);
		hotelTab.click();
		Timestamp timeSt1 = new Timestamp(System.currentTimeMillis());
		WebElement hotelTabSel = WaitTypes.getElementWhenReady(driver, By.xpath("//a[@id='header_tab_hotels'][@class='hdr_item_link active']"), 30);
		if (hotelTabSel.isDisplayed()) {
			Timestamp timeSt2 = new Timestamp(System.currentTimeMillis());
			System.out.println(timeSt1);
			System.out.println("Pass | Hotel Tab selected");
			System.out.println(timeSt2);
		} else {
			System.out.println("Fail | Hotel tab not selected");
		}
		
		driver.quit();
	}

}
