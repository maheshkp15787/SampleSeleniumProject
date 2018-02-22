package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_MouseHover {

	public static void main(String[] args) {
		WebDriver driver; 
		String baseurl = "https://www.makemytrip.com/";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		Actions act = new Actions(driver);
		WebElement moreBtn = driver.findElement(By.id("ch_funnel_more"));
		WebElement myBusiness = driver.findElement(By.id("hdr_myBusiness"));
		
		act.click(moreBtn).click(myBusiness).build().perform();
		
		System.out.println("Pass");
		driver.quit();
		
	}

}
