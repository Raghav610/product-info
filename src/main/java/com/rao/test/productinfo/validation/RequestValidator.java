/*package com.rao.test.productinfo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RequestValidator implements Validator{

	@Autowired
	@Qualifier("customMessageResource")
	MessageSource messageSource;


	// Validate SPCode,start for InventoryDispositionCategory
	public void validateCategory(String spcode) throws ClientException {


		if(CommonUtil.isEmpty(spcode.trim())){
			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("empty.request.parameter",
							new Object[] { spcode, "spcode" }, null), null);                  

		}

		else if (!CommonUtil.isValidLength(spcode, 3)) {                             

			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("large.request.parameter",
							new Object[] { spcode, "spcode",3 }, null), null);

		}

	}

	// Validate SPCode,end for InventoryDispositionCategory


	// Validate SPCode,start for InventoryMaster

	public void validateDivision(String sku) throws ClientException{

		if(CommonUtil.isEmpty(sku.trim())){
			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("empty.request.parameter",
							new Object[] { sku, "sku" }, null), null);

		}                              
		else if (!CommonUtil.isValidLength(sku, 9)) {


			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("large.request.parameter",
							new Object[] { sku, "sku",9 }, null), null);

		}

		// Validate SPCode,end for InventoryMaster

	}

	// Validate  sku,vendorNumber and locationType for InventoryDisposition,start

	public void validateExpiryDate(String sku, String vendorNumber, String locationType) throws ClientException{

		if(CommonUtil.isEmpty(sku.trim())){
			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("empty.request.parameter",
							new Object[] { sku, "sku" }, null), null);                 

		}

		else if (!CommonUtil.isValidLength(sku, 14)) {                  

			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("large.request.parameter",
							new Object[] { sku, "sku",14 }, null), null);

		}

		if(CommonUtil.isEmpty(vendorNumber.trim())){
			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("empty.request.parameter",
							new Object[] { vendorNumber, "vendorNumber" }, null), null);                                

		}

		else if (!CommonUtil.isValidLength(vendorNumber, 6)) {                            

			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("large.request.parameter",
							new Object[] { vendorNumber, "vendorNumber",6 }, null), null);

		}

		if(CommonUtil.isEmpty(locationType.trim())){
			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("empty.request.parameter",
							new Object[] { locationType, "locationType" }, null), null);                          

		}

		else if (!CommonUtil.isValidLength(locationType, 1)) {                 

			throw new ClientException(Integer.parseInt(messageSource
					.getMessage(Constants.VALIDATION_ERROR_CODE, null, null)),
					messageSource.getMessage("large.request.parameter",
							new Object[] { locationType, "locationType",1}, null), null);

		}

		// Validate  sku,vendorNumber and locationType for InventoryDisposition,end
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
*/