package kr.ac.kopo.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.petshop.model.Member;
import kr.ac.kopo.petshop.model.Product;
import kr.ac.kopo.petshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	final String path ="product/";


	@Autowired
	ProductService service;
	
	@GetMapping("/list")
	String list(Model model) {
		List<Product> list = service.list();
		
		model.addAttribute("list",list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Product item, @SessionAttribute Member member) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{productId}")
	String update(@PathVariable String productId, Model model) {
		Product item = service.item(productId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{productId}")
	String update(@PathVariable String productId, Product item, @SessionAttribute Member member) {
		item.setProductId(productId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{productId}")
	String delete(@PathVariable String productId) {
		service.delete(productId);
		
		return "redirect:../list";
	}
}