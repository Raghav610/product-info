package com.rao.test.productinfo.validation;

import org.apache.commons.lang.StringUtils;

public class CommonUtil {


	public static boolean isEmpty(String str) {
		if (str == null || str.trim().equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isValidLength(String str, int maxLength) {
		if (CommonUtil.isEmpty(str)) {
			return false;
		} else if (str.trim().length() > maxLength) {
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, int maxLength) {
		if (CommonUtil.isEmpty(str)) {
			return false;
		} else if (str.trim().length() > maxLength&&StringUtils.isNumeric(str)) {
			return false;
		} 
		else {return StringUtils.isNumeric(str);}

	}

	public static boolean isNumeric(String str) {

		if(Integer.parseInt(str)<=0) {
			return false;
		}else {
			return StringUtils.isNumeric(str);
		}
	}
	
	public static boolean isValidLength(String str, int maxLength , int minLength) {
		if (str.trim().length() > maxLength || str.trim().length() < minLength) {
			return false;
		}
		return true;
	}

}
