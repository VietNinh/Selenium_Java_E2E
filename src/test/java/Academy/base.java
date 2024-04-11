package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class base {
	
	public WebDriver driver;
	
	
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Project\\workSpace\\E2EProject\\src\\test\\java\\Academy\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
		//chrome
		if (browserName=="chrome") {
			//execute in chrome driver
//			System.setProperty("webdriver.chrome.driver","D:\\Project\\workSpace\\E2EProject\\driver\\chromedriver.exe");
//			driver = new ChromeDriver();
			String chromePath = "D:\\A\\Money\\Airdrop\\ACC01\\GoogleChromePortable\\GoogleChromePortable.exe";
			String chromedriverpath="D:\\Project\\workSpace\\E2EProject\\driver\\chromedriver.exe";
			ChromeOptions myOptions = new ChromeOptions();
			myOptions.setBinary(chromePath);
			System.setProperty("webdriver.chrome.driver",chromedriverpath);
			WebDriver driver = new ChromeDriver(myOptions);
//			DriverFactory.changeWebDriver(driver);
		}
		
		
		//firefox
		else if (browserName=="firefox") {
			//execute in chrome driver
			System.setProperty("webdriver.gecko.driver","D:\\Project\\workSpace\\E2EProject\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//IE
		else if (browserName=="IE") {
			//execute in chrome driver
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	
	}
	
	
}
