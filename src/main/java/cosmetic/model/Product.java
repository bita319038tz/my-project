package cosmetic.model;

public class Product {

	private int productId;
	private String productName;
	private String categoryName;
	private String productPrice;
	private int categoryId;
	
	public Product(int productId, String productName, String productPrice, int categoryId, String categoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Product(String productName, String productPrice, int categoryId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
