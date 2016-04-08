package com.fsm.app.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.User;
import com.fsm.app.service.BlogService;
import com.fsm.app.service.UserService;

@Controller
public class UserController {
	
	
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	
	
	
	
	@RequestMapping(value="/account")
	public String showAccount(Model model, Principal principal){
		String name=principal.getName();
		model.addAttribute("user",userService.findOneWithBlogs(name));
		return "account";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String addBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal){
		
		if(result.hasErrors()){
			return showAccount(model, principal);
		}
		
		String name=principal.getName();
		blogService.save(blog,name);
		return "redirect:/account.html";
	}
	
	@RequestMapping(value="/blog/remove/{id}")
	public String deleteBLog(@PathVariable int id){
		Blog blog=blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
	
	
}
