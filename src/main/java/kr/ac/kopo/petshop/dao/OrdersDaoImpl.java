package kr.ac.kopo.petshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.petshop.model.Detail;
import kr.ac.kopo.petshop.model.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Orders> list(String memberId) {
		return sql.selectList("orders.list_member", memberId);
	}

	@Override
	public void add(Orders item) {
		sql.insert("orders.add", item);

	}

	@Override
	public void addDetail(Detail detail) {
		sql.insert("orders.add_detail", detail);
	}

	@Override
	public Orders item(Long ordersId) {
		return sql.selectOne("orders.item", ordersId);
	}

	@Override
	public void delete(String ordersId) {
		sql.delete("orders.delete", ordersId);
	}

	@Override
	public List<Orders> list() {
		return sql.selectList("orders.list");
	}

}
