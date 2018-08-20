package com.rao.test.productinfo.repository;

import java.util.HashMap;
import java.util.Map;

import com.rao.test.productinfo.domain.ProductInTransit;
import com.rao.test.productinfo.domain.ProductItem;

public class ProductRepositoryImpl {

	//{$UPS_TRACK_NUMBER}~{$STORE}~{$WH}~{$SKU1}~0~{$QTY1}~{$SKU2}~{$UPC2}~{$QTY2}~{$SKU3}~{$0}~{$QTY3)~

	public static String prepareSecondString(ProductInTransit productInTransit) {
		
		String request2 = null;
		
		String upsTrackNumber = null;
		String warehouseCode = null;
		String storeCode = null;

		for(ProductItem productItem : productInTransit.getItemList()) {
			
			System.out.println("Product Item : " +productItem);
			
			upsTrackNumber = productItem.getTrackingNumber();
			warehouseCode = productItem.getWarehouseCode();
			storeCode = productItem.getStoreCode();
			
			request2 = productItem.getSKU()+"~"+productItem.getUPC()+"~"+productItem.getQuantity();
			
			System.out.println("SKU : "+ productItem.getSKU() +", Request :: " + request2);
		}
		request2 = upsTrackNumber+"~"+storeCode+"~"+warehouseCode+"~"+request2+"~";
		
		System.out.println("Request 2 : " + request2);
		
		return request2;
	}



	public static String getResult(String sku) {

		if(sku.equalsIgnoreCase("11")) {
			return "SUCCESS:1234567";	
		}else if(sku.equalsIgnoreCase("22")){
			return "FAILURE:Sku is not found.";
		}
		return sku;
	}

}
