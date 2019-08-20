package case_study;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import pages.BookInfo;
import pages.SearchPage;
import webDriver.WebDriverInstance;

/**
 * Test case:
 * 1. login to Amazon.in
 * 2. select Category and search for given text
 * 3. Select the first result and go to transaction log page
 * 4. capture maximum data points of the product
 * @author ferahmed
 *
 */
public class TestSearchFeature {
	
	private int resultIndexToValidate = 0;
	private WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	/*
	 * @beforeTest method
	 * get the Browser value from testNG.xml
	 * Set browser instance in the beforeTest method
	 * Create the Extent Report instance for reporting
	 */
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		System.out.println("Test Reports Path : "+System.getProperty("user.dir") +"/test-output/extentReport.html");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/extentReport.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report");
        htmlReporter.config().setReportName("GOGO Case Study");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        
		WebDriverInstance.setBrowser(browser);
	}
	
	/*
	 * @Test method
	 * input: category, searchProduct, testData
	 */
	@Test(dataProvider="testdata")
	public void validateProductsSearch(String category, String searchProduct, Map<String, String> testdata) throws Exception {
		test = extent.createTest("Test Params : {"+category+" , "+searchProduct+" }");
		/*
		 * create instance of RemoteWebDriver
		 */
		WebDriverInstance.getInstance();
		driver = WebDriverInstance.driver;
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
		
		/*
		 * Assert with the test data provided
		 */
		BookInfo info = new BookInfo();
		assertTrue(info.getBookTitle().getLabelText().contains(testdata.get("title")), "Title Mismatch!");
		assertTrue(info.getAuthorInfo().getLabelText().contains(testdata.get("author")), "Author Mismatch!");
		assertTrue(info.getAverageCustomerReviews().getLabelText().contains(testdata.get("averagecustomerreviews")), "Average Customer reviews Mismatch!");
		assertTrue(info.getBookEditions().getLabelText().contains(testdata.get("edition")), "edition Mismatch");
	}
	
	/*
	 * @afterMethod to execute after each test
	 * Result is analyzed and added to report
	 * driver.quit() to close the browser instance
	 */
	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        driver.quit();
    }
	
	/*
	 * @afterTest to execute on completion of test
	 * flush to generate html extent report
	 */
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
	
	/*
	 * @dataProvider method used to pass the test data
	 * two dimensional array which holds test data
	 * pass the expected values in Map<String, String>()
	 */
	@DataProvider(name="testdata")
	public Object[][] testData() {
		return new Object[][] {
			{"Books", "data", new HashMap<String, String>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				put("title", "Data Structures and Algorithms Made Easy");
				put("author", "Narasimha Karumanchi (Author)");
				put("averagecustomerreviews", "519 customer reviews");
				put("edition", "Kindle Edition\n" + 
						"₹ 0.00\n" + 
						"This title and over 1 million more available with Kindle Unlimited\n" + 
						"₹ 499.00 to buy\n" + 
						"Paperback\n" + 
						"₹ 499.00\n" + 
						"9 New from ₹ 399.00");
			}}
			},
			{"Books", "data structures and algorithms", new HashMap<String, String>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				put("title", "Data Structures & Algorithms Interview Questions");
				put("author", "Vibrant Publishers");
				put("averagecustomerreviews", "12 customer reviews");
				put("edition", "Kindle Edition\n" + 
						"₹ 599.00\n" + 
						"Read with Our Free App\n" + 
						"Paperback\n" + 
						"₹ 599.00\n" + 
						"19 New from ₹ 599.00");
			}}
			},
			{"Books", "data structures and algorithms", new HashMap<String, String>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				put("title", "Data Structures & Algorithms Interview Questions");
				put("author", "Vibrant Publishers");
				put("averagecustomerreviews", "FAILURE ON PURPOSE!!!");
				put("edition", "Kindle Edition\n" + 
						"₹ 599.00\n" + 
						"Read with Our Free App\n" + 
						"Paperback\n" + 
						"₹ 599.00\n" + 
						"19 New from ₹ 599.00");
			}}
			}
		};
	}

}
