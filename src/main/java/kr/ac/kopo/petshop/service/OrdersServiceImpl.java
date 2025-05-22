package kr.ac.kopo.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.petshop.dao.OrdersDao;
import kr.ac.kopo.petshop.model.Detail;
import kr.ac.kopo.petshop.model.Orders;
@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	OrdersDao dao;
	
	@Override
	public List<Orders> list(String memberId) {
		return dao.list(memberId);
	}

	@Override
	public void order(Orders item) {
		dao.add(item);
		
		for(Detail detail : item.getDetails()) {
			detail.setOrdersId(item.getOrdersId());
			
			dao.addDetail(detail);
		}
	}

	@Override
	public Orders item(Long ordersId) {
		return dao.item(ordersId);
	}

	@Override
	public void delete(String ordersId) {
		dao.delete(ordersId);

	}

	@Override
	public List<Orders> list() {
		return dao.list();
	}

}
