package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTo_Alert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://letskodeit.teachable.com/p/practice";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		driver.findElement(By.id("name")).sendKeys("Alert");
		driver.findElement(By.id("alertbtn")).click();
		
		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert is presnt wit title: " +alt.getText());
			Thread.sleep(2000);
			alt.accept();
		}catch (NoAlertPresentException e) {
			System.out.println("No Alert is Present");
		}
		
		driver.findElement(By.id("confirmbtn")).click();
		
		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert is presnt wit title: " +alt.getText());
			Thread.sleep(2000);
			alt.dismiss();
		}catch (NoAlertPresentException e) {
			System.out.println("No Alert is Present");
		}
		
		driver.quit();

	}

}
