package kr.ac.kopo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.petshop.model.Member;
import kr.ac.kopo.petshop.service.MemberService;

@Controller
public class RootController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/")
	String index() {
		return "index";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@PostMapping("/login")
	String login(Member item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("member", item);
			
			return "redirect:.";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
	
	@GetMapping("/signup")
	String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	String signup(Member item) {
		service.signup(item);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/id_check/{memberId}")
	String idCheck(@PathVariable String memberId) {
		
		if(service.isUnique(memberId))
			return "OK";
		return "FAIL";
	}
}
