package kr.ac.kopo.petshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.petshop.model.Cart;
import kr.ac.kopo.petshop.model.Detail;
import kr.ac.kopo.petshop.model.Member;
import kr.ac.kopo.petshop.model.Orders;
import kr.ac.kopo.petshop.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	final String path = "orders/";
	
	@Autowired
	OrdersService service;
	
	@GetMapping("/list")
	String list(@SessionAttribute Member member, Model model) {
		List<Orders>list = service.list(member.getMemberId());
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping
	String order(@SessionAttribute Member member,@SessionAttribute Cart cart, HttpSession session) {
		Orders item = new Orders();
		
		item.setMemberId(member.getMemberId());
		
		Map<Long, Integer> map = cart.getCart();
		ArrayList<Detail> details = new ArrayList<Detail>();
		
		for(Long productId : map.keySet()) {
			Detail detail = new Detail();
			
			detail.setProductId(productId);
			detail.setAmount(map.get(productId));
			
			details.add(detail);
		}
		
		item.setDetails(details);
		
		service.order(item);
		
		session.removeAttribute("cart");
		
		return "redirect:/orders/" + item.getOrdersId();
	}
	
	@GetMapping("/{ordersId}")
	String view(@PathVariable Long ordersId, @SessionAttribute Member member, Model model) {
		Orders item = service.item(ordersId);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	@GetMapping("/delete/{ordersId}")
	String delete(@PathVariable String ordersId) {
		service.delete(ordersId);
		
		return "redirect:../list";
	}
}
