package kr.ac.kopo.petshop.service;

import java.util.List;

import kr.ac.kopo.petshop.model.Orders;

public interface OrdersService {

	List<Orders> list(String memberId);

	void order(Orders item);

	Orders item(Long ordersId);

	void delete(String ordersId);
	
	List<Orders> list();



}
