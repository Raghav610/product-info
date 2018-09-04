package com.rao.test.productinfo.domain;

public class ProductItem {

	private String SKU ;
	private String UPC ;
	private String quantity;
	private String storeCode;
	private String trackingNumber;

	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getUPC() {
		return UPC;
	}
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	@Override
	public String toString() {
		return "ProductItem [SKU=" + SKU + ", UPC=" + UPC + ", quantity=" + quantity + ", storeCode=" + storeCode
				+ ", trackingNumber=" + trackingNumber + "]";
	}

}
