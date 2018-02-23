package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutor_P {

	public static void main(String[] args) throws InterruptedException {
		String userDir,baseUrl,script;
		WebDriver driver;
		JavascriptExecutor js;
		
		userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		baseUrl = "https://www.makemytrip.com/";
		script = "document.getElementById('header_tab_flights').click()";
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		js = (JavascriptExecutor)driver;
		js.executeScript(script);
		Thread.sleep(5000);
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.makemytrip.com/flights/")){
			System.out.println("Java script execution is Pass");
		} else {
			System.out.println("Java script execution is Failed");
		}
		
		driver.quit();

	}

}
