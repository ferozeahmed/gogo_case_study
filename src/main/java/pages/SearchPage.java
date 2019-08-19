package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageElements.Button;
import pageElements.SelectList;
import pageElements.TextField;
import webDriver.WebDriverInstance;

public class SearchPage {
	
	private TextField searchBoxTextField;
	private SelectList searchDropDownSelectList;
	private Button searchButton;
	private TextField productTitle;
	private TextField productPrice;
	
	public TextField getsearchBoxTextField() {
		TextField element = this.searchBoxTextField;
		if(element == null) {
			this.searchBoxTextField = new TextField(By.id("twotabsearchtextbox"));
			element = this.searchBoxTextField;
		}
		return element;
	}
	
	public SelectList getsearchDropDownSelectList() {
		SelectList element = this.searchDropDownSelectList;
		if(element == null) {
			this.searchDropDownSelectList = new SelectList(By.id("searchDropdownBox"));
			element = this.searchDropDownSelectList;
		}
		return element;
	}
	
	public Button getsearchButton() {
		Button element = this.searchButton;
		if(element == null) {
			this.searchButton = new Button(By.xpath("//input[@value='Go']"));
			element = this.searchButton;
		}
		return element;
	}
	
	public TextField getproductTitle() {
		TextField element = this.productTitle;
		if(element == null) {
			this.productTitle = new TextField(By.cssSelector("h2 > a"));
			element = this.productTitle;
		}
		return element;
	}
	
	public TextField getproductPrice() {
		TextField element = this.productPrice;
		if(element == null) {
			this.productPrice = new TextField(By.cssSelector(".a-price"));
			element = this.productPrice;
		}
		return element;
	}
	
	public List<WebElement> getsearchResultsContainer() {
		return WebDriverInstance.driver.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));
	}

}
