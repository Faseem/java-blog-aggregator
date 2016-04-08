package com.fsm.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.Item;
import com.fsm.app.entity.Role;
import com.fsm.app.entity.User;
import com.fsm.app.repository.BlogRepository;
import com.fsm.app.repository.ItemRepository;
import com.fsm.app.repository.RoleRepository;
import com.fsm.app.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}



	public User findOneWithBlogs(int id) {
		// TODO Auto-generated method stub
		User user=findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		for(Blog blog : blogs){
			List<Item> items=itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "title"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);

		return user;
	}



	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}



	public User findOneWithBlogs(String name) {
		User user=userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}



	public void delete(int id) {
		userRepository.delete(id);
	}
}
