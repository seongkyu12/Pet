package kr.ac.kopo.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.petshop.dao.ProductDao;
import kr.ac.kopo.petshop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao dao;

	@Override
	public List<Product> list() {
		return dao.list();
	}

	@Override
	public void add(Product item) {
		dao.add(item);
	}

	@Override
	public Product item(String productId) {
		return dao.item(productId);
	}

	@Override
	public void update(Product item) {
		dao.update(item);
	}

	@Override
	public void delete(String productId) {
		dao.delete(productId);
		
	}
	


}
