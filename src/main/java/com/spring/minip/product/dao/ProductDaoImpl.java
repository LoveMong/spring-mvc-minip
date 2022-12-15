package com.spring.minip.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.minip.product.domain.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private SqlSession session; //  SQL 명령을 수행하는데 필요한 메서드 제공(SqlSession의 주요 메서드 확인 필요)

    private static String namespace = "com.spring.minip.product.dao.ProductMapper.";

    @Override
    public List<ProductDto> productList(){
        return session.selectList(namespace + "selectAll");
    }

	
	@Override
	public int countProduct() {
		return session.selectOne(namespace + "countProduct");
	}

	@Override
	public List<ProductDto> searchProductList(Map<String, Integer> map) {
		return session.selectList(namespace + "searchProductList", map);
	}


	@Override
	public int registerProduct(ProductDto productDto) {
		return session.insert(namespace + "registerProduct", productDto);
	}


	@Override
	public void deleteProduct(int num) {
		session.delete(namespace + "deleteProduct", num);
	}
	
	


	


}
