package com.fsm.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog, Pageable pageable);

}
