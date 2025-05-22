package kr.ac.kopo.petshop.service;

import java.util.List;

import kr.ac.kopo.petshop.model.Product;

public interface ProductService {

	List<Product> list();

	void add(Product item);

	Product item(String productId);
	
	void update(Product item);
	
	void delete(String productId);

	


}
