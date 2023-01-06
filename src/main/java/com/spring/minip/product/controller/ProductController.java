package com.spring.minip.product.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mimip.util.UploadFileUtils;
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
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
    @GetMapping("/list")
    public String productList(@RequestParam(value = "page", defaultValue = "1") int page,
    						  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model, HttpServletRequest request) throws Exception {
    	
    	if (!loginCheck(request)) {
    		return "redirect:/login/login?toUrl=" + request.getRequestURI(); 			
		}
    	
    	
    	
    	
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
    public String registerProduct(ProductDto productDto, MultipartFile file) throws Exception {
    	
    	log.info("productDto : " + productDto);
    	log.info("file : " + file);
    	
        String imgUploadPath = uploadPath + File.separator + "imgUpload";
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
        String fileName = null;
        
        if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
           fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
        } else {
           fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
        }
        
        productDto.setPictureUrl(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
        productDto.setThumbUrl(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
        
        productService.registerProduct(productDto);
    	
    	
    	return "redirect:/product/list";
    }
    
    
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("num") int num) {
    	
    	
    	try {
    		productService.deleteProduct(num);
    	} catch (Exception e) {
			e.printStackTrace();
		}	
    	return "redirect:/product/list";
    }
    
    
    @GetMapping("/update")
    public String update(@RequestParam("num") int num, Model model, RedirectAttributes rattr) {
    	
    	String msg = "NO_SEARCH_ERR";
    	
    	try {
    		ProductDto productDto = productService.searchProduct(num);
    		model.addAttribute("product", productDto);
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", msg);
			return "redirect:/product/list";
		}
    	
    	return "/product/productUpdate";
    	
    }
    
    @PostMapping("/update")
    public String update(ProductDto productDto, MultipartFile file, Model model) {
    	
    	log.info("productDto : " + productDto);
    	log.info("file : " + file.getOriginalFilename());
    	
    	try {
    		productService.updateProduct(productDto, file);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("product", productDto);
			model.addAttribute("msg", "UPDATE_ERR");
			
			return "/product/productUpdate";
		}
    	
    	return "redirect:/product/list";
    	
    }
    
    
    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서(false는 session이 없어도 새로 생성하지 않는다. 반환값 null)
        HttpSession session = request.getSession(false);
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session!=null && session.getAttribute("memberInfo")!=null;
    }

}
