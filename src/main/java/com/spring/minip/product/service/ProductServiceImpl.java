package com.spring.minip.product.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mimip.util.UploadFileUtils;
import com.spring.minip.product.dao.ProductDao;
import com.spring.minip.product.domain.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    
    @Resource(name = "uploadPath")
	private String uploadPath;

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

	@Override
	public ProductDto searchProduct(int num) throws Exception {
		
		ProductDto productDto = productDao.searchProduct(num);
		
		if (productDto == null) {
			throw new Exception("NoSearchErr");
		}
		
		return productDto;	
	}

	@Override
	public void updateProduct(ProductDto productDto, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
        String fileName = null;
        
        System.out.println("file name : " + file.getOriginalFilename());
        
        
        if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
        	
        	fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
           
        	productDto.setPictureUrl(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
        	productDto.setThumbUrl(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
           
        }
		
		productDao.updateProduct(productDto);
		
	}
	


}
