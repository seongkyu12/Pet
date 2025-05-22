package kr.ac.kopo.petshop.model;

public class Product {
	private String productId;
	private String name;
	private String weight;
	private String info;
	private int price;
	private int additionalPrice;
	private String dogSize;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAdditionalPrice() {
		return additionalPrice;
	}
	public void setAdditionalPrice(int additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	public String getDogSize() {
		return dogSize;
	}
	public void setDogSize(String dogSize) {
		this.dogSize = dogSize;
	}
	
}
