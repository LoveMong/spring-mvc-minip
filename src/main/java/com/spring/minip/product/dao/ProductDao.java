package com.spring.minip.product.dao;

import java.util.List;
import java.util.Map;

import com.spring.minip.product.domain.ProductDto;

public interface ProductDao {

	List<ProductDto> productList();
	
	int countProduct();
	
	List<ProductDto> searchProductList(Map<String, Integer> map);
	
	int registerProduct(ProductDto productDto);
	
	void deleteProduct(int num);
	
	ProductDto searchProduct(int num);
	
}
