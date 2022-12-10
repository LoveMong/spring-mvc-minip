package com.spring.minip.product.domain;


import lombok.Data;

@Data
public class ProductDto {

	private Integer code;
	private String name;
	private Integer price;
	private String description;
	private String pictureUrl;


}
