package com.fsm.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Transactional
@Service
public class InitDbService {
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		List<Role> roles = new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(userRole);

		User adminUser = new User();
		adminUser.setName("admin");
		adminUser.setEnabled(true);
		adminUser.setRoles(roles);
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
		adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
		//adminUser.setPassword("admin");
		userRepository.save(adminUser);

		Blog myBlog = new Blog();
		myBlog.setName("FSM Blog");
		myBlog.setUrl("http://www.djfaseem.wordpress.com");
		myBlog.setUser(adminUser);
		blogRepository.save(myBlog);

		Item item1 = new Item();
		item1.setTitle("First");
		item1.setDescription("My Fistrs Discription");
		item1.setPublishedDate((new Date()).toString());
		item1.setBlog(myBlog);
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setTitle("Second");
		item2.setDescription("My Second Discription");
		item2.setPublishedDate((new Date()).toString());
		item2.setBlog(myBlog);
		itemRepository.save(item2);

	}
}
