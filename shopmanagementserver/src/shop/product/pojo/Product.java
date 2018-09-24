package shop.product.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private String pId;
	// 产品名称
	private String pName;
	// 产品单价
	private float price;
	// 产品类别 1、2、3……
	private String pCategory;
	// 库存数量
	private int stockNum;
	// 产品上下架状态
	private String status;
	
	public Product() {
		super();
	}

	public Product(String pId, String pName, float price, String pCategory, int stockNum, String status) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.pCategory = pCategory;
		this.stockNum = stockNum;
		this.status = status;
	}
	
	public void set(String pId, String pName, float price, String pCategory, int stockNum, String status) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.pCategory = pCategory;
		this.stockNum = stockNum;
		this.status = status;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", price=" + price + ", pCategory=" + pCategory
				+ ", stockNum=" + stockNum + ", status=" + status + "]";
	}

}
