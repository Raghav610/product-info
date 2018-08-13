package com.rao.test.productinfo.controller;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
import com.rao.test.productinfo.domain.ProductDTO;
import com.rao.test.productinfo.exception.EmptyResponseException;
import com.rao.test.productinfo.exception.SuccessResponse;
import com.rao.test.productinfo.repository.ProductRepository;
import com.rao.test.productinfo.utils.ProductConstants;

@RestController
public class ProductController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("getAll")
	public Iterable<Product> getAllProduct() throws Exception{
		return productRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET ,value ="/getByName/{name}" , produces= "application/json")
	public Product getProductByName(@PathVariable String name) throws EmptyResponseException{
		return productRepository.findByName(name);

	}

	@GetMapping("/productbyId/{id}")
	public Product getProductById(@PathVariable Integer id){
		java.util.Optional<Product> product = productRepository.findById(id);
		return product.get();
	}

	/*@GetMapping("/delProduct/{id}")
	public void deleteProduct(@PathVariable Integer id){
		productRepository.deleteById(id);
	}*/
	
	@DeleteMapping("/delProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		productRepository.deleteById(id);
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(new SuccessResponse(messageSource.getMessage(ProductConstants.DELETED_SUCCESSFULLY,
				new Object[] { ProductConstants.PRODUCT }, Locale.US))),
		HttpStatus.OK);
	}
	

	@PostMapping("/students")
	public ResponseEntity<Object> createProduct(@RequestBody Product productDTO){

		Product product = productRepository.save(productDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{/id}").buildAndExpand(product.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product productDTO ,
			@PathVariable Integer id){
		
	Optional<Product> existProduct = productRepository.findById(id);
	
	if (!existProduct.isPresent())
		return ResponseEntity.notFound().build();
	
		productDTO.setId(id);
		productRepository.save(productDTO);
		return ResponseEntity.noContent().build();
	
	}
}
