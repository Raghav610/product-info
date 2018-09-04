package com.rao.test.productinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rao.test.productinfo.domain.Product;
import com.rao.test.productinfo.exception.EmptyResponseException;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name) throws EmptyResponseException;

}
