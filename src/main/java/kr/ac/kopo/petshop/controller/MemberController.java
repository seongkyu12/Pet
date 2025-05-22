package kr.ac.kopo.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.petshop.model.Member;
import kr.ac.kopo.petshop.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	final String path = "member/";
	
	@Autowired
	MemberService service;
	
	@GetMapping("/list")
	String list(Model model) {
		List<Member> list = service.list();
		
		model.addAttribute("list",list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Member item) {
		
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{memberId}")
	String update(@PathVariable String memberId, Model model) {
		Member item = service.item(memberId);
		
		model.addAttribute("item", item);
		
		
		return path + "update";
	}
	
	@PostMapping("/update/{memberId}")
	String update(@PathVariable String memberId, Member item) {
		item.setMemberId(memberId);
		
		service.update(item);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{memberId}")
	String delete(@PathVariable String memberId) {
		service.delete(memberId);
		
		return "redirect:../list";
	}
}
