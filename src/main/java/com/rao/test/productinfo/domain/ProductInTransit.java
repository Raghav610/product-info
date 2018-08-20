package com.rao.test.productinfo.domain;

import java.util.List;

public class ProductInTransit {

	String jwt;
	List <ProductItem> itemList;
	
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public List<ProductItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<ProductItem> itemList) {
		this.itemList = itemList;
	}
}
