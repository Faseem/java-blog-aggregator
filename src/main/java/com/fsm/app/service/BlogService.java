package com.fsm.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.Item;
import com.fsm.app.entity.User;
import com.fsm.app.exception.RssException;
import com.fsm.app.repository.BlogRepository;
import com.fsm.app.repository.ItemRepository;
import com.fsm.app.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RssService rssService;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	public void saveItems(Blog blog){
		try {
			System.out.println("save Item");
			List<Item> items=rssService.getItems(blog.getUrl());
			for(Item item : items){
				System.out.println("got Items");
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if(savedItem==null){
					item.setBlog(blog);
					itemRepository.save(item);
				}
				
			}
		} catch (RssException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(Blog blog, String name) {
		User user=userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}
	
	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs(){
		List<Blog> blogs=blogRepository.findAll();
		for(Blog blog:blogs){
			saveItems(blog);
		}
	}
}
