package utils;

public class SearchResultsPOJO {

	private String productTitle;
	private String price;
	private String customerReviews;
	private String editions;
	private String deliverySpeed;
	
	public void setproductTitle(String _productTitle) {
		this.productTitle = _productTitle;
	}
	
	public String getproductTitle() {
		return productTitle;
	}
	
	public void setprice(String _price) {
		this.price = _price;
	}
	
	public String getprice() {
		return price;
	}
	
	public void setcustomerReviews(String _customerReviews) {
		this.customerReviews = _customerReviews;
	}
	
	public String getcustomerReviews() {
		return customerReviews;
	}
	
	public void seteditions(String _editions) {
		this.editions = _editions;
	}
	
	public String geteditions() {
		return editions;
	}
	
	public void setdeliverySpeed(String _deliverySpeed) {
		this.deliverySpeed = _deliverySpeed;
	}
	
	public String getdeliverySpeed() {
		return deliverySpeed;
	}
}
