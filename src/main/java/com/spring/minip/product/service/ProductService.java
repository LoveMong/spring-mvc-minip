package com.spring.minip.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.spring.minip.product.domain.ProductDto;

public interface ProductService {
	
    List<ProductDto> productList() throws Exception;
    
    int countProduct() throws Exception;
    
    List<ProductDto> productList(Map<String, Integer> map);
    
    int registerProduct(ProductDto productDto);
    
    void deleteProduct(int num) throws Exception;
    
    ProductDto searchProduct(int num) throws Exception;
    
    void updateProduct(ProductDto productDto, MultipartFile file) throws Exception;
    
}
