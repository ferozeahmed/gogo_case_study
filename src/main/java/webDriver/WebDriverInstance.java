package webDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import seleniumGrid.Grid;

/**
 * 
 * @author ferahmed
 *
 */
public class WebDriverInstance {
	
	private static WebDriverInstance instance = null;
	
	public static RemoteWebDriver driver;
	
	private static String browserName = "";
	
	private WebDriverInstance() {
		driver = driverInstance(BrowserFlavors.getBrowserName(browserName));
	}
	
	public static WebDriverInstance getInstance() {
		if(instance == null || 	driver.toString()!=null) {
			instance = new WebDriverInstance();
		}
		return instance;
	}
	
	public static void setBrowser(String browser) {
		browserName = browser;
	}

	/**
	 * 
	 * @param driverName
	 * @return
	 * 	returns the driver instance <br>
	 * 	Usage: driverInstance(BrowserFlavors.getBrowser("chrome"))
	 */
	private static RemoteWebDriver driverInstance(BrowserFlavors driverName) {
		
		RemoteWebDriver driver = null;
		
		/*
		 * create instance of webDriver
		 * switch based on driver name
		 */
		switch (driverName) {
		case CHROME:
			driver = new ChromeDriver();
	        break;
	        
		default:
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(false);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(Grid.getGridUrl(), capability);
			break;
		}
		
		return driver;
		
	}
}
