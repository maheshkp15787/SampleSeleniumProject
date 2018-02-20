package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicLocators {

	public static void main(String[] args) {
		//Declaring variables
		WebDriver driver;
		String baseurl , userDir;
		
		//Defining project directory and Setting driver path
		userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		baseurl = "https://www.makemytrip.com/";
		
		//Launching the driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		
		//1. //TagName[@attribute='value']
				WebElement logo = driver.findElement(By.xpath("//img[@class='mmt_header_logo']"));
				System.out.println("Logo displayed? "+logo.isDisplayed());
				
				//2. //TagName[text()='value']
				WebElement hotels = driver.findElement(By.xpath("//a[text()='hotels']"));
				System.out.println("Hotels tab displayed? "+hotels.isDisplayed());
				
				//3. //tagName[start-with(@prop,'value')]
				WebElement homeStay = driver.findElement(By.xpath("//a[starts-with(text(),'home')]"));
				System.out.println("HomeStay Tab displayed? "+homeStay.isDisplayed());
				
				//4 //tagName[contains(@prop,'value')]
				WebElement bus = driver.findElement(By.xpath("//a[contains(@id,'bus')]"));
				System.out.println("Bus tab dispalyed? "+bus.isDisplayed());
				
				//5. //tagName[contains(@prop,'value') and Contains(@prop,'value')]
				WebElement hotels1 = driver.findElement(By.xpath("//a[contains(@id,'tab') and contains(@id,'hotels')]"));
				System.out.println("Hotels Tab Displayed? "+hotels1.isDisplayed());
				
				//6. //x-PathToSomeEle//Parent::tag
				WebElement homeStay1 = driver.findElement(By.xpath(".//*[@id='header_tab_homestay']//parent::li"));
				System.out.println("HomeStay tab displayed? "+homeStay1.isDisplayed());
				
				//7. //x-PathToSomeEle//Preceding-sibling::tagName
				WebElement cabs = driver.findElement(By.xpath("//span[text()='OUTSTATION']//preceding-sibling::a"));
				System.out.println("Cabs Tab Displayed? "+cabs.isDisplayed());
				
				//8. //x-pathToSomeEle//following-Sibling::tagName
				WebElement outStation = driver.findElement(By.xpath("//a[text()='cabs']//following-sibling::span"));
				System.out.println("OutStation tab Displayed? "+outStation.isDisplayed());
				
				//9. //x-pathToSomeEle//[index] Index starts with 1
				WebElement bus1 = driver.findElement(By.xpath("//a[@id='header_tab_holidays']//parent::li//following-sibling::li[2]"));
				System.out.println("Bus Tab displayed? "+bus1.isDisplayed());
				
				//10. //tagName[@prop1='value'][@prop2='value']
				WebElement giftCards = driver.findElement(By.xpath("//a[contains(@id,'header_tab')][text()='gift cards']"));
				System.out.println("GiftCards tab displayed? "+giftCards.isDisplayed());
				
		//quitting the driver
		driver.quit();
	}

}
