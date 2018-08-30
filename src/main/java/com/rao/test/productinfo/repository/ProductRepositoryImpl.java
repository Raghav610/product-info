package com.rao.test.productinfo.repository;

import java.util.HashMap;
import java.util.Map;

import com.rao.test.productinfo.domain.ProductInTransit;
import com.rao.test.productinfo.domain.ProductItem;
import com.rao.test.productinfo.validation.CommonUtil;

public class ProductRepositoryImpl {

	//{$UPS_TRACK_NUMBER}~{$STORE}~{$WH}~{$SKU1}~0~{$QTY1}~{$SKU2}~{$UPC2}~{$QTY2}~{$SKU3}~{$0}~{$QTY3)~

	public static String prepareSecondString(ProductInTransit productInTransit) {

		StringBuilder request2 = new StringBuilder();

		String firstPart 	= null;

		System.out.println("Size :::" + productInTransit.getItemList().size());

		for(ProductItem productItem : productInTransit.getItemList()) {

			firstPart = productItem.getTrackingNumber()+"~"+productItem.getStoreCode()+"~"+"796";

			if(CommonUtil.isEmpty(productItem.getSKU()))
				productItem.setSKU("0");
			if(CommonUtil.isEmpty(productItem.getUPC()))
				productItem.setUPC("0");;

				request2 = request2.append(productItem.getSKU()).append("~").append(productItem.getUPC()).append("~").append(productItem.getQuantity()).append("~");

				System.out.println("SKU : "+ productItem.getSKU() +", Request_2:: " + request2);
		}
		StringBuilder sb = new StringBuilder();

		sb = sb.append(firstPart).append("~").append(request2);

		System.out.println("Request_Param_2 : " + sb.toString());

		String[] strArr = sb.toString().split("~");
		System.out.println("Length :: " + strArr.length);

		return sb.toString();
	}

	public static Map<String,String> populateRequestParam(ProductInTransit productInTransit) {

		StringBuilder requestParamFirst = new StringBuilder(); 
		String firstPartReqParam2 	= null;
		StringBuilder secondPartReqParam2 = new StringBuilder();
		StringBuilder requestParamSecond = new StringBuilder();

		System.out.println("Size :::" + productInTransit.getItemList().size());

		for(ProductItem productItem : productInTransit.getItemList()) {

			firstPartReqParam2 = productItem.getTrackingNumber()+"~"+productItem.getStoreCode()+"~"+"796";

			if(CommonUtil.isEmpty(productItem.getSKU()))
				productItem.setSKU("0");
			if(CommonUtil.isEmpty(productItem.getUPC()))
				productItem.setUPC("0");;

				secondPartReqParam2 = secondPartReqParam2.append(productItem.getSKU()).append("~").append(productItem.getUPC()).append("~").append(productItem.getQuantity()).append("~");

				System.out.println("SKU : "+ productItem.getSKU() +", Request_2:: " + secondPartReqParam2);
		}

		requestParamSecond = requestParamSecond.append(firstPartReqParam2).append("~").append(secondPartReqParam2);

		System.out.println("Request_Param_2 : " + requestParamSecond.toString());

		System.out.println("Length :: " + requestParamSecond.toString().split("~").length);

		requestParamFirst = requestParamFirst.append("OPTORO_RETURNS~IN_TRANSIT~").append(productInTransit.getItemList().size()).append(requestParamSecond.toString().split("~").length).append("~");

		System.out.println("Request_Param_1 : " + requestParamFirst.toString());

		Map<String,String> map = new HashMap<String,String>();
		map.put("RequestParamOne", requestParamFirst.toString());
		map.put("RequestParamTwo", requestParamSecond.toString());

		return map;

	}

	public static String getResult(String sku) {

		if(sku.equalsIgnoreCase("12345678")) {
			return "SUCCESS:1234567";	
		}else if(sku.equalsIgnoreCase("22345678")){
			return "FAILURE:Sku is not found.";
		}
		return sku;
	}

}
