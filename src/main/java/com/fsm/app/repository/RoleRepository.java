package com.fsm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.app.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
