package com.spring.minip.product.service;

import java.util.List;
import java.util.Map;

import com.spring.minip.product.domain.ProductDto;

public interface ProductService {
	
    List<ProductDto> productList() throws Exception;
    
    int countProduct() throws Exception;
    
    List<ProductDto> productList(Map<String, Integer> map);
    
}