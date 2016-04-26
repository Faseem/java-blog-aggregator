package com.fsm.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsm.app.entity.User;
import com.fsm.app.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	@RequestMapping
	public String getRegister(){
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result){
		System.out.println("Inthe methid");
		if(result.hasErrors()){
			return "register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String name){
		boolean available=userService.findOne(name)==null;
		return String.valueOf(available);
	}
}
