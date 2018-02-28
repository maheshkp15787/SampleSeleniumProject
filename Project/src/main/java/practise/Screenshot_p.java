package practise;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot_p {

	public static void main(String[] args) throws IOException {
		String userDir,baseUrl;
		WebDriver driver;
		
		userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\resources\\geckodriver.exe");
		baseUrl = "https://www.makemytrip.com/";
		String path = userDir+"\\src\\main\\java\\screenshot\\scShot.png";
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		//Takes Screenshot And copy it to specified folder
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(path));
		
		driver.quit();
	}

}
