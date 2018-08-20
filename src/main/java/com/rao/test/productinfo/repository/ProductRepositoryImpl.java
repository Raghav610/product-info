package com.rao.test.productinfo.repository;

import java.util.HashMap;
import java.util.Map;

import com.rao.test.productinfo.domain.ProductInTransit;
import com.rao.test.productinfo.domain.ProductItem;

public class ProductRepositoryImpl {

	//{$UPS_TRACK_NUMBER}~{$STORE}~{$WH}~{$SKU1}~0~{$QTY1}~{$SKU2}~{$UPC2}~{$QTY2}~{$SKU3}~{$0}~{$QTY3)~

	public static String prepareSecondString(ProductInTransit productInTransit) {
		
		StringBuilder request2 = new StringBuilder();
		
		String upsTrackNumber = null;
		String warehouseCode = null;
		String storeCode = null;

		for(ProductItem productItem : productInTransit.getItemList()) {
			
			System.out.println("Product Item : " +productItem + ", Request 2 : " + request2);
			
			upsTrackNumber = productItem.getTrackingNumber();
			warehouseCode = productItem.getWarehouseCode();
			storeCode = productItem.getStoreCode();
			
			//request2 = productItem.getSKU()+"~"+productItem.getUPC()+"~"+productItem.getQuantity();
			
			request2 = request2.append(productItem.getSKU()).append("~").append(productItem.getUPC()).append("~").append(productItem.getQuantity());
			
			System.out.println("SKU : "+ productItem.getSKU() +", Request :: " + request2);
		}
		//request2 = upsTrackNumber+"~"+storeCode+"~"+warehouseCode+"~"+request2+"~";
		StringBuilder sb = new StringBuilder();
		
		sb = sb.append(upsTrackNumber).append("~").append(storeCode).append("~").append(warehouseCode).append("~").append(request2).append("~");
		
		System.out.println("Request 2 : " + sb.toString());
		
		return sb.toString();
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
