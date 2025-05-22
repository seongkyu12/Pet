package kr.ac.kopo.petshop.dao;

import java.util.List;

import kr.ac.kopo.petshop.model.Detail;
import kr.ac.kopo.petshop.model.Orders;

public interface OrdersDao {

	List<Orders> list(String memberId);

	void add(Orders item);

	void addDetail(Detail detail);

	Orders item(Long ordersId);

	void delete(String ordersId);

	List<Orders> list();

}
