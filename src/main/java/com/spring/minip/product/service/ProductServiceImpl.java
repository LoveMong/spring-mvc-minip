package com.spring.minip.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.minip.product.dao.ProductDao;
import com.spring.minip.product.domain.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

	@Override
	public List<ProductDto> productList() throws Exception {
		return productDao.productList();
	}

	@Override
	public int countProduct() throws Exception {
		return productDao.countProduct();
	}

	@Override
	public List<ProductDto> productList(Map<String, Integer> map) {
		return productDao.searchProductList(map);
	}

	@Override
	public int registerProduct(ProductDto productDto) {
		return productDao.registerProduct(productDto);
	}

	@Override
	public void deleteProduct(int num) throws Exception {
		productDao.deleteProduct(num);
	}
	
	

    


}
