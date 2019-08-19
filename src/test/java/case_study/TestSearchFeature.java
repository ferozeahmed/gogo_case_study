package case_study;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pages.BookInfo;
import pages.SearchPage;
import utils.FrameWorkUtils;
import webDriver.WebDriverInstance;

public class TestSearchFeature {
	
	private static final Logger LOGGER = Logger.getLogger(TestSearchFeature.class);
	
	private int resultIndexToValidate = 0;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		LOGGER.info("Before test Execution: "+FrameWorkUtils.getCurrentTime());
		WebDriverInstance.setBrowser(browser);
	}
	
	@Test(dataProvider="testdata")
	public void validateProductsSearch(String category, String searchProduct) throws Exception {
		/*
		 * create instance of RemoteWebDriver
		 */
		WebDriverInstance.getInstance();
		WebDriver driver = WebDriverInstance.driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		/*
		 * Open the URL
		 */
		driver.get("https://www.amazon.in/");
		
		/*
		 * Create instance of the WebPage 
		 */
		SearchPage searchpage = new SearchPage();
		searchpage.getsearchDropDownSelectList().selectByVisibleText(category);
		searchpage.getsearchBoxTextField().type(searchProduct);
		wait.until(ExpectedConditions.elementToBeClickable(searchpage.getsearchButton().getElement()));
		searchpage.getsearchButton().clickButton();
		
		/*
		 * select the first result
		 */
		List<WebElement> results = searchpage.getsearchResultsContainer();
		WebElement firstResultElement = results.get(resultIndexToValidate);
		firstResultElement.findElement(searchpage.getproductTitle().getLocator()).click();
		
		/*
		 * capture maximum fields
		 */
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		BookInfo info = new BookInfo();
		System.out.println(info.getBookTitle().getLabelText());
		System.out.println(info.getAuthorInfo().getLabelText());
		System.out.println(info.getAverageCustomerReviews().getLabelText());
		System.out.println(info.getBookEditions().getLabelText());
		driver.quit();
	}
	
	@AfterMethod
	public void tearDown() {
		LOGGER.info("After test Execution: "+FrameWorkUtils.getCurrentTime());
	}
	
	@DataProvider(name="testdata")
	public Object[][] testData() {
		return new Object[][] {
			{"Books", "data"},
			{"Books", "data structures and algorithms"}
		};
	}

}
