package pages;

import org.openqa.selenium.By;

import pageElements.Label;

public class BookInfo {
	
	private Label booktitle;
	private Label authorInfo;
	private Label customerReviews;
	private Label bookEditions;
	
	public Label getBookTitle() {
		Label element = this.booktitle;
		if(element == null) {
			this.booktitle = new Label(By.id("productTitle"));
			element = this.booktitle;
		}
		return booktitle;
	}
	
	public Label getAuthorInfo() {
		Label element = this.authorInfo;
		if(element == null) {
			this.authorInfo = new Label(By.id("bylineInfo"));
			element = this.authorInfo;
		}
		return authorInfo;
	}
	
	public Label getAverageCustomerReviews() {
		Label element = this.customerReviews;
		if(element == null) {
			this.customerReviews = new Label(By.id("averageCustomerReviews_feature_div"));
			element = this.customerReviews;
		}
		return customerReviews;
	}
	
	public Label getBookEditions() {
		Label element = this.bookEditions;
		if(element == null) {
			this.bookEditions = new Label(By.id("tmmSwatches"));
			element = this.bookEditions;
		}
		return bookEditions;
	}
}
