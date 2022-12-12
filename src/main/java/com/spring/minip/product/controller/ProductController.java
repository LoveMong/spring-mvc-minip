package com.spring.minip.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.minip.board.domain.PageHandler;
import com.spring.minip.product.domain.ProductDto;
import com.spring.minip.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

/**
 * 회원정보 수정 기능을 위한 클래스 *
 * @Project : spring-minip
 * @Date : 2022-06-28
 * @Author : L
 */
@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
    @GetMapping("/list")
    public String productList(@RequestParam(value = "page", defaultValue = "1") int page,
    						  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) throws Exception {
    	
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);

        int totalCnt = productService.countProduct();
        PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
    	
    	
    	List<ProductDto> productList = productService.productList(map);
    	
    	model.addAttribute("productList", productList);
    	model.addAttribute("ph", pageHandler);
    	

    	
        return "/product/productList";

    }
    
    
    @GetMapping("/register")
    public String registerProduct() {
    	return "/product/productRegister";
    }
    
    
    @PostMapping("/register")
    public String registerProduct(ProductDto productDto, @RequestParam(required = false, value = "pictureUrl") MultipartFile file) {
    	
    	log.info("productDto : " + productDto);
    	log.info("file : " + file);
    	
    	
    	
    	
    	
    	
    	return "redirect:/product/list";
    }


}
