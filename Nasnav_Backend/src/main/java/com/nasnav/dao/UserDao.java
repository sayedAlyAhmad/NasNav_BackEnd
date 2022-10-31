package com.nasnav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasnav.entity.User;



 
public interface UserDao extends JpaRepository<User, Long>{

}
