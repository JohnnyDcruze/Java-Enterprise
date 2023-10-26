package db.demo;

import java.io.Serializable;

public class Product implements Serializable{

	private int prdId;
	private String prdName;
	private float prdPrice;
	public Product() {
		prdId=0;
		prdName="";
		prdPrice=0.0F;
	}
	public Product(int prdId, String prdName, float prdPrice) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
 
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public float getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(float prdPrice) {
		this.prdPrice = prdPrice;
	}
}
