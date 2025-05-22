package kr.ac.kopo.petshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.petshop.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Product> list() {
		return sql.selectList("product.list");
	}

	@Override
	public void add(Product item) {
		sql.insert("product.add", item);
		
	}

	@Override
	public Product item(String productId) {
		return sql.selectOne("product.item", productId);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
		
	}

	@Override
	public void delete(String productId) {
		sql.delete("product.delete", productId);
		
	}


}
