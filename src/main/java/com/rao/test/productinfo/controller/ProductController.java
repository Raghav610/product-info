package com.rao.test.productinfo.controller;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;
import com.rao.test.productinfo.domain.Product;
import com.rao.test.productinfo.domain.ProductInTransit;
import com.rao.test.productinfo.domain.ProductItem;
import com.rao.test.productinfo.exception.BadRequestException;
import com.rao.test.productinfo.exception.EmptyResponseException;
import com.rao.test.productinfo.exception.ProductInfoException;
import com.rao.test.productinfo.repository.ProductRepository;
import com.rao.test.productinfo.repository.ProductRepositoryImpl;
import com.rao.test.productinfo.utils.ErrorInfo;
import com.rao.test.productinfo.utils.SuccessResponse;
import com.rao.test.productinfo.validation.RequestValidator;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	RequestValidator requestValidator;
	
	@GetMapping("getAll")
	public Iterable<Product> getAllProduct() throws Exception{
		return productRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET ,value ="/getByName/{name}" , produces= "application/json")
	public Product getProductByName(@PathVariable String name) throws EmptyResponseException{
		return productRepository.findByName(name);

	}

	@GetMapping("/productbyId/{id}")
	public Product getProductById(@PathVariable Integer id) {
		java.util.Optional<Product> product = productRepository.findById(id);
		return product.get();
	}

	@DeleteMapping("/delProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		productRepository.deleteById(id);
		Gson gson = new Gson();
		/*return new ResponseEntity<>(gson.toJson(new SuccessResponse(messageSource.getMessage(ProductConstants.DELETED_SUCCESSFULLY,
				new Object[] { ProductConstants.PRODUCT }, Locale.US))),
				HttpStatus.OK);*/
		return null;
	}

	@PostMapping(path="/addProduct" , 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createProduct(@RequestBody Product productDTO){

		Product product = productRepository.save(productDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{/id}").buildAndExpand(product.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(path="/updateProduct/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProduct(@RequestBody Product productDTO ,
			@PathVariable Integer id){

		Optional<Product> existProduct = productRepository.findById(id);

		if (!existProduct.isPresent())
			return ResponseEntity.notFound().build();

		productDTO.setId(id);
		productRepository.save(productDTO);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/validationCheck")
	public ResponseEntity<?> validationCheck(@Valid @RequestBody ProductInTransit productInTransit) throws NoSuchMessageException, BadRequestException, ProductInfoException{

		SuccessResponse successResponse = new SuccessResponse();
		ErrorInfo errorInfo = new ErrorInfo();

		String sku = null;

		for(ProductItem productItem : productInTransit.getItemList()) {

			requestValidator.isValidRequest(productItem);	
			sku = productItem.getSKU();
		}

		Map<String,String> mapReq = ProductRepositoryImpl.populateRequestParam(productInTransit);

		mapReq.forEach((k,v) -> System.out.println("Key = "   + k + ", Value = " + v));

		String result = ProductRepositoryImpl.getResult(sku);

		System.out.println("RESULTS : " + result);

		String respArr[] = result.split(":");

		if(respArr[0].contains("SUCCESS")) {
			successResponse.setShipmentId(respArr[1]);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}else {
			errorInfo.setErrorCode(500);
			errorInfo.setErrorMessage(respArr[1]);
			return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
