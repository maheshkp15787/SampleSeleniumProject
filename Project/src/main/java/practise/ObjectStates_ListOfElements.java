package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectStates_ListOfElements {

	public static void main(String[] args) {
		WebDriver driver;   //Refer "https://saucelabs.com/resources/articles/selenium-tips-css-selectors"
		String baseurl = "https://letskodeit.teachable.com/p/practice";
		String userDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		WebElement bmwRadBut = driver.findElement(By.id("bmwradio"));
		WebElement benzRadBut = driver.findElement(By.id("benzradio"));
		WebElement hondaRadBut = driver.findElement(By.id("hondaradio"));
		
		WebElement bmwCheckbox = driver.findElement(By.id("bmwcheck"));
		WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
		WebElement hondaCheckbox = driver.findElement(By.id("hondacheck"));
		
		List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@name='cars']"));
		for (WebElement ele : listOfRadioButtons) {
			ele.click();
			System.out.println("Bmw radio button selected? "+bmwRadBut.isSelected());
			System.out.println("Benz radio button selected? "+benzRadBut.isSelected());
			System.out.println("Honda radio button selected? "+hondaRadBut.isSelected());
			System.out.println("Bmw checkbox selected? "+bmwCheckbox.isSelected());
			System.out.println("Benz checkbox selected? "+benzCheckbox.isSelected());
			System.out.println("honda checkbox selected? "+hondaCheckbox.isSelected());
			System.out.println("======================================================================");
		}
		
		driver.quit();
	}

}
