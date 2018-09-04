package com.rao.test.productinfo.validation;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.rao.test.productinfo.domain.ProductItem;
import com.rao.test.productinfo.exception.BadRequestException;
import com.rao.test.productinfo.exception.ErrorResponse;
import com.rao.test.productinfo.exception.MissingParameterError;
import com.rao.test.productinfo.exception.ProductInfoException;
import com.rao.test.productinfo.utils.ErrorInfo;
import com.rao.test.productinfo.utils.ProductConstants;

@Component
public class RequestValidator {

	@Autowired
	private MessageSource messageSource;

	public boolean isValidRequest(ProductItem productItem) throws MissingParameterError, BadRequestException {

		boolean isValidReq = isNotNullCheck(productItem);

		if(isValidReq) {
			if(productItem.getSKU().length()>0) {
				if(!StringUtils.isNumeric(productItem.getSKU()) || !CommonUtil.isValidLength(productItem.getSKU(), ProductConstants.MAX_LENGTH, ProductConstants.MIN_LENGTH)) {
					throw new BadRequestException(new ErrorInfo(HttpStatus.BAD_REQUEST,messageSource.getMessage(
							ProductConstants.NUMERIC_FIELD_REQUIRED_LENGTH, new Object[] { ProductConstants.FIELD_SKU }, Locale.US)));
				}
			}
			if(!StringUtils.isNumeric(productItem.getQuantity()) || !CommonUtil.isZeroOrNegative(productItem.getQuantity()) ) {
				throw new BadRequestException(new ErrorResponse(messageSource.getMessage(
						ProductConstants.NUMERIC_FIELD_REQUIRED, new Object[] { ProductConstants.FIELD_QUANTITY }, Locale.US)));
			}
			if(productItem.getUPC().length()>0) {
				if(!StringUtils.isNumeric(productItem.getUPC()) || !CommonUtil.isValidLength(productItem.getUPC(), ProductConstants.MAX_LENGTH)){
					throw new BadRequestException(new ErrorResponse(messageSource.getMessage(
							ProductConstants.NUMERIC_FIELD_REQUIRED, new Object[] { ProductConstants.FIELD_UPC }, Locale.US)));
				}
			}
			if(!StringUtils.isNumeric(productItem.getStoreCode())) {
				throw new BadRequestException(new ErrorResponse(messageSource.getMessage(
						ProductConstants.NUMERIC_FIELD_REQUIRED, new Object[] { ProductConstants.FIELD_STORE_CODE }, Locale.US)));
			}
		}
		return true;
	}


	private static boolean isNotNullCheck(ProductItem productItem) throws MissingParameterError {

		if (CommonUtil.isEmpty(productItem.getSKU())) {
			if (CommonUtil.isEmpty(productItem.getUPC())) {
				throw new MissingParameterError(ProductInfoException.GROUP.GENERIC, "SKU or UPC is mandatory.", HttpStatus.BAD_REQUEST);
			}
		} else if (CommonUtil.isEmpty(productItem.getQuantity())) {
			throw new MissingParameterError(ProductInfoException.GROUP.GENERIC, "Quantity is null or empty");
		} else if (CommonUtil.isEmpty(productItem.getStoreCode())) {
			throw new MissingParameterError(ProductInfoException.GROUP.GENERIC, "Store Code is null or empty");
		} else if (CommonUtil.isEmpty(productItem.getTrackingNumber())) {
			throw new MissingParameterError(ProductInfoException.GROUP.GENERIC, "Tracking Number is null or empty");
		}
		return true;
	}
}
