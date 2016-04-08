package com.fsm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	List<Blog> findByUser(User user);
}
