package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;
import com.project.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/registerUser")
	public ModelAndView registerUser() {
		return new ModelAndView("registration","registerVO",new RegisterVO());
	}
	
	@PostMapping(value = "saveUser")
	public ModelAndView saveUser(@ModelAttribute RegisterVO registerVO){
		
		System.out.println(":: in save User ::"+registerVO.getFirstName());
		System.out.println(":: in save User ::"+registerVO.getLoginVO().getUserName());
		
		registerVO.getLoginVO().setRole("ROLE_USER");
		
		this.loginService.savelLoginVO(registerVO.getLoginVO());
		
		this.registerService.saveUser(registerVO);
		
		return new ModelAndView("redirect:/");
	}
}
